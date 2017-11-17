package application.game;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class GameScreen extends Pane {
	
	private GameStarter starter;
	
	public GameScreen () {
		this.setBackground(new Background(new BackgroundFill(Color.rgb(8, 8, 8), null, null)));
	}
	public GameStarter getStarter(){
		return this.starter;
	}
	public void setStarter(GameStarter gameStarter) {
		this.starter = gameStarter;	
	}
	

}
