package application.game;

import javafx.beans.property.*;

public abstract class Mob extends Thing{
	private IntegerProperty healthProperty = new SimpleIntegerProperty(100);
	private int maxHealth;
	
	public Mob() {}
	
	public Mob(int maxHealth)
	{
		this.maxHealth = maxHealth;
		healthProperty.set(maxHealth);
	}
	public Mob(String spriteName, int maxHealth)
	{
		super(spriteName);
		this.maxHealth = (maxHealth);
		healthProperty.set(maxHealth);
	}
	public Mob(String sprWarrior, double warriorW, double warriorH, int warriorHealth) {
		// TODO Auto-generated constructor stub
		// added by BVP
		super(sprWarrior, warriorW, warriorH);
		this.maxHealth = warriorHealth;
		healthProperty.set(warriorHealth);
		
	}

	public int getMaxHEalth()
	{
		return maxHealth;
	}
	public int getHealth()
	{
		return healthProperty.get();
	}
	public void setHealth(int health)
	{
		healthProperty.set(health);
	}
	public void subtractHealth(int health)
	{
		healthProperty.set(healthProperty.get() - health);
	}
	public void addHealth(int health)
	{
		healthProperty.set(healthProperty.get() - health);
	}
	public ReadOnlyIntegerProperty healthPropertyUnmodifiable()
	{
		return healthProperty;
	}
}
