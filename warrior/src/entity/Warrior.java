
package entity;

import javafx.scene.image.Image;
import application.Figurations;
import application.GameScreen;
import application.Health;
import application.Resources;
import application.Timing;


public class Warrior extends Mob {
    
    protected double deltaX = Timing.WARRIOR_DELTA_X;
    protected double deltaY = Timing.WARRIOR_DELTA_Y;
    
    protected boolean movingLeft = false;
    protected boolean movingRight = false;
    protected boolean movingUp = false;
    protected boolean movingDown = false;

    public Warrior() {
        super(Resources.SPR_WARRIOR, Figurations.PLAYER_WIDTH, 
                Figurations.PLAYER_HEIGHT, Health.WARRIOR);
        setInitialPosition();
    }

    private void setInitialPosition() {
        setX((Figurations.SCREEN_WIDTH - Figurations.PLAYER_WIDTH) / 2);
        setY(Figurations.SCREEN_HEIGHT - Figurations.PLAYER_HEIGHT);
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
        ((GameScreen)getParent()).getEngine().queueAddition(
            new WarriorProjectiles(
                getCenterX() - (Figurations.PROJECTILE_WARRIOR_WIDTH / 2),
                getY() - Figurations.PROJECTILE_WARRIOR_HEIGHT
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

        } else setImage(sprite);
    }
}
