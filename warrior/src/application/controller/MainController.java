package application.controller;

import java.awt.Button;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

//test
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Group;

public class MainController implements EventHandler<ActionEvent> {
	
	
	public void handle(ActionEvent event) {
		// print a message to the console (debugging step, to ensure everything is connected)
		try {
			// change over to a second view
			//Parent root = FXMLLoader.load(getClass().getResource("/SecondView.fxml"));   // Load the FXML
			/*Main.stage.setScene(new Scene(root, 800, 800));							   // Add the scene to the stage
			Main.stage.show();*/                                                           // Show the stage to the user
			
			//create character. This is simply a circle for now
			Circle c1 = new Circle(250, 250, 50, Color.BLUE);
			Circle c2 = new Circle(150, 150, 40, Color.RED);
			//Character mainChar = new Character(name);
			
			//create the root group
			Group root = new Group();
			//set the scene
			Scene s1 = new Scene(root, 1280, 720);
			//add the character to the scene
			root.getChildren().add(c1);
			root.getChildren().add(c2);
			//set the stage with the new scene
			Main.stage.setScene(s1);
			Main.stage.show();
			
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
	

