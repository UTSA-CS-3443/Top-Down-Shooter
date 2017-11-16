package application.game;

public class Splash extends Thing {
	
	protected double dX = 0.0;
	protected double dY = 0.0;
	protected int damage = 1000;
	
	public Splash(String name, int damage) {
		super();
		this.damage = damage;
	}
<<<<<<< HEAD
=======
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
	public double getdX() {
		return dX;
	}
	public void setDX(double dX) {
		this.dX = dX;
	}
	public void setDY(double dY) {
		this.dY = dY;
	}
	public int getDamage() {
		return damage;
	}
	public int setDamage(int damage) {
		this.damage = damage;
	}
	protected void doMov() {
		setX(getX() - dX);
		setY(getX() - dY);
	}
	
	@Override
	public void tick() {
		doMov();
	}
>>>>>>> branch 'master' of https://github.com/UTSA-CS-3443/Top-Down-Shooter.git
}
