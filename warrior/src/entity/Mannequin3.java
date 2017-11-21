package entity;

import application.Health;
import application.Resources;
import application.Figurations;
import application.GameScreen;
import application.GameStarter;
import application.Timing;

public class Mannequin3 extends Enemy {
 
    public Mannequin3() {
        super(Resources.SPR_GOTHIC, Figurations.GOTHIC_WIDTH, Figurations.GOTHIC_HEIGHT, 
                Health.MANNEQUIN3, Timing.MANNEQUIN_DELTA_X, 
                (Math.random() < 0.5 ? Direction.LEFT : Direction.RIGHT));
    }
    

    public void reverseDirection() {
        switch (dir) {
            case LEFT:
                dir = Direction.RIGHT; break;
            case RIGHT:
                dir = Direction.LEFT; break;
        }
    }
 
    
    public void fireProjectile() {
        ((GameScreen)getParent()).getEngine();
		GameStarter.queueAddition(
            new MannequinProjectile(getX() + 15, getY() + height));
		GameStarter.queueAddition(
	            new MannequinProjectile(getX() - 15, getY() + height));
		GameStarter.queueAddition(
	            new MannequinProjectile(getX() + 30, getY() + height));
		GameStarter.queueAddition(
	            new MannequinProjectile(getX() - 30, getY() + height));
    }
 
    @Override
    public void doTick() {
        doMovement();
    }
}
