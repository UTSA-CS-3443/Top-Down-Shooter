package entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;



public abstract class Mob extends Entity {
    private int fullHealth;
	private IntegerProperty healthProperty = new SimpleIntegerProperty(100);
	
	public Mob() {}
	
	public Mob(int fullHealth) {
		this.fullHealth = fullHealth;
		healthProperty.set(fullHealth);
	}
	public Mob(String spriteName, int fullHealth) {
		super(spriteName);
		this.fullHealth = fullHealth;
		healthProperty.set(fullHealth);
	}
	public Mob(String spriteName, double width, double height, int fullHealth) {
        super(spriteName, width, height);
        this.fullHealth = fullHealth;
        healthProperty.set(fullHealth);
    }
	public int getFullHealth() {
		return fullHealth;
	}
	public int getProperty() {
		return healthProperty.get();
	}
	public void setProperty(int health) {
		healthProperty.set(health);
	}
	  public void setHealth(int health) {
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
	public int getHealth()
	{
		return healthProperty.get();
	}
}
