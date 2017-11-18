
package entity;

import application.Figurations;
import application.Resources;
import application.game.*;



public abstract class Enemy extends Mob {
    
    protected double deltaX = 0.0;

    protected Direction dir = Direction.LEFT;
    
    public Enemy() {
        super(Resources.SPR_NULL, 32, 32, 1);
        setRandomInitialPosition();
    }
    
    public Enemy(String spriteName, int health) {
        super(spriteName, 32, 32, health);
        setRandomInitialPosition();

    }
    
    public Enemy(String spriteName, double width, double height, int health) {
        super(spriteName, width, height, health);
        setRandomInitialPosition();

    }
    
    public Enemy(String spriteName, double width, double height, int health, 
             double deltaX, Direction dir) {
        super(spriteName, width, height, health);
        setRandomInitialPosition();

        this.deltaX = deltaX;
        this.dir = dir;
    }


	public void setRandomInitialPosition() {
        setX(Math.random() * (Figurations.SCREEN_WIDTH - width));
        setY(height * (int)(1 + Math.random() * Figurations.SCREEN_HEIGHT / 3 / height));
    }


    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
    
    public void doMovement() {
        switch (dir) {
            case LEFT:
                if (getX() >= deltaX) setX(getX() - deltaX);
                else dir = Direction.RIGHT;
                break;
            case RIGHT:
                if (getX() < (Figurations.SCREEN_WIDTH - width - deltaX))
                    setX(getX() + deltaX);
                else dir = Direction.LEFT;
        }
    }
    
    @Override
    public abstract void doTick();
}
