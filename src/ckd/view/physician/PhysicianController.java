package ckd.view.physician;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import ckd.Main;
import ckd.controller.utils.VisualizeDecisionTree;
import ckd.model.MedicalRecord;
import ckd.model.MedicalRecordSelected;
import ckd.model.PersonalInfo;
import ckd.model.DBAdapter.Adapter;
import ckd.model.DBAdapter.DBConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
	private Adapter adapter;

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
				oblist3 = FXCollections.observableArrayList();
				ArrayList<MedicalRecordSelected>med_rec = adapter.getMedicalRecord(p.getId());
				for (MedicalRecordSelected record:med_rec){
					oblist3.add(record);
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
			colDiagRec1.setCellValueFactory(new PropertyValueFactory<>("DiagRec"));
			colPhysRec1.setCellValueFactory(new PropertyValueFactory<>("PhysRec"));

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
	private TableColumn<PersonalInfo, String> colDiagRec;
	@FXML
	private TableColumn<PersonalInfo, String> colPhysRec;
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
	private TableColumn<MedicalRecordSelected, String> colDiagRec1;
	@FXML
	private TableColumn<MedicalRecordSelected, String> colPhysRec1;

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

	private MedicalRecord current_patient;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// txtSelectedID.setText(String.valueOf(p.getId()));

		try {
			adapter = new Adapter();
			update_patient_list();
			
		} catch (SQLException ex) {
			Logger.getLogger(PhysicianController.class.getName()).log(Level.SEVERE, null, ex);
		}

		colID = new TableColumn("ID");
		colName = new TableColumn("Name");
		colGender = new TableColumn("Gender");
		colAge = new TableColumn("Age");
		colDiagRec = new TableColumn("DiagRec");
		colPhysRec = new TableColumn("PhysRec");

		setCellValueFactories();

		// TableColumn controlCol = new TableColumn("Control");
		tablePatientList.getColumns().addAll(colID, colName, colGender, colAge, colDiagRec, colPhysRec);

		tablePatientList.getSelectionModel().selectedIndexProperty().addListener(new RowSelectChangeListener());

		
		// tblPatientList.getSelectionModel().select(0);

	}
	
	public void update_patient_list() throws SQLException{
		oblist = FXCollections.observableArrayList();
		ArrayList<PersonalInfo>patient_list = adapter.getPatientInfo();
		
		for (PersonalInfo p: patient_list){
			oblist.add(p);
		}
		
		tablePatientList.setItems(oblist);
	}
	
	public void viewMedical(ActionEvent actionEvent) {
		try {
			oblist2 = FXCollections.observableArrayList();
			ArrayList<MedicalRecord> med_rec = adapter.getMedicalRecord(txtSelectedID.getText());
			for (MedicalRecord record:med_rec){
				current_patient = record;
				oblist2.add(record);
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
		colID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("full_name"));
		colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
		colDiagRec.setCellValueFactory(new PropertyValueFactory<>("diagRec"));
		colPhysRec.setCellValueFactory(new PropertyValueFactory<>("physRec"));
	}

	public void agree(ActionEvent actionEvent) throws SQLException {
		String CKD_result2;
		String CKD_result1;
		if(lblCKDresult.getText().equals("CKD")){
			CKD_result1 = "ckd";
			CKD_result2 = "ckd";
		} else{
			CKD_result1 = "notckd";
			CKD_result2 = "notckd";
		}
		
		adapter.insertRecResult(current_patient, CKD_result1, CKD_result2);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Diagnosis Recommendation");
		alert.setHeaderText("Diagnosis Recommendation Result");
		alert.setContentText(CKD_result2);
		alert.show();
		update_patient_list();
		
	}

	public void disagree(ActionEvent actionEvent) throws SQLException{
		String CKD_result2;
		String CKD_result1;
		if(lblCKDresult.getText().equals("CKD")){
			CKD_result1 = "ckd";
			CKD_result2 = "notckd";
		} else{
			CKD_result1 = "notckd";
			CKD_result2 = "ckd";
		}
		adapter.insertRecResult(current_patient, CKD_result1, CKD_result2);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Diagnosis Recommendation");
		alert.setHeaderText("Diagnosis Recommendation Result");
		alert.setContentText(CKD_result2);
		alert.show();
		update_patient_list();
	}

	public void print(ActionEvent actionEvent) {

	}

	public void viewRec(ActionEvent actionEvent) {
		try {
			boolean ckd_result;
			if(current_patient!=null){
				String medicalRec = current_patient.getDTString();
				System.out.println(medicalRec);
				ckd_result = VisualizeDecisionTree.detectCKD(medicalRec);
//				ckd_result = VisualizeDecisionTree.testDecisionTree1();
				if (ckd_result) {
					lblCKDresult.setText("CKD");
				} else {
					lblCKDresult.setText("Not CKD");
				}

				Image img;

				img = VisualizeDecisionTree.DTRunner(current_patient);
				imgDTRule.setImage(img);
				imgDTRule.setPreserveRatio(true);
				imgDTRule.setSmooth(true);
				imgDTRule.setCache(true);

				btnAgree.setDisable(false);
				btnDisagree.setDisable(false);
				btnPrint.setDisable(false);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
