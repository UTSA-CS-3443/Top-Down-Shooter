
package application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import media.*;


public class GameScreen extends Pane {
    
    private GameStarter engine;
    
    public GameScreen() {
        this.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
   
    }

    
    public GameStarter getEngine() {
        return engine;
    }
    
    
    public void setEngine(GameStarter engine) {
        this.engine = engine;
    }
}
