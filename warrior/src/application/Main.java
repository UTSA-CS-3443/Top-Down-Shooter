package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
	private double newX = 0;
	private double newY = 0;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//all of my stuff
			primaryStage.setTitle("Paint Warrrior");
			
			
			
			root.setId("pane");
			Circle circle = new Circle(50, 20, 20, Color.RED);
			circle.setCenterX(400);
			circle.setCenterY(300);
			root.getChildren().add(circle);
			
			scene.setOnKeyPressed(e ->{
			    if(e.getCode() == KeyCode.D){
			        newX = newX + 8;
			        circle.setTranslateX(newX);
			        System.out.println("Right");
			    }
			    else if(e.getCode() == KeyCode.A){
			        newX = newX - 8;
			        circle.setTranslateX(newX);
			        System.out.println("Left");
			    }
			    else if(e.getCode() == KeyCode.W){
			        newY = newY - 8;
			        circle.setTranslateY(newY);
			        System.out.println("Up");
			    }
			    else if(e.getCode() == KeyCode.S){
			        newY = newY + 8;
			        circle.setTranslateY(newY);
			        System.out.println("Down");
			    }
			});
			/*int x = warrior.getPaintCount();
			scene.setOnKeyPressed(e->{
				if(e.getCode() == KeyCode.Q) {
					warrior.paintCount++;
					if(warrior.paintCount == 4)
						warrior.paintCount = 0;
					switch(warrior.paintCount) {
					case 0:
						//warrior.paintColor = Color.RED;
						System.out.println("case: 0");
					case 1:
						//warrior.paintColor = Color.BLUE;
						System.out.println("case: 1");
					case 2:
						//warrior.paintColor = Color.GREEN;
					}
				}
			});*/
			
			//end of my stuff
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
