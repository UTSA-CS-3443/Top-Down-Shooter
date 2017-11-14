
package application.game;

public class Warrior {

	private int X_VALUE;
	private int Y_VALUE;
	private int health = Health.PLAYER_HEALTH;
	
	public int getX_VALUE() {
		return this.X_VALUE;
	}
	public void setX_VALUE(int x) {
		this.X_VALUE = x;
	}
	public int getY_VALUE() {
		return this.Y_VALUE;
	}
	public void setY_VALUE(int y) {
		this.Y_VALUE = y;
	}
}
