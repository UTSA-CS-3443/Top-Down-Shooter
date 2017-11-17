package application.game;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class GameScreen extends Pane {
    
    private GameStarter starter;

    
    
    public GameScreen() {
 
    }

    
    public GameStarter getStarter() {
        return starter;
    }
    
    
    public void setStarter(GameStarter starter) {
        this.starter = starter;
    }
}
