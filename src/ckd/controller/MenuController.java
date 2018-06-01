package ckd.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class MenuController {
	
	public void actionClose (ActionEvent event){
		Platform.exit();
		System.exit(1);
		
	}

}
