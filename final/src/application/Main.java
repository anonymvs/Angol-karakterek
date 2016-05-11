package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {		
		
		primaryStage.setTitle("Great game brah");

        Group g = new Group();
        Scene scene = new Scene(g, 600, 600, Color.web("0xFFFFFF", 1.0));

        // TESTING THE MY DRAWING SKILLS
        View view = new View(600, 600);
        
        g.getChildren().add(view);
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
