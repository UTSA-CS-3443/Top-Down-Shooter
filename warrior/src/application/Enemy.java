package application;

import entity.Direction;
import entity.Mob;
import application.Figurations;
import application.game.Resources;

public abstract class Enemy extends Mob {
	
	protected double deltaX = 0.0;
	protected Direction dir = Direction.LEFT; 
	
	public Enemy() {
        super(Resources.WARRIOR, 32, 32, 1);
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
        //Spawn at a random x coordinate within the GamePane
        setX(Math.random() * (Figurations.SCREEN_WIDTH - width));
        //Spawn in rows on the top third of the screen, shifted down by one row
        setY(height * (int)(1 + Math.random() * Figurations.SCREEN_HEIGHT / 3 / height));
    }
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public void doMovement() {
		switch(dir) {
		case LEFT:
			if (getX() >= deltaX) setX(get() - deltaX);
			else dir = Direction.RIGHT;
			break;
		case RIGHT: 
			if (get() < (Figurations.SCREEN_WIDTH - width - deltaX))
				setX(getX() + deltaX);
			else dir = Direction.LEFT;
		}
	}
	@Override
	public abstract void doTrick();
}
