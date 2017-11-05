package application.controller;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class DeathScreen implements EventHandler<ActionEvent>{

	
	public void handlePlayerDeath(ActionEvent event) {
		// print a message to the console (debugging step, to ensure everything is connected)
				try {
					// change over to a second view
					Parent root = FXMLLoader.load(getClass().getResource("/DeathScreen.fxml"));   // Load the FXML
					Main.stage.setScene(new Scene(root, 500, 575));							   // Add the scene to the stage
					Main.stage.show();		
					// Show the stage to the user
				}catch(Exception e) {
					e.printStackTrace(); // TODO: app should do something more productive if errors occur...
				}
	}
	public void handleCloseButton(ActionEvent event) {
		Platform.exit();
	}
	public void handleNewGame(ActionEvent event) {
		
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}

}
