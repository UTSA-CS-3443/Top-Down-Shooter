package application;

import com.sun.prism.paint.Color;

public class warrior {
	private int health = Health.WARRIOR_HEALTH;
	private int paintCount = 0;
	
	public int getHealth() {
		return this.health;
	}
	public void takeDamage() {
		this.health = this.health - Health.ENEMY_DMG;
	}
	public int getPaintCount() {
		return this.paintCount;
		
		
	}
	
}
