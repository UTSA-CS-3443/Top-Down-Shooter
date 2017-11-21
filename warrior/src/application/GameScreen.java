
package application;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import application.Round;
import application.Points;

public class GameScreen extends Pane {
    
    private GameStarter engine;
    
    public GameScreen() {
    	Label killCount = new Label("Kill: " + Points.numberOfKills);
    	Label totalKills = new Label("Total Kills: " + Points.numberOfTotalKills);
    	killCount.setMinWidth(Figurations.SCREEN_WIDTH);
    	totalKills.setMinWidth(Figurations.SCREEN_WIDTH);
    	killCount.setTextFill(Color.WHITE);
    	totalKills.setTextFill(Color.WHITE);
    	killCount.setAlignment(Pos.TOP_RIGHT);
    	totalKills.setAlignment(Pos.TOP_LEFT);
    	killCount.setTextAlignment(TextAlignment.RIGHT);
    	totalKills.setTextAlignment(TextAlignment.LEFT);
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
    
    	this.getChildren().addAll(killCount,totalKills);
    }

    
    public GameStarter getEngine() {
        return engine;
    }
    
    
    public void setEngine(GameStarter engine) {
        this.engine = engine;
    }
}
