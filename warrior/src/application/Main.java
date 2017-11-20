package application;
	
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
<<<<<<< HEAD
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
=======
>>>>>>> branch 'master' of https://github.com/UTSA-CS-3443/Top-Down-Shooter.git
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import application.Resources;
import javafx.scene.layout.VBox;


public class Main extends Application {
	private static final int SCREEN_WIDTH = 640;
	private static final int SCREEN_HEIGHT = 640;
	//making it simple for the getScene and this scene functions
	Stage window;
	private Pane root = new Pane();
	GameStarter engine = new GameStarter();
	Scene sceneGame = engine.getScene();
	Scene menu;
	
	
	
	private Parent mainMenu() {
		addBackground();
		return root;
	}
	private void addBackground() {
		ImageView imageView = new ImageView(new Image(getClass().getResource("/media/bobross.png").toExternalForm()));
        imageView.setFitWidth(SCREEN_WIDTH);
        imageView.setFitHeight(SCREEN_HEIGHT);

        root.getChildren().add(imageView);
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
       // GameStarter engine = new GameStarter();
		Button buttonNG = new Button("NEW GAME");
		buttonNG.setOnAction(e -> window.setScene(sceneGame));
        
		VBox layout = new VBox(100);
		//we need to add more buttons pertaining this function
		layout.getChildren().addAll(buttonNG);
		menu = new Scene(layout, 640, 640);
		
		//Scene scene = new Scene(mainMenu());
		window.setTitle("PAINT WARRIOR");
		window.setScene(menu);
        window.show();
	}
	public static void main(String[] args)
    {
    	launch(args);
    }
    
    
}
