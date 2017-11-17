package application.game;

import application.ClassProportions;
import application.game.Timing;
import application.game.KeyBoard;

public abstract class Mannequin extends Enemy {
	
	public Mannequin() {
		super(Resources.SPR_MANNEQUIN, ClassProportions.MANNEQUIN_W, ClassProportions.MANNEQUIN_H, 
                Health.MANNEQUIN_HEALTH, Timing.MANNEQUIN_X, 
                (Math.random() < 0.5 ? KeyBoard.LEFT : KeyBoard.RIGHT));
	}
	public void reverseKey() {
        switch (key) {
            case LEFT:
                key = KeyBoard.RIGHT; 
                break;
            case RIGHT:
                key = KeyBoard.LEFT; 
                break;
        }
    }
	public void shootSplash() {
        ((GameScreen)getParent()).getStarter().addToQ(
            new MannequinSplash(getX() + 5, getY() + height));
        ((GameScreen)getParent()).getStarter().addToQ(
            new MannequinSplash(getX() + 54, getY() + height));
    }
	@Override
    public void Tick() {
        doMovement();
    }

}
