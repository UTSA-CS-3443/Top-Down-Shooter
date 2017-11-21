
package application;


import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import application.Round;

public class GameScreen extends Pane {
    
    private GameStarter engine;
    
    public GameScreen() {
    	if(Round.ROUNDS == 0)
    	{
    		this.setBackground(new Background(new BackgroundFill(Color.GAINSBORO, null, null)));
    	}
    	else if(Round.ROUNDS == 1)
    	{
    		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    	}
    	else
    		this.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
    	//hey
    }

    
    public GameStarter getEngine() {
        return engine;
    }
    
    
    public void setEngine(GameStarter engine) {
        this.engine = engine;
    }
}
