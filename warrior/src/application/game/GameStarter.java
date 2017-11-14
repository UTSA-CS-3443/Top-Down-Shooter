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
	
	private Warrior warrior = new Warrior();
	private ArrayList<Thing> things = new ArrayList<>();
	private ArrayList<Mannequin> enemy = new ArrayList<>();
	private ArrayList<Splash> splash= new ArrayList<>();
	
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
		
		add(warrior);
		
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
					warrior.Move(Direction.LEFT);
					break;
				case D:
					warrior.Move(Direction.RIGHT);
					break;
				case W:
					warrior.Move(Direction.UP);
					break;
				case S:
					warrior.Move(Direction.DOWN);
					break;
				case SPACE:
					warrior.fire();
					break;
				case ESCAPE:
					pause();
			}
			}
		}catch(NullPointerException ex) {
			System.err.println("player doesnt exist");
			System.err.println("player doesnt exist");
		}catch(NULLPointerException ex) {
			System.err.println("warrior doesnt exist");
			System.err.println("warrior doesnt exist");
		}	
		});
		
		scene.setOnKeyReleased(e ->{
			try{
				switch(e.getCode()) {
				case A:
					warrior.Stop(Direction.LEFT);
					break;
				case D:
					warrior.Stop(Direction.RIGHT);
					break;
				case W:
					warrior.Stop(Direction.UP);
					break;
				case S:
					warrior.Stop(Direction.DOWN);
					break;
				}
			}
			catch(NullPointerException ex) {
				System.err.println("warrior doesnt exists");
			}	
				});
	}
	
	private void add(Thing thing)
	{
		Thing.add(thing);
		if(thing instanceof Warrior)
		{
			warrior =(Warrior)thing;
			screen.getHealth(warrior.health());
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
	public double getWarriorX()
	{
		return warrior.getX_VALUE();
	}
	public double getWarriorY()
	{
		return warrior.getY_VALUE();
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


		


		
		addToQ(new Warrior());
		

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
			if(Math.random() < Timing.ENEMY_SPAWN_CHANCE)
			{
				Math.random()< Timing.MANNEQUIN_PROPOTION)queueAddition(new Mannequin();
			}
			for(Splash splash : splashes)
			{
				if(splash instanceof PlayerProjectile)
				{
					for (Mannequin mann : manns)
					{
						if(splash.intersects(mannequin.getX(),Mannequin.getY(),mannequin.getWidth(),mannequin.getHeight()))
						{
							mannequin.subtractHealth(splash.getDamage());
							queueRemoval(splash);
							
						}
					}
				}
				if(splash instanceof MannquinProjectile
						&& splash.intersects(player.getX(),player.getY(),
								player.getWidth(),player.getHeight())
						{
					player.subtractHealth(splash.getDamage());
					queueRemoval(splash);
				}
				if(splash.getY() < - splash.getHeight()
						|| splash.getY() >ClassProportions.Screen_Height)
					queueRemoval(splash);
				}
			for(Thing thing : thingsToRemove)
			{
				remove(thing);
			}
			thingsToRemove.clear();
			for(Thing thing : thingsToAdd)
			{
				add(thing);
			}
			thingsToAdd.clear();
			}));
			gameLoop.setCycleCount(Timeline.INDEFINITE);
			gameLoop.play();
			
			MannequinFireLoop = new Timeline(new KeyFrame(Duration.millis(Timing.ENEMY_SMALL_FIRE_RATE),e -> ) {
			for(Thing thing : things)
					{
						if(Thing instanceof Mannequin)((Mannequin)thing).fireSplash();
					}
					}));
			}
}