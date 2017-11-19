package entity;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Doors(ActionEvent event) {
	stage.close();
	Stage primaryStage = new Stage();
	Parent root = null;
	try {
		root = FXML.load(getClass().getResource(""));
	}catch(IOException e) {
		e.printStackTrace();
	}
	primaryStage.setTitle("next room");
	primaryStage.setScene(new Scene(root,600,400));
	primaryStage.show();
}
