
package application;

import javafx.application.Application;
import javafx.stage.Stage;
import application.game.*;


public class Main extends Application {

    public void start(Stage primaryStage) {
        
        //Set up the game window
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
