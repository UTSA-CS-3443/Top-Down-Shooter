package application.game;

import javafx.scene.Scene;

import java.util.ArrayList;

import com.sun.javafx.scene.traversal.Direction;

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
		scene = new Scene(pane,Dimensions.SCREEN_WIDTH, Dimensions.SCREEN_HEIGHT);
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
		}catch(NullPointerException ex) {
			System.err.println("player doesnt exist");
		}	
		});
		
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
	private void remove(Thing thing)
	{
		if (thing instanceof Enemy)
			screen.getChildren().remove(((Enemy)thing)getHealthBar());
		Thing.remove(thing);
		Thing.remove(thing);
		Splash.remove(thing);
		screen.getChildren().remove(thing);	
	}
public void addToQ(Thing thing)
{
	ThingToAdd.add(thing);
}
public void removeFromQ(Thing thing)
{
	ThingToRemove.add(thing);
}
	public double getPlayerX()
	{
		return player.getX();
	}
	public double getPlayerY()
	{
		return player.getX();
	}
	public GameScreen getScreen()
	{
		return screen;
	}
	public Scene getScene()
	{
	}
	private void pause()
	{
		gameLoop.pause();
		enemyLoop.pause();
	}
	private void play()
	{
		gameLoop.play();
		enemyLoop.play();
	}
	private void stop()
	{
		gameLoop.stop();
		enemyLoop();
	}
	
	private void restart()
	{
		Thing.clear();
		ThingToAdd.clear();
		ThingToRemove.clear();
		mannequin.clear();
		Splash.clear();
		
		addToQ(new Player());
		
		setupScreen(new GameScreen());
		
		play();
	}
	private void setupTime()
	{
		gameLoop = new Timeline(new KeyFrame(Duration.millis(Timing.TICK), e->) {
			for (Thing thing : thing)
			{
				thing.doTick();
				
				if(thing instanceof Enemy)
				{
					if()((Enemy)thing).getHealth()<=0)
				{
					removeQ(thing);
				}
				}
				if(thing instanceof Player)
				{
					if(((Mob)thing).getHealth() <=0)
					{
						gameOver();
						
						queueRemoval(thing);
					}
				}
			
}