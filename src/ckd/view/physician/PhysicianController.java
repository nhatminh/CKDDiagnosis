package ckd.view.physician;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import ckd.Main;
import ckd.controller.utils.VisualizeDecisionTree;
import ckd.model.MedicalRecord;
import ckd.model.MedicalRecordSelected;
import ckd.model.PersonalInfo;
import ckd.model.DBAdapter.DBConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import weka.gui.beans.TextViewer;

public class PhysicianController implements Initializable {
	private ObservableList<PersonalInfo> oblist;
	private ObservableList<MedicalRecord> oblist2;
	private ObservableList<MedicalRecordSelected> oblist3;

	private class RowSelectChangeListener implements ChangeListener<Number> {
		@Override
		public void changed(ObservableValue<? extends Number> ov, Number oldVal, Number newVal) {
			// TODO Auto-generated method stub
			int ix = newVal.intValue();

			if ((ix < 0) || (ix >= oblist.size())) {

				return; // invalid data
			}

			PersonalInfo p = oblist.get(ix);

			try {
				Connection con = DBConnection.getConnection();
				oblist3 = FXCollections.observableArrayList();
				String sql = "SELECT * from medical_record WHERE id= " + p.getId() + " ";
				ResultSet rs = con.createStatement().executeQuery(sql);
				while (rs.next()) {
					oblist3.add(new MedicalRecordSelected(rs.getInt("id"), rs.getString("sg"), rs.getString("sc"),
							rs.getString("hemo"), rs.getString("dm"), rs.getString("pe"), rs.getString("is_ckd")));
				}
			} catch (SQLException ex) {
				Logger.getLogger(PhysicianController.class.getName()).log(Level.SEVERE, null, ex);
			}

			colIDDetails.setCellValueFactory(new PropertyValueFactory<>("id"));
			colsg.setCellValueFactory(new PropertyValueFactory<>("sg"));
			colsc.setCellValueFactory(new PropertyValueFactory<>("sc"));
			colhemo.setCellValueFactory(new PropertyValueFactory<>("hemo"));
			coldm.setCellValueFactory(new PropertyValueFactory<>("dm"));
			colpe.setCellValueFactory(new PropertyValueFactory<>("pe"));
			colClassDetails.setCellValueFactory(new PropertyValueFactory<>("is_ckd"));

			tablePatientListDetails.setItems(oblist3);

			// txtSelectedID.setText(String.valueOf(p.getId()));
		}
	}

	// DEFINE TABLE PATIENT LIST
	@FXML
	private TableView<PersonalInfo> tablePatientList;
	@FXML
	private TableColumn<PersonalInfo, Integer> colID;
	@FXML
	private TableColumn<PersonalInfo, String> colName;
	@FXML
	private TableColumn<PersonalInfo, String> colGender;
	@FXML
	private TableColumn<PersonalInfo, String> colAge;
	@FXML
	private TableColumn<PersonalInfo, String> colClass;
	@FXML
	private TableColumn colControl;

	// DEFINE TABLE RECORD DETAIL OF PATIENT LIST
	@FXML
	private TableView<MedicalRecordSelected> tablePatientListDetails;
	@FXML
	private TableColumn<MedicalRecordSelected, Integer> colIDDetails;
	@FXML
	private TableColumn<MedicalRecordSelected, String> colsg;
	@FXML
	private TableColumn<MedicalRecordSelected, String> colsc;
	@FXML
	private TableColumn<MedicalRecordSelected, String> colhemo;
	@FXML
	private TableColumn<MedicalRecordSelected, String> coldm;
	@FXML
	private TableColumn<MedicalRecordSelected, String> colpe;
	@FXML
	private TableColumn<MedicalRecordSelected, String> colClassDetails;

	// DEFINE TABLE RECORD DETAIL OF CURRENT PATIENT
	@FXML
	private TableView<MedicalRecord> tableCurrentPatienDetails;
	@FXML
	private TableColumn<MedicalRecord, Integer> colIDCurrentDetails;
	@FXML
	private TableColumn<MedicalRecord, String> colcur_sg;
	@FXML
	private TableColumn<MedicalRecord, String> colcur_sc;
	@FXML
	private TableColumn<MedicalRecord, String> colcur_hemo;
	@FXML
	private TableColumn<MedicalRecord, String> colcur_dm;
	@FXML
	private TableColumn<MedicalRecord, String> colcur_pe;

	@FXML
	TextField txtSelectedID;
	@FXML
	Button btnViewRec;
	@FXML
	Button btnViewMedicalRec;
	@FXML
	Button btnAgree;
	@FXML
	Button btnDisagree;
	@FXML
	Button btnPrint;
	@FXML
	Label lblCKDresult;

	@FXML
	ImageView imgDTRule;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// txtSelectedID.setText(String.valueOf(p.getId()));

		try {
			Connection con = DBConnection.getConnection();
			oblist = FXCollections.observableArrayList();
			String sql = "SELECT DISTINCT * from personal_info INNER JOIN medical_record ON personal_info.id=medical_record.id";
			ResultSet rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				oblist.add(new PersonalInfo(rs.getInt("id"), rs.getString("full_name"), rs.getString("gender"),
						rs.getString("age"), rs.getString("is_ckd")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(PhysicianController.class.getName()).log(Level.SEVERE, null, ex);
		}

		colID = new TableColumn("ID");
		colName = new TableColumn("Name");
		colGender = new TableColumn("Gender");
		colAge = new TableColumn("Age");
		colClass = new TableColumn("Class");
		colControl = new TableColumn("Control");

		setCellValueFactories();

		// TableColumn controlCol = new TableColumn("Control");
		tablePatientList.getColumns().addAll(colID, colName, colGender, colAge, colClass, colControl);

		tablePatientList.getSelectionModel().selectedIndexProperty().addListener(new RowSelectChangeListener());

		tablePatientList.setItems(oblist);
		// tblPatientList.getSelectionModel().select(0);

	}

	public void viewMedical(ActionEvent actionEvent) {
		try {
			Connection con = DBConnection.getConnection();
			oblist2 = FXCollections.observableArrayList();
			String sql = "SELECT * from medical_record WHERE id= " + txtSelectedID.getText() + " ";
			ResultSet rs = con.createStatement().executeQuery(sql);
			while (rs.next()) {
				oblist2.add(new MedicalRecord(rs.getInt("id"), rs.getString("sg"), rs.getString("sc"),
						rs.getString("hemo"), rs.getString("dm"), rs.getString("pe")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(PhysicianController.class.getName()).log(Level.SEVERE, null, ex);
		}

		colIDCurrentDetails.setCellValueFactory(new PropertyValueFactory<>("id"));
		colcur_sg.setCellValueFactory(new PropertyValueFactory<>("sg"));
		colcur_sc.setCellValueFactory(new PropertyValueFactory<>("sc"));
		colcur_hemo.setCellValueFactory(new PropertyValueFactory<>("hemo"));
		colcur_dm.setCellValueFactory(new PropertyValueFactory<>("dm"));
		colcur_pe.setCellValueFactory(new PropertyValueFactory<>("pe"));

		tableCurrentPatienDetails.setItems(oblist2);

	}

	private void setCellValueFactories() {
		// idCol.setCellValueFactory(
		// new PropertyValueFactory<Patient,String>("id")
		// );
		// idCol.setMinWidth(120);
		// nameCol.setCellValueFactory(
		// new PropertyValueFactory<Patient,String>("name")
		// );
		// nameCol.setMinWidth(120);
		// classCol.setCellValueFactory(
		// new PropertyValueFactory<Patient,String>("pclass")
		// );
		// classCol.setMinWidth(120);

		colID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("full_name"));
		colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
		colClass.setCellValueFactory(new PropertyValueFactory<>("is_ckd"));
	}

	public void agree(ActionEvent actionEvent) {

	}

	public void disagree(ActionEvent actionEvent) {

	}

	public void print(ActionEvent actionEvent) {

	}

	public void viewRec(ActionEvent actionEvent) {
		try {

			boolean ckd_result;
			// ckd_result= VisualizeDecisionTree.testDecisionTree1();
			// 1.025,0.6,15.9,no,no,? <=> sg, sc, hemo, dm, pe, class
			String medicalRec = "1.025,0.6,15.9,no,no,?";
			ckd_result = VisualizeDecisionTree.detectCKD(medicalRec);

			System.out.println(ckd_result);
			if (ckd_result) {
				lblCKDresult.setText("CKD");
			} else {
				lblCKDresult.setText("Not CKD");
			}

			Image img;
			// img = VisualizeDecisionTree.testDecisionTree();
			double sc = 0.6;
			double hemo = 15.9;
			String dm = "no";
			double sg = 0.6;

			img = VisualizeDecisionTree.DTRunner(sc, hemo, dm, sg);
			imgDTRule.setImage(img);
			imgDTRule.setPreserveRatio(true);
			imgDTRule.setSmooth(true);
			imgDTRule.setCache(true);

			btnAgree.setDisable(false);
			btnDisagree.setDisable(false);
			btnPrint.setDisable(false);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
