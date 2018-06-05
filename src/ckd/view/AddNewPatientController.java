package ckd.view;

import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class AddNewPatientController {
	
	ObservableList<String> marriageStatusList = 
			FXCollections.observableArrayList("Single", "Marriage","Divorced");
	ObservableList<String> genderList = 
			FXCollections.observableArrayList("Male", "Female");
	ObservableList<String> bloodTypeList = 
			FXCollections.observableArrayList("A", "B", "AB", "O");
	
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
	
	//PERSONAL INFORMATION
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
	private void initialize() {
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
		ageField.setText(Integer.toString(age) + " Years");
		
	}
}
