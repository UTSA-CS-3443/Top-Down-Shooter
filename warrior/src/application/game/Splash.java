package application.game;

public class Splash extends Thing {
	
	protected double dX = 0.0;
	protected double dY = 0.0;
	protected int damage = 1000;
	
	public Splash(String name, int damage) {
		super();
		this.damage = damage;
	}
	public Splash(String name, double W, double H, int damage) {
		super();
		this.damage = damage;
	}
	public Splash(String name, double W, double H, int damage, double startX, double startY, double dX, double dY) {
		super();
		this.damage = damage;
		this.dX = dX;
		this.dY = dY;
		setX(startX);
		setY(startY);
	}
	
}
