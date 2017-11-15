
package application.game;

import application.ClassProportions;
import javafx.scene.image.Image;


public class Warrior extends Mob {

	private int X_VALUE;
	private int Y_VALUE;
	
	protected boolean moveLeft = false;
	protected boolean moveRight = false;
	protected boolean moveUp = false;
	protected boolean moveDown = false;
	
	private int health = Health.PLAYER_HEALTH;
	
	public int getX_VALUE() {
		return this.X_VALUE;
	}
	public void setX_VALUE(int x) {
		this.X_VALUE = x;
	}
	public int getY_VALUE() {
		return this.Y_VALUE;
	}
	public void setY_VALUE(int y) {
		this.Y_VALUE = y;
	}
	public void Move(Direction dir)
	{
		switch(dir) {
		case W:
			moveUp = true;
			break;
		case S:
			moveDown = true;
			break;
		case A:
			moveLeft = true;
			break;
		case D:
			moveRight = true;
			break;
		}
	}
	public void stop(Direction dir)
	{
		switch(dir)
		{
		case W:
			moveUp = false;
			break;
		case S:
			moveDown = false;
			break;
		case D:
			moveRight = false;
			break;
		case A:
			moveLeft = false;
			break;
		}
	}
	public void fireSplash()
	{
		((GameScreen)getParent()).getEngine().queueToAdd(
				new PlayerSplash(
						//getCenterX and stuff should be in thing
						getCenterX() - (ClassProportions.PROJECTILE_PLAYER_WIDTH / 2),
						getY() - ClassProportions.PROJECTILE_PLAYER_HEIGHT)
					
				);
	}
	protected void doMove()
	{
		if(moveLeft ^ moveRight) {
			if(moveLeft) {
				if(getX() >= deltaX)setX(getX() - deltaX);
				else setX(0);
			}
			if(moveRight)
			{
				if(getX() < (ClassProportions.SCREEN_W - width - deltaX))
					setX(getX() + deltaX);
				else setX(ClassProportions.SCREEN_W - width - deltaX);
			}
		}
		if (moveUp ^ moveDown)
	}
}
