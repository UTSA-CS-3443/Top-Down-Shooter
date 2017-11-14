package application.game;

import javafx.scene.Scene;

import java.util.ArrayList;

import javafx.animation.Timeline;

public class GameStarter {
	private GameScreen screen;
	private Scene scene;

	private Timeline gameLoop;
	private Timeline smallEnemyAttack;
	private Timeline bigEnemeyAttack;
	
	private Player player = new Player();
	private ArrayList<Entity> entities = new ArrayList<>();
	private ArrayList<Enemy> enemy = new ArrayList<>();
	ArrayList<Projectiles> projectiles = new ArrayList<>();
	
	
	
	
}
