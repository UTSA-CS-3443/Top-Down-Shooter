package entity;

import application.Health;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;




public class Warrior extends Mob {
	
	
	
			
			// Should be in this format to create a Player - BVP 13:11 11/17
			/*
			public static Image image1 = new Image(String url, double requestedWidth, double requestedHeight,
					boolean preserveRatio,boolean smooth);*/
	static Circle circle1 = new Circle(50, 20, 20, Color.RED);
	public static Image player = new Image("/warrior/horribleCircle.JPG", 40, 40, false, false); 
	
	private int health = Health.WARRIOR_HEALTH;
	private int paintCount = 0;
	
	public int getHealth() {
		return this.health;
	}
	public void takeDamage() {
		this.health = this.health - Health.ENEMY_DMG;
	}
	public int getPaintCount() {
		return this.paintCount;
	}
	
	
	
		//	
/*
			root.setId("pane");
			Circle circle = new Circle(50, 20, 20, Color.RED);
			circle.setCenterX(400);
			circle.setCenterY(300);
			root.getChildren().add(circle);*/

}
