package application.game;
import java.util.ArrayList;

import application.Projectiles;
import application.enemy;
import entity.Entity;
import entity.Warrior;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;

public class GameStarter {
    
    private GameScreen pane;
    private Scene scene;
    


    
    //IntegerProperties (to permit binding) for scores
    
    
    //Entities
    private Warrior warrior = new Warrior();
    private ArrayList<Entity> entities = new ArrayList<>();
    private ArrayList<enemy> enemies = new ArrayList<>();
    private ArrayList<Projectiles> projectiles = new ArrayList<>();
    
    //We can't add or remove objects while iterating, so make queues
    ArrayList<Entity> entitiesToAdd = new ArrayList<>();
    ArrayList<Entity> entitiesToRemove = new ArrayList<>();
    
    
    public GameStarter() {
        add(warrior);
        //setupTimelines();

    }
   
    private void add(Entity entity) {
        entities.add(entity);
        if (entity instanceof Warrior) {
            warrior = (Warrior)entity;
        }

        
    }
    
   
    private void remove(Entity entity) {
   
        entities.remove(entity);
        enemies.remove(entity);
        projectiles.remove(entity);
  
    }
    
 
    
    public void queueAddition(Entity entity) {
        entitiesToAdd.add(entity);
    }
    

   
    public void queueRemoval(Entity entity) {
        entitiesToRemove.add(entity);
    }
    
    
   
    public double getWarriorX() {
        return warrior.getX();
    }
    
    
    public double getWarriorY() {
        return warrior.getY();
    }
    
    
    public GameScreen getPane() {
        return pane;
    }
    
    
    public Scene getScene() {
        return scene;
    }
    
    
    
}