package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import application.Resources;


public class Main extends Application {
	
	public static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		
        GameStarter engine = new GameStarter();
		primaryStage.setTitle("Paint Warrior");
        primaryStage.setScene(engine.getScene());
        primaryStage.show();
	}
    
    public static void main(String [] args)
    {
    	launch(args);
    }
}
