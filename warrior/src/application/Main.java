package application;
	
import application.game.GameStarter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	

public void start(Stage primaryStage) {
        
        //Set up the game window
        GameStarter starter = new GameStarter();
        
        primaryStage.setTitle("Paint Warrior");
        primaryStage.setScene(starter.getScene());
        primaryStage.show();
    }
public static void main (String [] args)
{
	launch(args);
}
}