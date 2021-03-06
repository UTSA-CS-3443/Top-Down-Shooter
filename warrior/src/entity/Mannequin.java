package entity;

import application.Health;
import application.Resources;
import application.Figurations;
import application.GameScreen;
import application.GameStarter;
import application.Timing;

public class Mannequin extends Enemy {
 
    public Mannequin() {
        super(Resources.SPR_MANNEQUIN, Figurations.MANNEQUIN_WIDTH, Figurations.MANNEQUIN_HEIGHT, 
                Health.MANNEQUIN, Timing.MANNEQUIN_DELTA_X, 
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
            new MannequinProjectile(getX() + 25, getY() + height));
    }
 
    @Override
    public void doTick() {
        doMovement();
    }
}
