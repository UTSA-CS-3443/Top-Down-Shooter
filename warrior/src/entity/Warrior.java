package entity;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;




public class Warrior extends Mob {
	
	
	
			
			// Should be in this format to create a Player - BVP 13:11 11/17
			/*
			public static Image image1 = new Image(String url, double requestedWidth, double requestedHeight,
					boolean preserveRatio,boolean smooth);*/

		//	

			root.setId("pane");
			Circle circle = new Circle(50, 20, 20, Color.RED);
			circle.setCenterX(400);
			circle.setCenterY(300);
			root.getChildren().add(circle);

}
