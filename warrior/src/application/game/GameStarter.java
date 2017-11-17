package application.game;

import java.io.File;
import javafx.util.Duration;

import javafx.scene.Scene;

import application.ClassProportions;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.ArrayList;

import application.game.*;
//import application.game.Mannequin;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
//import application.game.KeyBoard;

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
		return warrior.getX();
	}
	public double getWarriorY()
	{
		return warrior.getY();
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
        
        gameLoop = new Timeline(new KeyFrame(Duration.millis(Timing.TICK_LENGTH), e -> {
            //Tick for every entity
            for (Thing thing : things) {
                thing.Tick();
                
                //Check if the entity's health is zero
                if (thing instanceof Mannequin) {
                    if (((Mannequin)thing).getHealth() <= 0) {

                        removeFromQ(thing);
                    }
       
                }
                if (thing instanceof Warrior) {
                    //Display "GAME OVER" if player died
                    if (((Mob)thing).getHealth() <= 0) {

                        removeFromQ(thing);
                    }
                }
            }
            
            //Randomly spawn a new enemy
            if (Math.random() < Timing.MANNEQUIN_SPAWNING) {
                 addToQ(new Mannequin());
            }
            
            //Detect collisions and remove any Projectiles that went outside the GamePane
            for (Splash splash : splashes) {
                //PlayerProjectiles colliding with Enemies
                if (splash instanceof WarriorSplash) {
                    for (Mannequin mannequin : mannequins) {
                        if (splash.intersects(mannequins.getX_VALUE(), mannequins.getY_VALUE(),
                                mannequins.getWidth(), mannequins.getHeight())) {
                            mannequin.subtractHealth(splash.getDamage());
                            qToRemove(splash);
                        }
                    }
                }
                //EnemyProjectiles colliding with the Player
                if (splash instanceof MannequinSplash
                        && splash.intersects(warrior.getX(), warrior.getY(),
                        warrior.getWidth(), warrior.getHeight())) {
                    warrior.subtractHealth(splash.getDamage());
                    removeFromQ(splash);
                }
                //Remove any that are outside the play area
                if (splash.getY() < -splash.getHeight() 
                        || splash.getY() > ClassProportions.WINDOW_H)
                    addToQ(splash);
            }
            
            //Remove Entities queued for removal
            for (Thing thing : thingsToRemove) {
                remove(thing);
            }
            //And clear the list to start fresh next cycle
            thingsToRemove.clear();
            //Same thing for those queued for addition
            for (Thing thing : thingsToAdd) {
                add(thing);
            }
            thingsToAdd.clear();
            
        }));
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
        
        mannequinLoop = new Timeline(new KeyFrame(Duration.millis(Timing.MANNEQUIN_FIRE_RATE), e -> {
            for (Thing thing : things) {
                if (thing instanceof Mannequin) ((Mannequin)thing).shootSplash();
            }
        }));
        mannequinLoop.setCycleCount(Timeline.INDEFINITE);
        mannequinLoop.play();
        
  
    }
}
