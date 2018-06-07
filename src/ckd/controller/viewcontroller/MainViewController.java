package ckd.controller.viewcontroller;
import javafx.fxml.FXML;

import java.io.IOException;

import ckd.Main;

public class MainViewController {
	private Main main;
	
	@FXML
	private void goHome() throws IOException{
		main.showMainItems();
	}
}
