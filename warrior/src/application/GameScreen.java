
package application;


import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
public class GameScreen extends Pane {
    
    private GameStarter engine;
    
    public GameScreen() {
        this.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, null, null)));
   
    }

    
    public GameStarter getEngine() {
        return engine;
    }
    
    
    public void setEngine(GameStarter engine) {
        this.engine = engine;
    }
}
