package application.game;

import application.ClassProportions;

public class MannequinSplash extends Splash{

	 public MannequinSplash() {
	        super(Resources.SPR_MANNEQUIN_SPLASH, ClassProportions.SPLASH_MANNEQUIN_W, 
	        		ClassProportions.SPLASH_MANNEQUIN_H, Health.SPLASH_MANNEQUIN_DMG);
	    }
	 public MannequinSplash(double startX, double startY) {
	        super(Resources.SPR_MANNEQUIN_SPLASH, ClassProportions.SPLASH_MANNEQUIN_W, 
	        		ClassProportions.SPLASH_MANNEQUIN_H, Health.SPLASH_MANNEQUIN_DMG,
	              startX, startY, Timing.SPLASH_MANNEQUIN_X,
	              Timing.SPLASH_MANNEQUIN_Y);
	    }

}
