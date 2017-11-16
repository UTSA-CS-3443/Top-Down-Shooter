package application.game;

import java.io.File;
import java.time.Duration;

import javafx.scene.Scene;
import application.ClassProportions;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.ArrayList;

import com.sun.javafx.scene.traversal.Direction;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import application.game.KeyBoard;
public class GameStarter {
	private GameScreen screen;
	private Scene scene;

	private Timeline gameLoop;
	private Timeline mannequinLoop;
	
	private Warrior warrior = new Warrior();
	private ArrayList<Thing> things = new ArrayList<>();
	private ArrayList<Mannequin> enemy = new ArrayList<>();
	private ArrayList<Splash> splash= new ArrayList<>();
	
	ArrayList<Thing> entitiesToAdd = new ArrayList<>();
	ArrayList<Thing> entitiesToRemove = new ArrayList<>();
	ArrayList<Splash> explosionToAdd = new ArrayList<>();
	ArrayList<Splash> explosionsToRemove = new ArrayList<>();
	
	
	public GameStarter()
	{
		screen = new GameScreen();
		scene = new Scene(screen,ClassProportions.WINDOW_W, ClassProportions.WINDOW_H);
		setupScene(screen);
		setupKeyMovement();
		
		add(warrior);
		
		setupTime();
		

	}
		private void setupScene(GameScreen screen)
		{
			this.screen = screen;
			screen.setStarter(this);
			
			scene.setRoot(screen);
			
		}
		private void setupKeyMovement()
		{
			scene.setOnKeyPressed(e -> {
				try {
					switch(e.getCode()) {
				case A:
					warrior.Move(KeyBoard.A);
					break;
				case D:
					warrior.Move(KeyBoard.D);
					break;
				case W:
					warrior.Move(KeyBoard.W);
					break;
				case S:
					warrior.Move(KeyBoard.S);
					break;
				case SPACE:
					warrior.fireSplash();
					break;
				case ESCAPE:
					pause();
default:
	break;
			}
		}catch(NullPointerException ex) {
			System.err.println("player doesnt exist");
		}
		});
		
		scene.setOnKeyReleased(e ->{
			try{
				switch(e.getCode()) {
				case A:
					warrior.stop(KeyBoard.A);
					break;
				case D:
					warrior.stop(KeyBoard.D);
					break;
				case W:
					warrior.stop(KeyBoard.W);
					break;
				case S:
					warrior.stop(KeyBoard.S);
					break;
default:
	break;
				}
			
		}catch(NullPointerException ex) {
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
		if(thing instanceof Mannequin)
		{
			mannequin.add((Mannequin)thing);
			screen.getChildren().add(((mannequin)thing).getHealthBar());
		}
		if(thing instanceof Splash)splash.add((Splash)thing);
		screen.getChildren().add(thing);
}
	private void remove(Thing thing)
	{
		if (thing instanceof mannequin)
			screen.getChildren().remove(((Mannequin)thing)getHealthBar());
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
		return scene;
	}
	private void pause()
	{
		gameLoop.pause();
		mannequinLoop.pause();
	}
	private void play()
	{
		gameLoop.play();
		mannequinLoop.play();
	}
	private void stop()
	{
		gameLoop.stop();
		mannequinLoop();
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
		gameLoop = new Timeline(new KeyFrame(Duration.millis(Timing.TICK_LENGTH), e->) {
			for (Thing thing : thing)
			{
				thing.doTick();
				
				if(thing instanceof Enemy)
				{
					if(((Enemy)thing).getHealth()<=0)
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
				if(splash instanceof SplashProjectile)
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
						&& splash.intersects(warrior.getX(),warrior.getY(),
								warrior.getWidth(),warrior.getHeight())
						{
					warrior.subtractHealth(splash.getDamage());
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
			
			MannequinFireLoop = new Timeline(new KeyFrame(Duration.millis(Timing.MANNEQUIN_FIRE_RATE),e -> ) {
			for(Thing thing : things)
					{
						if(Thing instanceof Mannequin)((Mannequin)thing).fireSplash();
					}
					}));
			}
}