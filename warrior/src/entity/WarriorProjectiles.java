
package entity;

import application.Figurations;
import application.Health;
import application.Resources;
import application.Timing;


public class WarriorProjectiles extends Projectiles {
    

    public WarriorProjectiles() {
        super(Resources.SPR_PROJECTILE_WARRIOR, Figurations.PROJECTILE_WARRIOR_WIDTH, 
              Figurations.PROJECTILE_WARRIOR_HEIGHT, Health.PROJECTILE_WARRIOR_DMG);
    }

    public WarriorProjectiles(double originX, double originY) {
        super(Resources.SPR_PROJECTILE_WARRIOR, Figurations.PROJECTILE_WARRIOR_WIDTH, 
              Figurations.PROJECTILE_WARRIOR_HEIGHT, Health.PROJECTILE_WARRIOR_DMG,
              originX, originY, Timing.PROJECTILE_WARRIOR_DELTA_X,
              Timing.PROJECTILE_WARRIOR_DELTA_Y);
    }
}
