package application;
	
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import application.Resources;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	//making it simple for the getScene and this scene functions
	Stage window;
	GameStarter engine = new GameStarter();
	Scene sceneGame = engine.getScene();
	Scene mainMenu;
	
	public static void main(String[] args)
    {
    	launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
       // GameStarter engine = new GameStarter();
		Button buttonNG = new Button("NEW GAME");
		buttonNG.setOnAction(e -> window.setScene(sceneGame));
        
		VBox layout = new VBox(20);
		//we need to add more buttons pertaining this function
		layout.getChildren().addAll(buttonNG);
		mainMenu = new Scene(layout, 640, 640);
	
		window.setScene(mainMenu);
		window.setTitle("PAINT WARRIOR");
		
        window.show();
	}
    
    
}
