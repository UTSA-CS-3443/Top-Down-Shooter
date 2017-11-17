package entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Mob extends Entity {
    private int health;
	private IntegerProperty healthProperty = new SimpleIntegerProperty(100);
	
	public Mob() {}
	
	public Mob(int health) {
		this.health = health;
		healthProperty.set(health);
	}
	public Mob(String spriteName, int health) {
		super(spriteName);
		this.health = health;
		healthProperty.set(health);
	}
	public Mob(String spriteName, double width, double height, int health) {
        super(spriteName, width, height);
        this.health = health;
        healthProperty.set(health);
    }
	public int getHealth() {
		return health;
	}
	public int getProperty() {
		return healthProperty.get();
	}
	public void setProperty(int health) {
		healthProperty.set(health);
	}
	public void subtractHealth(int health) {
		healthProperty.set(healthProperty.get() - health);
	}
	public void addHealth(int health) {
		healthProperty.set(healthProperty.get() - health);
	}
	public ReadOnlyIntegerProperty healthPropertyUnmodifiable() {
        return healthProperty;
    }
}
