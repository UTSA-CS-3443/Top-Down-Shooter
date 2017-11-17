package application.game;

import application.game.KeyBoard;
import application.ClassProportions;

public abstract class Enemy extends Mob {
	//The amount to move each tick
    protected double deltaX = 0.0;
    protected KeyBoard key = KeyBoard.LEFT;
    
    public Enemy() {
        super(Resources.SPR_DEAD, 32, 32, 1);
        setRandomInitialPosition();
    }
    //deleted score value
    public Enemy(String spriteName, int health) {
        super(spriteName, 32, 32, health);
        setRandomInitialPosition();
    }
    //deleted score value
    public Enemy(String spriteName, double width, double height, int health) {
        super(spriteName, width, height, health);
        setRandomInitialPosition();
    }
    //deleted score value
    public Enemy(String spriteName, double width, double height, int health, 
            double deltaX, KeyBoard key) {
        super(spriteName, width, height, health);
        setRandomInitialPosition();
        this.deltaX = deltaX;
        this.key = key;
    }
    
    public void setRandomInitialPosition() {
        //Spawn at a random x coordinate within the GamePane
        setX(Math.random() * (ClassProportions.WINDOW_W - width));
        //Spawn in rows on the top third of the screen, shifted down by one row
        setY(height * (int)(1 + Math.random() * ClassProportions.WINDOW_H / 3 / height));
    }

    public KeyBoard getKey() {
        return key;
    }

    public void setDir(KeyBoard key) {
        this.key = key;
    }
    
    public void doMovement() {
        switch (key) {
            case LEFT:
                if (getX() >= deltaX) setX(getX() - deltaX);
                else key = KeyBoard.RIGHT;
                break;
            case RIGHT:
                if (getX() < (ClassProportions.WINDOW_W - width - deltaX))
                    setX(getX() + deltaX);
                else key = KeyBoard.LEFT;
        }
    }
    
    @Override
    public abstract void Tick();
}

