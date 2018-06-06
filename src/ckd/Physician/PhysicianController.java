package ckd.Physician;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import ckd.model.PersonalInfo;
import ckd.model.DBAdapter.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PhysicianController implements Initializable {

	private ObservableList<PersonalInfo> oblist;

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
	private TableView tablePatientListDetails;
	@FXML
	private TableColumn colIDDetails;
	@FXML
	private TableColumn colsg;
	@FXML
	private TableColumn colsc;
	@FXML
	private TableColumn colhemo;
	@FXML
	private TableColumn coldm;
	@FXML
	private TableColumn colpe;
	@FXML
	private TableColumn colClassDetails;

	// DEFINE TABLE RECORD DETAIL OF CURRENT PATIENT
	@FXML
	private TableView tableCurrentPatienDetails;
	@FXML
	private TableColumn colIDCurrentDetails;
	@FXML
	private TableColumn colcur_sg;
	@FXML
	private TableColumn colcur_sc;
	@FXML
	private TableColumn colcur_hemo;
	@FXML
	private TableColumn colcur_dm;
	@FXML
	private TableColumn colcur_pe;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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

		colID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<>("full_name"));
		colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
		colClass.setCellValueFactory(new PropertyValueFactory<>("is_ckd"));

		tablePatientList.setItems(oblist);
	}

}
