package ckd.view;

import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

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
		private ChoiceBox phoneField;
		@FXML
		private DatePicker dateAppointmentField;
		@FXML
		private DatePicker timeAppointmentField;
		
}
