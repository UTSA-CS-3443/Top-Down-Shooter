package application;

import com.sun.prism.paint.Color;

import javafx.scene.shape.Circle;

public class Projectiles extends Entity{
	protected double deltaX = 0.0;
	protected double deltaY = 0.0;
	protected int damage = 9999;
	
	public Projectile()
	{
		Circle circle = new Circle(2,2,2);
		
	}
}
