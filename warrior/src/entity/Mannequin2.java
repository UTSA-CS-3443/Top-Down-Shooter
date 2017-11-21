package entity;

import application.Health;
import application.Resources;
import application.Figurations;
import application.GameScreen;
import application.GameStarter;
import application.Timing;

public class Mannequin2 extends Enemy {
 
    public Mannequin2() {
        super(Resources.SPR_SCREAM, Figurations.SCREAM_WIDTH, Figurations.SCREAM_HEIGHT, 
                Health.MANNEQUIN2, Timing.MANNEQUIN_DELTA_X, 
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
            new MannequinProjectile(getX(), getY() + height));
		GameStarter.queueAddition(
	            new MannequinProjectile(getX(), getY() + height + 30));
		GameStarter.queueAddition(
	            new MannequinProjectile(getX(), getY() + height + 60));
    }
 
    @Override
    public void doTick() {
        doMovement();
    }
}
