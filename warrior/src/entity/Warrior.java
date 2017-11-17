
package entity;

import javafx.scene.image.Image;
import application.Timing;
import application.game.*;
import application.Direction;

import java.util.ArrayList;

import application.Figurations;
import application.Health;
import application.Projectiles;
import application.WarriorProjectiles;

public class Warrior extends Mob {

    
    private static Image Sprite = new Image(Resources.WARRIOR, 
            Figurations.WARRIOR_WIDTH, Figurations.WARRIOR_HEIGHT, false, false);
    
    //The amount to move each tick
    protected double deltaX = Timing.WARRIOR_DELTA_X;
    protected double deltaY = Timing.WARRIOR_DELTA_Y;
    
    protected boolean movingLeft = false;
    protected boolean movingRight = false;
    protected boolean movingUp = false;
    protected boolean movingDown = false;
    
    protected ArrayList<Entity> list;

    public Warrior() {
        super(Resources.WARRIOR, Figurations.WARRIOR_WIDTH, 
                Figurations.WARRIOR_HEIGHT, Health.WARRIOR_HEALTH);
        setInitialPosition();
    }
 
	private int health = Health.WARRIOR_HEALTH;
	private int paintCount = 0;
	
	public int getHealth() {
		return this.health;
	}
	public void takeDamage() {
		this.health = this.health - Health.ENEMY_DMG;
	}
	public int getPaintCount() {
		return this.paintCount;
	}
	
	
	
	
    private void setInitialPosition() {
        setX((Figurations.SCREEN_WIDTH - Figurations.WARRIOR_WIDTH) / 2);
        setY(Figurations.SCREEN_HEIGHT - Figurations.WARRIOR_HEIGHT);
    }
    
 
    public void startMovement(Direction dir) {
        switch (dir) {
            case W:
                movingUp = true; break;
            case S:
                movingDown = true; break;
            case A:
                movingLeft = true; break;
            case D:
                movingRight = true; break;
        }
    }
    

    public void stopMovement(Direction dir) {
        switch (dir) {
            case W:
                movingUp = false; break;
            case S:
                movingDown = false; break;
            case A:
                movingLeft = false; break;
            case D:
                movingRight = false; break;
        }
    }

    public void fireProjectile() {
        ((GameScreen)getParent()).getStarter().add(
            new WarriorProjectiles(
                getCenterX() - (Figurations.BULLET_WIDTH / 2),
                getY() - Figurations.BULLET_HEIGHT
            )
        );
    }
    
    protected void doMovement() {
        if (movingLeft ^ movingRight) { 
            if (movingLeft) {
                if (getX() >= deltaX) setX(getX() - deltaX);
                else setX(0);
            }
            if (movingRight) {
                if (getX() < (Figurations.SCREEN_WIDTH - width - deltaX))
                    setX(getX() + deltaX);
                else setX(Figurations.SCREEN_WIDTH - width - deltaX);
            }
        }
        if (movingUp ^ movingDown) {
            if (movingUp) {
                if (getY() >= (deltaY + height)) setY(getY() - deltaY);
                else setY(height);
            }
            if (movingDown) {
                if (getY() < (Figurations.SCREEN_HEIGHT - height - deltaY))
                    setY(getY() + deltaY);
                else setY(Figurations.SCREEN_HEIGHT - height - deltaY);
            }
        }
    }
    
 
    public void doTick() {
        doMovement();
        if (movingLeft ^ movingRight) {
            if (movingLeft) setImage(Sprite);
        } else setImage(sprite);
    }
}
