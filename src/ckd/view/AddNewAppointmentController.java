package ckd.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddNewAppointmentController {
	ObservableList<String> appointmentTypeList = 
			FXCollections.observableArrayList("X-Ray", "B","C");
	ObservableList<String> physicianList = 
			FXCollections.observableArrayList("Dr. Anderson", "Dr. Marry");
	
	// CREATE APPOINTMENT
	@FXML
	private TextField patientnameField;
	@FXML
	private TextField patientIDField;
	@FXML
	private ChoiceBox appointmentTypeField;
	@FXML
	private ChoiceBox physicianField;
	@FXML
	private DatePicker dateAppointmentField;
	@FXML
	private TextField timeAppointmentField;
	@FXML
	private TextArea reasonField;
		
	@FXML
	private void initialize() {
		appointmentTypeField.setItems(appointmentTypeList);
		appointmentTypeField.setValue("mm");
	
		physicianField.setItems(physicianList);
		physicianField.setValue("mm");
			
		}	
}
