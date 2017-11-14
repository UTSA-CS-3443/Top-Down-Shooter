package application.game;


public class Mannequin {
	int health = Health.ENEMY_HEALTH;
	int X_VALUE;
	int Y_VALUE;
	boolean IS_TOUCHING = false;
	 
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
}
