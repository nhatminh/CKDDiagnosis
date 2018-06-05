package ckd.Physician;

import java.io.IOException;

import ckd.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PhysicianController {
	
	//DEFINE TABLE PATIENT LIST
	@FXML 
	private TableView tablePatientList;
	@FXML
	private TableColumn colID;
	@FXML
	private TableColumn colName;
	@FXML
	private TableColumn colGender;
	@FXML
	private TableColumn colAge;
	@FXML
	private TableColumn colClass;
	@FXML
	private TableColumn colControl;
	
	
	//DEFINE TABLE RECORD DETAIL OF PATIENT LIST
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
	
	//DEFINE TABLE RECORD DETAIL OF CURRENT PATIENT
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
		
	
	
}
