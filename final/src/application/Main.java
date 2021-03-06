package application;
	

import java.io.File;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Main part of the program
public class Main extends Application {
	
	@Override
	// Initialization
	public void start(Stage primaryStage) {
		// Set the title of the window
		primaryStage.setTitle("Great game brah");

        // Creating and initializing game elements
        Player oneill = new Player(PlayerType.ONeill);
        Player jaffa = new Player(PlayerType.Jaffa);
        Level level = new Level();
        
        // Loads the level
	    String path = new File("bin/levels/level.txt").getAbsolutePath();		
        level.load(path, oneill, jaffa);

        Group g = new Group();
        Scene scene = new Scene(g, View.gridSize * level.getWidth(), View.gridSize * level.getHeight(), Color.web("0xFFFFFF", 1.0));
        
        // Set up the drawing & controlling view
        View view = new View(level, oneill, jaffa);
        // Set focus so that view can listen to key events
        view.setFocusTraversable(true);
        level.setView(view);
        
        // Draws the level
        level.draw();
        
        g.getChildren().add(view);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	// Main function
	public static void main(String[] args) {
		launch(args);		
	}
}
