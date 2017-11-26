
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
    	Label totalKills = new Label("Total Kills: " + Points.numberOfTotalKills);
    	totalKills.setMinWidth(Figurations.SCREEN_WIDTH);
    	totalKills.setTextFill(Color.WHITE);
    	totalKills.setAlignment(Pos.TOP_LEFT);
    	totalKills.setTextAlignment(TextAlignment.LEFT);
    	if(Round.ROUNDS == 0)
    	{
    		this.setBackground(new Background(new BackgroundFill(Color.BROWN, null, null)));
    		
    	}
    	else if(Round.ROUNDS == 1)
    	{
    		this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    	}
    	else
    		this.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
    
    	this.getChildren().addAll(totalKills);
    }

    
    public GameStarter getEngine() {
        return engine;
    }
    
    
    public void setEngine(GameStarter engine) {
        this.engine = engine;
    }
}
