
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
	//need to create a timing class
	protected double deltaX = Timing.PLAYER_DELTA_X;
	protected double deltaY = Timing.PLAYER_DELTA_Y;
	
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
	public void Move(KeyBoard key)
	{
		switch(key) {
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
		{
			if(moveUp)
			{
				if(getY() >=(deltaY + height)) setY(getY() - deltay);
				else setY(height);
			}
			if(moveDown)
			{
				if(getY() < (ClassProportions.SCREEN_HEIGHT - height -deltay))
					setY(getY()+deltaY);
				else setY(ClassProportions.SCREEN_HEIGHT - height - deltaY)
			}
		}
	}
	public void doTick()
	{
		doMove();
		
		if(moveLeft ^ moveRight)
		{
			//views of the sprites if we need it
			if(moveLeft)setImage(leftView);
			if(moveRight)setImage(rightView);
		}else setImage(view);
	}
}
