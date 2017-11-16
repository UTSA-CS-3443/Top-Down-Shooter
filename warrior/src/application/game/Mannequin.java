package application.game;


public abstract class Mannequin extends Mob {
	private int health = Health.MANNEQUIN_HEALTH;
	private int X_VALUE;
	private int Y_VALUE;
	private boolean IS_TOUCHING = false;
	
	protected KeyBoard dir;
	 
	public void setPosition(int x, int y) {
		this.X_VALUE = x;
		this.Y_VALUE = y;
	}
	public int getX_VALUE() {
		return this.X_VALUE;
	}
	public int getY_VALUE() {
		return this.Y_VALUE;
	}
	public void setTouch(boolean x) {
		this.IS_TOUCHING = x;
	}
	public boolean getTouch() {
		return this.IS_TOUCHING;
	}
	public int getHealth() {
		return this.health;
	}
	public void takeDamage() {
		this.health = this.health - Health.MANNEQUIN_HEALTH_DMG;
	}
}
