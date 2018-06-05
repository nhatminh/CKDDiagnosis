package ckd.view;
import java.io.IOException;

import ckd.Main;
import javafx.fxml.FXML;

public class MainCKDController {
	
	private Main main;
	@FXML
	private void goReceptionist() throws IOException{
		Main.showReceptionistScene();
		
	}
	@FXML
	private void goPhysician() throws IOException{
		Main.showPhysicianScene();
	}
	
}
