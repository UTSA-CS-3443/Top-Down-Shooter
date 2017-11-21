package application;
	
import javafx.animation.FadeTransition;
import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import application.Resources;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;


public class Main extends Application {
	private static final int SCREEN_WIDTH = 640;
	private static final int SCREEN_HEIGHT = 640;
	
//	private Pane root = new Pane();
	//to start the game
	GameStarter engine = new GameStarter();
	Scene sceneGame = engine.getScene();
	//making it simple for the getScene and this scene functions
	Stage window = new Stage();
	
//	Scene menu;
	
	
	
	private Parent mainMenu() {
		Pane root = new Pane();
		ImageView imageView = new ImageView(new Image(getClass()
                .getResource("/media/bobross.png")
                .toExternalForm()));
		
		imageView.setFitWidth(SCREEN_WIDTH);
        imageView.setFitHeight(SCREEN_HEIGHT);

        SepiaTone tone = new SepiaTone(0.85);
        imageView.setEffect(tone);

        Rectangle masker = new Rectangle(SCREEN_WIDTH, SCREEN_HEIGHT);
        masker.setOpacity(0);
        masker.setMouseTransparent(true);
        
        MenuBox menuBox = new MenuBox(250, 350);
        menuBox.setTranslateX(250);
        menuBox.setTranslateY(230);
        
        MenuItem itemNew = new MenuItem("NEW GAME", 250);
        itemNew.setOnAction(() -> {
        	window.setScene(sceneGame);
        	window.show();
        });
        menuBox.addItem(itemNew);
        
        MenuItem itemExit = new MenuItem("EXIT", 250);
        itemExit.setOnAction(() -> System.exit(0));
        menuBox.addItem(itemExit);
        
        root.getChildren().addAll(imageView, menuBox, masker);
        return root;
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		//window = primaryStage;
       // GameStarter engine = new GameStarter();
//		Button buttonNG = new Button("NEW GAME");
//		buttonNG.setOnAction(e -> window.setScene(sceneGame));
        
//		VBox layout = new VBox(100);
		//we need to add more buttons pertaining this function
//		layout.getChildren().addAll(buttonNG);
		//menu = new Scene(layout, 640, 640);
		
		Scene sceneGame = new Scene(mainMenu());
		primaryStage.setTitle("PAINT WARRIOR");
		primaryStage.setScene(sceneGame);
		primaryStage.show();
	}
	public static void main(String[] args)
    {
    	launch(args);
    }
    
    
}
