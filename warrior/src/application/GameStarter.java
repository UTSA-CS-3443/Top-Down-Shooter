package application;


import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.util.Duration;
import entity.*;
import application.Round;
import application.Points;


public class GameStarter {
    
    private GameScreen pane;
    private Scene scene;
    
    
    private Timeline gameLoop;
    private Timeline mannequinFireLoop;

    
    private Warrior warrior = new Warrior();
    private ArrayList<Entity> entities = new ArrayList<>();
    public  static ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Projectiles> projectiles = new ArrayList<>();
    
    static ArrayList<Entity> entitiesToAdd = new ArrayList<>();
    ArrayList<Entity> entitiesToRemove = new ArrayList<>();
    
    
    public GameStarter() {
        pane = new GameScreen();
        scene = new Scene(pane, Figurations.SCREEN_WIDTH, Figurations.SCREEN_HEIGHT);
        setupScene(pane);
        setupKeybinds();
   
        
        add(warrior);
        
        
        setupTimelines();

    }
    
    
    private void setupScene(GameScreen pane) {
        this.pane = pane;
        pane.setEngine(this);
        
        scene.setRoot(pane);
        

    }
    

    private void setupKeybinds() {
        scene.setOnKeyPressed(e -> {
            try {
                switch (e.getCode()) {
                    case LEFT:
                    case A:
                        warrior.startMovement(Direction.LEFT); break;
                    case RIGHT:
                    case D:
                        warrior.startMovement(Direction.RIGHT); break;
                    case UP:
                    case W:
                        warrior.startMovement(Direction.UP); break;
                    case DOWN:
                    case S:
                        warrior.startMovement(Direction.DOWN); break;
                    case SPACE:
                        warrior.fireProjectile(); break;

                }
            } catch (NullPointerException ex) {
                System.err.println("Tried to move warrior, but warrior does not exist.");
            }
        });
        scene.setOnKeyReleased(e -> {
            try {
                switch (e.getCode()) {
                    case LEFT:
                    case A:
                        warrior.stopMovement(Direction.LEFT); break;
                    case RIGHT:
                    case D:
                        warrior.stopMovement(Direction.RIGHT); break;
                    case UP:
                    case W:
                        warrior.stopMovement(Direction.UP); break;
                    case DOWN:
                    case S:
                        warrior.stopMovement(Direction.DOWN); break;
                }
            } catch (NullPointerException ex) {
                System.err.println("Tried to stop warrior, but warrior does not exist.");
            }
        });
    }
    
    private void gameOver() {
        stop();

    }
    private void add(Entity entity) {
        entities.add(entity);
        if (entity instanceof Warrior) {
            warrior = (Warrior)entity;
        }
        if (entity instanceof Enemy) {
            enemies.add((Enemy)entity);
        }
        if (entity instanceof Projectiles) projectiles.add((Projectiles)entity);
        pane.getChildren().add(entity);
    }
  
    private void remove(Entity entity) {
        if (entity instanceof Enemy)
        entities.remove(entity);

        enemies.remove(entity);
        projectiles.remove(entity);
        pane.getChildren().remove(entity);
    }
    

    
    
    public static void queueAddition(Entity entity) {
        entitiesToAdd.add(entity);
    }
    
    public void queueRemoval(Entity entity) {
        entitiesToRemove.add(entity);
    }
    
    
    public double getwarriorX() {
        return warrior.getX();
    }
    

    public double getwarriorY() {
        return warrior.getY();
    }
    
  
    public GameScreen getPane() {
        return pane;
    }
    
  
    public Scene getScene() {
        return scene;
    }
    
    
    public void pause() {
        gameLoop.pause();
        
        mannequinFireLoop.pause();
    }
    
    
    public void play() {
        gameLoop.play();
       
        mannequinFireLoop.play();
    }
    
    
    public void stop() {
        gameLoop.stop();
       
        mannequinFireLoop.stop();
 
    }
    
    public void restart() {
        //Clear out the ArrayLists
        entities.clear();
        entitiesToAdd.clear();
        entitiesToRemove.clear();
        enemies.clear();
        projectiles.clear();
        
        //Add a new warrior
        queueAddition(new Warrior());
        
        setupScene(new GameScreen());


        play();
    }
    

    
    
    
    private void setupTimelines() {
        
        gameLoop = new Timeline(new KeyFrame(Duration.millis(Timing.TICK_LENGTH), e -> {
            for (Entity entity : entities) {
                entity.doTick();
                
                if (entity instanceof Enemy) {
                    if (((Enemy)entity).getHealth() <= 0) {
                    	Round.KILL_COUNT++;
                    	Points.numberOfKills++;
                    	Points.numberOfTotalKills++;
                        queueRemoval(entity);
                    }
                    if(Round.ROUNDS == 0 )
                    {
                    	if(Round.KILL_COUNT == 5)
                    	{
                    		Round.ROUNDS++;
                    		Round.KILL_COUNT = 0;
                    		Points.numberOfKills = 0;
                    		stop();
                    		try {
                    			Thread.sleep(5000);
                    			restart();
                    		}
                    		catch (InterruptedException e1) {
                    			e1.printStackTrace();
                    		}
        				
                    	}
                    }
                    else if(Round.ROUNDS == 1) 
                    {
                    	if(Round.KILL_COUNT == 10)
                    	{
                    		Round.ROUNDS++;
                    		Round.KILL_COUNT = 0;
                    		Points.numberOfKills = 0;
                    		stop();
                    		try {
                    			Thread.sleep(5000);
                    			restart();
                    		} catch (InterruptedException e1) {
                    			e1.printStackTrace();
                    		}
        				
                    	}
                    		
                    }
                    else if(Round.ROUNDS == 2) 
                    {
                    	if(Round.KILL_COUNT == 15)
                    	{
                    		Round.ROUNDS++;
                    		Round.KILL_COUNT = 0;
                    		Points.numberOfKills = 0;
                    		stop();
                    		try {
                    			Thread.sleep(5000);
                    			restart();
                    		} catch (InterruptedException e1) {
                    			e1.printStackTrace();
                    		}
        				
                    	}
                    		
                    }

                    if (entity instanceof Mannequin) {
                        if (Math.random() < Timing.MANNEQUIN_REVERSE_CHANCE)
                            ((Mannequin)entity).reverseDirection();
                    }
                   
                }
                if (entity instanceof Warrior) {
                    if (((Mob)entity).getHealth() <= 0) {
                        gameOver();

                    }
                }
            }
            	Round.spawnEnemies();
     
            
            for (Projectiles projectile : projectiles) {
                if (projectile instanceof WarriorProjectiles) {
                    for (Enemy enemy : enemies) {
                        if (projectile.intersects(enemy.getX(), enemy.getY(),
                                enemy.getWidth(), enemy.getHeight())) {
                            enemy.subtractHealth(projectile.getDamage());
                            queueRemoval(projectile);
                        }
                    }
                }
                if (projectile instanceof MannequinProjectile
                        && projectile.intersects(warrior.getX(), warrior.getY(),
                        warrior.getWidth(), warrior.getHeight())) {
                    warrior.subtractHealth(projectile.getDamage());
                    queueRemoval(projectile);
                }
                if (projectile.getY() < -projectile.getHeight() 
                        || projectile.getY() > Figurations.SCREEN_HEIGHT)
                    queueRemoval(projectile);
            }
            
            for (Entity entity : entitiesToRemove) {
                remove(entity);
            }
            entitiesToRemove.clear();
            for (Entity entity : entitiesToAdd) {
                add(entity);
            }
            entitiesToAdd.clear();
            
            
        }));
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
        
    
        
        mannequinFireLoop = new Timeline(new KeyFrame(Duration.millis(Timing.MANNEQUIN_FIRE_RATE), e -> {
            for (Entity entity : entities) {
                if (entity instanceof Mannequin) ((Mannequin)entity).fireProjectile();
                if (entity instanceof Mannequin2) ((Mannequin2)entity).fireProjectile();
                if (entity instanceof Mannequin3) ((Mannequin3)entity).fireProjectile();
            }
        }));
        mannequinFireLoop.setCycleCount(Timeline.INDEFINITE);
        mannequinFireLoop.play();
    }
    
}
