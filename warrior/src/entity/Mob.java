package entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Mob extends Entity {
    private int health;
	private IntegerProperty healthProperty = new SimpleIntegerProperty(100);
	
	public Mob() {}
	
	public Mob(int Health) {
		this.health = health;
		healthProperty.set(maxHealth);
	}
	
}
