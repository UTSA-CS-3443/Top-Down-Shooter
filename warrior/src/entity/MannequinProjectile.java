package entity;

import application.Resources;
import application.Figurations;
import application.Health;
import application.Timing;


public class MannequinProjectile extends Projectiles implements EnemyProjectile {
    
   
    public MannequinProjectile() {
        super(Resources.SPR_PROJECTILE_MANNEQUIN, Figurations.PROJECTILE_MANNEQUIN_WIDTH, 
              Figurations.PROJECTILE_MANNEQUIN_HEIGHT, Health.PROJECTILE_MANNEQUIN_DMG);
    }
    
    public MannequinProjectile(double originX, double originY) {
        super(Resources.SPR_PROJECTILE_MANNEQUIN, Figurations.PROJECTILE_MANNEQUIN_WIDTH, 
              Figurations.PROJECTILE_MANNEQUIN_HEIGHT, Health.PROJECTILE_MANNEQUIN_DMG,
              originX, originY, Timing.PROJECTILE_MANNEQUIN_DELTA_X,
              Timing.PROJECTILE_MANNEQUIN_DELTA_Y);
    }
    
}
