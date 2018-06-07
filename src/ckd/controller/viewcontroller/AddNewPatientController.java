package ckd.controller.viewcontroller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import ckd.model.DBAdapter.Adapter;
import ckd.model.DBAdapter.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class AddNewPatientController {

	ObservableList<String> marriageStatusList = FXCollections.observableArrayList("Single", "Marriage", "Divorced");
	ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
	ObservableList<String> bloodTypeList = FXCollections.observableArrayList("A", "B", "AB", "O");
	
	Adapter adapter;

	// CONTACT INFORMATION
	@FXML
	private TextField fullnameField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField emailField;

	// PERSONAL INFORMATION
	@FXML
	private DatePicker dateofBirthField;
	@FXML
	private TextField ageField;
	@FXML
	private ChoiceBox genderField;
	@FXML
	private ChoiceBox marriageField;
	@FXML
	private ChoiceBox bloodTypeField;
	@FXML
	private TextField heightField;

	@FXML
	private TextArea patientNoteField;
	
	@FXML
	private Button btnCancel;

	@FXML
	private void initialize() {
		adapter = new Adapter();
		marriageField.setItems(marriageStatusList);
		marriageField.setValue("mm");

		genderField.setItems(genderList);
		genderField.setValue("mm");

		bloodTypeField.setItems(bloodTypeList);
		bloodTypeField.setValue("mm");
	}

	@FXML
	private void showAge() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int birthYear = (dateofBirthField.getValue().getYear());
		int age = year - birthYear;
		ageField.setText(Integer.toString(age));
	}

	public void registerPatient(ActionEvent actionEvent) throws SQLException {
		java.sql.Date gettedDatePickerDate = java.sql.Date.valueOf(dateofBirthField.getValue());
		System.out.println(gettedDatePickerDate);

		int pID = adapter.insertPatient(fullnameField.getText(), addressField.getText(), cityField.getText(),phoneField.getText(), emailField.getText(),gettedDatePickerDate,
				ageField.getText(),genderField.getSelectionModel().getSelectedItem().toString(),
				marriageField.getSelectionModel().getSelectedItem().toString(),
				bloodTypeField.getSelectionModel().getSelectedItem().toString(), heightField.getText(),patientNoteField.getText());
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Register Patient");
		alert.setHeaderText("Successfully add a new patient");
		alert.setContentText("Patient ID: "+ pID);
		alert.show();
	}
	
	public void cancel(ActionEvent actionEvent) {
		Stage stage = (Stage) btnCancel.getScene().getWindow();
	    stage.close();
	}
}
