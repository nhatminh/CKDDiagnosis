package ckd;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	public static Stage primaryStage;
	private static BorderPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) throws IOException{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Chronic Kidney Diagnostic System");
		
		showMainView();
		showMainItems();
			
	}
	
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void showMainItems() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainCKDView.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}
	
	public static void showReceptionistScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/receptionist/ReceptionDept.fxml"));
		BorderPane receptionist = loader.load();
		mainLayout.setCenter(receptionist);
	}
	
	public static void showPhysicianScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Physician/PhysicianDept2.fxml"));
		BorderPane physician = loader.load();
		mainLayout.setCenter(physician);
	}
	
	public static void showAddNewPatient() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddNewPatient.fxml"));
		Pane addNewPatient = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add New Patient");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewPatient);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();

	}
	
	public static void showPatientAppointment() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddPatientAppointment.fxml"));
		Pane addPatientAppointment = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add New Appointment");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(addPatientAppointment);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();

	}
	
	public static void generateReport() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/GenerateMonthlyReport.fxml"));
		Pane generateMonthlyReport = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Generate Monthly Report");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene = new Scene(generateMonthlyReport);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
