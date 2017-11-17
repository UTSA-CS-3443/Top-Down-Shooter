
package entity;

import javafx.scene.image.Image;
import application.Timing;
import application.game.*;
import application.Figurations;
import application.Health;
import application.WarriorProjectiles;

public class Warrior extends Mob {

    
    private static Image leftSprite = new Image(Resources.WARRIOR, 
            Figurations.WARRIOR_WIDTH, Figurations.WARRIOR_HEIGHT, false, false);
    
    //The amount to move each tick
    protected double deltaX = Timing.WARRIOR_DELTA_X;
    protected double deltaY = Timing.WARRIOR_DELTA_Y;
    
    protected boolean movingLeft = false;
    protected boolean movingRight = false;
    protected boolean movingUp = false;
    protected boolean movingDown = false;
    

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
            case UP:
                movingUp = true; break;
            case DOWN:
                movingDown = true; break;
            case LEFT:
                movingLeft = true; break;
            case RIGHT:
                movingRight = true; break;
        }
    }
    

    public void stopMovement(Direction dir) {
        switch (dir) {
            case UP:
                movingUp = false; break;
            case DOWN:
                movingDown = false; break;
            case LEFT:
                movingLeft = false; break;
            case RIGHT:
                movingRight = false; break;
        }
    }

    public void fireProjectile() {
        ((GamePane)getParent()).getEngine().queueAddition(
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
                //Prevent player from leaving the game area at the bottom
                if (getY() < (Figurations.SCREEN_HEIGHT - height - deltaY))
                    setY(getY() + deltaY);
                else setY(Figurations.SCREEN_HEIGHT - height - deltaY);
            }
        }
    }
    
    /**
     * Processes events for this Entity.
     * PreCondition: None.
     * PostConditon: This Player has moved and had a sprite set according to 
     * the direction in which it moved.
     */
    @Override
    public void doTick() {
        doMovement();
        //Set the sprite according to how we're moving
        if (movingLeft ^ movingRight) {
            if (movingLeft) setImage(leftSprite);
        } else setImage(sprite);
    }
}
