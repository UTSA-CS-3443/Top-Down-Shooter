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
	private ArrayList<Mannequin> mannequin = new ArrayList<>();
	private ArrayList<Splash> splash= new ArrayList<>();
	
	ArrayList<Thing> thingsToAdd = new ArrayList<>();
	ArrayList<Thing> thingsToRemove = new ArrayList<>();
	ArrayList<Splash> splashToAdd = new ArrayList<>();
	ArrayList<Splash> splashToRemove = new ArrayList<>();
	
	
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
		things.add(thing);
		if(thing instanceof Warrior)
		{
			warrior =(Warrior)thing;
	}
		if(thing instanceof Mannequin)
		{
			mannequin.add((Mannequin)thing);
		}
		if(thing instanceof Splash)splash.add((Splash)thing);
		screen.getChildren().add(thing);
	}
	private void remove(Thing thing)
	{	
		things.remove(thing);
		things.remove(thing);
		splash.remove(thing);
		screen.getChildren().remove(thing);	
	}
public void addToQ(Thing thing)
{
	thingsToAdd.add(thing);
}
public void removeFromQ(Thing thing)
{
	thingsToRemove.add(thing);
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
		mannequinLoop.stop();
	}
	
	private void restart()
	{
		things.clear();
		thingsToAdd.clear();
		thingsToRemove.clear();
		mannequin.clear();
		splash.clear();
		
		addToQ(new Warrior());
		

		setupScene(new GameScreen());
		
		play();
	}
	private void setupTime()
	{
		gameLoop = new Timeline(new KeyFrame(Duration.millis(Timing.TICK_LENGTH), e-> {
			for (Thing thing : thing)
			{
				thing.doTick();
				
				if(thing instanceof Enemy)
				{
					if(((Enemy)thing).getHealth()<=0)
				{
					removeQ(thing);
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
		}
			if(Math.random() < Timing.MANNEQUIN_SPAWNING)
			{
				Math.random() < Timing.MANNEQUIN_PROPORTION)addToQ(new Mannequin();
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
							removeFromQ(splash);
							
						}
					}
				}
				if(splash instanceof MannqeuinSplash
						&& splash.intersects(warrior.getX(),warrior.getY(),
								warrior.getWidth(),warrior.getHeight())
						{
					warrior.subtractHealth(splash.getDamage());
					removeFromQ(splash);
				}
				if(splash.getY() < - splash.getHeight()
						|| splash.getY() >ClassProportions.WINDOW_H)
					removeFromQ(splash);
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
	
			gameLoop.setCycleCount(Timeline.INDEFINITE);
			gameLoop.play();
			
			mannequinLoop = new Timeline(new KeyFrame(Duration.ofMillis(Timing.MANNEQUIN_FIRE_RATE),e -> ) {
			for(Thing thing : things)
					{
						if(Thing instanceof Mannequin)((Mannequin)thing).fireSplash();
					}
					}));
			
 
		}
}
