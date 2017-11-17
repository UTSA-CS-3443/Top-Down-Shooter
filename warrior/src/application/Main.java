package application;





import entity.Warrior;
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
			

			Warrior warrior = new Warrior();   //BVP 1329 11/7

			
			
			root.setId("pane");
			Circle circle = new Circle(50, 20, 20, Color.RED);
			circle.setCenterX(400);
			circle.setCenterY(300);
			root.getChildren().add(circle);
			
			scene.setOnKeyPressed(e ->{
			    if(e.getCode() == KeyCode.D){
			        newX = newX + 8;
			        circle.setTranslateX(newX);
			    }
			    else if(e.getCode() == KeyCode.A){
			        newX = newX - 8;
			        circle.setTranslateX(newX);
			    }
			    else if(e.getCode() == KeyCode.W){
			        newY = newY - 8;
			        circle.setTranslateY(newY);
			    }
			    else if(e.getCode() == KeyCode.S){
			        newY = newY + 8;
			        circle.setTranslateY(newY);
			    }
			    else SPACE:
			    	warrior.fireProjectile();
			});
			
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
