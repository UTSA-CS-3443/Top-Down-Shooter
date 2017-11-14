package application.game;

import javafx.scene.Scene;

import java.util.ArrayList;

import com.sun.javafx.scene.traversal.Direction;

import application.ClassProportions;
import javafx.animation.Timeline;

public class GameStarter {
	private GameScreen screen;
	private Scene scene;

	private Timeline gameLoop;
	private Timeline smallEnemyAttack;
	private Timeline bigEnemeyAttack;
	
	private Player player = new Player();
	private ArrayList<Thing> things = new ArrayList<>();
	private ArrayList<Enemy> enemy = new ArrayList<>();
	private ArrayList<Projectiles> projectiles= new ArrayList<>();
	
	ArrayList<Entity> entitiesToAdd = new ArrayList<>();
	ArrayList<Entity> entitiesToRemove = new ArrayList<>();
	ArrayList<Particles> explosionToAdd = new ArrayList<>();
	ArrayList<Particles> explosionsToRemove = new ArrayList<>();
	
	public GameStarter()
	{
		screen = new GameStarter();
		scene = new Scene(pane,ClassProportions.WINDOW_W, ClassProportions.WINDOW_H);
		setupScene(screen);
		setupKeybinds();
		
		add(player);
		
		setupTimesLines();
		
		displayHelp();
		
		private void setupScene(GameScreen screen)
		{
			this.screen = screen;
			screen.setStarter(this);
			
			scene.setRoot(screen);
			
		}
		private void setupKeyMovement()
		{
			scene.setOnKeyPressed(e -> {
				case A:
					player.Move(Direction.LEFT);
					break;
				case D:
					player.Move(Direction.RIGHT);
					break;
				case W:
					player.Move(Direction.UP);
					break;
				case S:
					player.Move(Direction.DOWN);
					break;
				case SPACE:
					player.fire();
					break;
				case ESCAPE:
					pause();
			}
		}catch(NULLPointerException ex) {
			System.err.println("player doesnt exist");
		}	
		});
		}
		scene.setOnKeyReleased(e ->{
			try{
				switch(e.getCode()) {
				case A:
					player.Stop(Direction.LEFT);
					break;
				case D:
					player.Stop(Direction.RIGHT);
					break;
				case W:
					player.Stop(Direction.UP);
					break;
				case S:
					player.Stop(Direction.DOWN);
					break;
				}
			}
			catch(NullPointerException ex) {
				System.err.println("player doesnt exists");
			}	
				});
	}
	
	private void add(Thing thing)
	{
		Thing.add(thing);
		if(thing instanceof Player)
		{
			player =(Player)thing;
			screen.getHealth(player.health());
	}
		if(thing instanceof Enemy)
		{
			enemies.add((Enemy)thing);
			screen.getChildren().add(((Enemy)thing).getHealthBar());
		}
		if(thing instanceof Splash)splash.add((Splash)thing);
		screen.getChildren().add(thing);
}
