package ckd.view.receptionist;

import java.io.IOException;

import ckd.Main;
import javafx.fxml.FXML;

public class ReceptionistController {
	
	@FXML
	private void addBtn() throws IOException {
		Main.showAddNewPatient();
	}
	@FXML
	private void appointmentBtn() throws IOException {
		Main.showPatientAppointment();
	}
	@FXML
	private void generateReportBtn() throws IOException {
		Main.generateReport();
	}
}
