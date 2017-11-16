
package application.game;

import application.ClassProportions;
import javafx.scene.image.Image;
import application.game.KeyBoard;
import application.game.Timing;
import application.game.GameScreen;
import application.game.Health;
import application.game.Resources;


public class Warrior extends Mob {

	
	protected boolean moveLeft = false;
	protected boolean moveRight = false;
	protected boolean moveUp = false;
	protected boolean moveDown = false;
	//need to create a timing class
	protected double deltaX = Timing.WARRIOR_DELTA_X;
	protected double deltaY = Timing.WARRIOR_DELTA_Y;
	
	private static Image leftSprite = new Image(Resources.SPR_WARRIOR, 
			ClassProportions.WARRIOR_W, ClassProportions.WARRIOR_H, false, false);
    private static Image rightSprite = new Image(Resources.SPR_WARRIOR, 
    		ClassProportions.WARRIOR_W, ClassProportions.WARRIOR_H, false, false);
	
	public Warrior() {
		super(Resources.SPR_WARRIOR, ClassProportions.WARRIOR_W,
				ClassProportions.WARRIOR_H, Health.WARRIOR_HEALTH);
		setPosition();
	}
	private void setPosition() {
        setX((ClassProportions.WINDOW_W - ClassProportions.WARRIOR_W) / 2);
        setY(ClassProportions.WINDOW_H - ClassProportions.WARRIOR_H);
    }

	private int health = Health.WARRIOR_HEALTH;

	
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
	public void stop(KeyBoard key)
	{
		switch(key)
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
		// javafx.scene.Node.getParent and then get
		((GameScreen)getParent()).getStarter().addToQ(
				new WarriorSplash(getCenterX() - (ClassProportions.SPLASH_WARRIOR_W / 2),
						getY() - ClassProportions.SPLASH_WARRIOR_H)
					
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
				if(getX() < (ClassProportions.WINDOW_W - width - deltaX))
					setX(getX() + deltaX);
				else setX(ClassProportions.WINDOW_W - width - deltaX);
			}
		}
		if (moveUp ^ moveDown)
		{
			if(moveUp)
			{
				if(getY() >=(deltaY + height)) setY(getY() - deltaY);
				else setY(height);
			}
			if(moveDown)
			{
				if(getY() < (ClassProportions.WINDOW_H - height -deltaY))
					setY(getY()+deltaY);
				else setY(ClassProportions.WINDOW_H - height - deltaY);
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
