
package application;
import application.game.*;
public class WarriorProjectiles extends Projectiles {
    

    public WarriorProjectiles() {
        super(Resources.BULLET, Figurations.BULLET_WIDTH, 
              Figurations.BULLET_HEIGHT, Health.WARRIOR_DMG);
    }
  
    public WarriorProjectiles(double originX, double originY) {
        super(Resources.BULLET, Figurations.BULLET_WIDTH, 
              Figurations.BULLET_HEIGHT, Health.WARRIOR_DMG,
              originX, originY, Timing.PROJECTILE_WARRIOR_DELTA_X,
              Timing.PROJECTILE_WARRIOR_DELTA_Y);
    }
}
