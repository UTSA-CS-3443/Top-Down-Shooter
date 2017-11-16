package application.game;

import application.ClassProportions;

public class MannequinSplash extends Splash{

	public MannequinSplash()
	{
		super(Resources.SPR_MANNEQUIN, ClassProportions.MANNEQUIN_W,ClassProportions.MANNEQUIN_H,
				Health.MANNEQUIN_HEALTH,Timing.MANNEQUIN_X,
				(Math.random()< 0.5 ? KeyBoard.LEFT : KeyBoard.RIGHT));
	}
}
