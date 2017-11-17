package application.game;

import application.game.Thing;

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
	public Splash(String name, double W, double H, int damage, 
			double startX, double startY, double dX, double dY) {
		super(name, W, H);
		this.damage = damage;
		this.dX = dX;
		this.dY = dY;
		setX(startX);
		setY(startY);
	}
	/*public Splash(String sprMannequin, double mannequinW, double mannequinH, int mannequinHealth, double mannequinX,
			Object object) {
		// TODO Auto-generated constructor stub
	}*/

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
	public void setDamage(int damage) {
		this.damage = damage;
	}
	protected void doMov() {
		setX(getX() - dX);
		setY(getX() - dY);
	}
	
	@Override
	public void Tick() {
		doMov();
	}
}
