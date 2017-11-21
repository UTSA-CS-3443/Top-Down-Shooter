package application;


import javafx.scene.control.Label;
import application.Points;
public class Display {
	
	Label killCount = new Label("Kill" + Points.numberOfKills);
	Label totalKills = new Label("Total Kills" + Points.numberOfTotalKills);
}
