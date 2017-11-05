package application.controller;

import java.awt.Button;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainController implements EventHandler<ActionEvent> {
	
	
	public void handle(ActionEvent event) {
		// print a message to the console (debugging step, to ensure everything is connected)
		try {
			// change over to a second view
			Parent root = FXMLLoader.load(getClass().getResource("/SecondView.fxml"));   // Load the FXML
			Main.stage.setScene(new Scene(root, 800, 800));							   // Add the scene to the stage
			Main.stage.show();		
			// Show the stage to the user
		}catch(Exception e) {
			e.printStackTrace(); // TODO: app should do something more productive if errors occur...
		}
	}
		public void handleOptions(ActionEvent event) {
			try {
				// change over to a second view
				Parent root = FXMLLoader.load(getClass().getResource("/OptionsView.fxml"));   // Load the FXML
				Main.stage.setScene(new Scene(root, 500, 575));							   // Add the scene to the stage
				Main.stage.show();														   // Show the stage to the user
			}catch(Exception e) {
				e.printStackTrace(); // TODO: app should do something more productive if errors occur...
			}
		}
	
	public void handleCloseButton(ActionEvent event) {
		Platform.exit();
	}
	
		
	}
	

