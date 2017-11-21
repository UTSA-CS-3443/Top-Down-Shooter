package application;

import application.GameStarter;
import entity.Mannequin;
import entity.Mannequin2;
import entity.Mannequin3;
public class Round {
	
	public static int ROUNDS = 0;
	
	public static int KILL_COUNT = 0;
	
	
	public static void spawnEnemies()
	{
	
		if(ROUNDS == 0)
		{
			if(GameStarter.enemies.size() != 3) 
			{
				if(GameStarter.enemies.size() == 2)
				{
					GameStarter.queueAddition(new Mannequin());
				}
				else if (GameStarter.enemies.size() == 1)
				{
					GameStarter.queueAddition(new Mannequin());
				}
				else
				{
					GameStarter.queueAddition(new Mannequin());
					GameStarter.queueAddition(new Mannequin());
					GameStarter.queueAddition(new Mannequin());
				}
        	}
		}
		else if (ROUNDS == 1)
		{
			if(GameStarter.enemies.size() != 5) 
			{
				if(GameStarter.enemies.size() == 4)
				{
					GameStarter.queueAddition(new Mannequin2());

				}
				else if(GameStarter.enemies.size() == 3)
				{
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());

				}
				else if(GameStarter.enemies.size() == 2)
				{
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());
				}
				else if (GameStarter.enemies.size() == 1)
				{
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());
				}
				else
				{
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());
					GameStarter.queueAddition(new Mannequin2());
				}
        	}
		}
			
	else
	{
		if(GameStarter.enemies.size() != 7) 
		{
			if(GameStarter.enemies.size() == 6)
			{
				GameStarter.queueAddition(new Mannequin3());
			}
			else if(GameStarter.enemies.size() == 5)
			{
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
			}
			else if(GameStarter.enemies.size() == 4)
			{
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());

			}
			else if(GameStarter.enemies.size() == 3)
			{
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());

			}
			else if(GameStarter.enemies.size() == 2)
			{
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
			}
			else if (GameStarter.enemies.size() == 1)
			{
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
			}
			else
			{
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
				GameStarter.queueAddition(new Mannequin3());
			}
    	}
	}
		
}
}
