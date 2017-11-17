
package application;
import entity.Entity;
import application.game.*;
public class Projectiles extends Entity {

   
    protected double deltaX = 0.0;
    protected double deltaY = 0.0;
    protected int damage = 9999;
    

    public Projectiles() {
        super(Resources.BULLET, 8, 8);
    }
    

    public Projectiles(String spriteName, int damage) {
        super(spriteName, 8, 8);
        this.damage = damage;
    }
    
 
    public Projectiles(String spriteName, double width, double height, int damage) {
        super(spriteName, width, height);
        this.damage = damage;
    }
    
  
    public Projectiles(String spriteName, double width, double height, int damage,
            double originX, double originY, double deltaX, double deltaY) {
        super(spriteName, width, height);
        this.damage = damage;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        setX(originX);
        setY(originY);
    }

 
    public double getDeltaX() {
        return deltaX;
    }


    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

 
    public double getDeltaY() {
        return deltaY;
    }


    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }


    public int getDamage() {
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }

    protected void doMovement() {
        setX(getX() - deltaX);
        setY(getY() - deltaY);
    }
    

    @Override
    public void doTick() {
        doMovement();
    }
    
}
