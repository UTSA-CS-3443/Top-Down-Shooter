package application.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


//public class Thing {
//TODO BVP 
	public abstract class Thing extends ImageView {
		
		protected double width = 16;
	    protected double height = 16;
	    // create protected image object BVP
	    protected Image sprite = new Image("/warrior/warrior/src/applicaiton/files/bobross.png" , 
                width, height, false, false);
	    
	    
	    public Thing() {
	        super.setImage(sprite);
	        setFitHeight(height);
	        setFitWidth(width);
	    }
	    
	    public Thing(String nameOfSprite) {
	        sprite = new Image(nameOfSprite, this.width, this.height, false, false);
	        super.setImage(sprite);
	        setFitHeight(height);
	        setFitWidth(width);
	    }
	    
	    
	    
	    
	    public Thing(String nameOfSprite, double width, double height) {
	        this.width = width;
	        this.height = height;
	        sprite = new Image(nameOfSprite, width, height, false, false);
	        super.setImage(sprite);
	        setFitHeight(height);
	        setFitWidth(width);
	    }
	    public Thing( String nameOfSprite, double width, double height, int i) {
	    	//dunno if we need this overloaded method - BVP
	    }
	    
	    
	    public double getWidth() {
	        return width;
	    }
	    
	    public double getHeight() {
	        return height;
}
	    
	    
	    public double getCenterX() {
	        return getX() + (width / 2);
	    }
	    
	    public double getCenterY() {
	        return getY() + (height / 2);
	    }
	    
	    public abstract void Tick();
	    
	    
	    
}
