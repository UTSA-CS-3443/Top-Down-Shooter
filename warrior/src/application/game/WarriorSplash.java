package application.game;

public class WarriorSplash extends Splash {

	public WarriorSplash() {
		super(Resource.SPRITE_FOR_SPLASH_WARRIOR, ClassProportions.SPLASH_WARRIOR_W
				,ClassProportions.SPLASH_H, Healh. SPLASH_WARRIOR_DMG);
		// TODO Auto-generated constructor stub
	}
	public WarriorSplash(double originX, double originY)
	{
		super(Resources.SPRITE_FOR_SPLASH_WARRIOR, ClassProportions.SPLASH_WARRIOR_W,
				ClassProportions.SPLASH_WARRIOR_H, Health.SPLASH_WARRIOR_DMG,
				originX,originY,Timing.SPLASH_WARRIOR_DELTA_X,Timing.SPLASH_WARRIOR_DELTA_Y);
	}
}
