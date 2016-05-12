package application;
	

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Great game brah");

        // Creating and initializng game elements
        Player oneill = new Player(PlayerType.ONeill);
        Player jaffa = new Player(PlayerType.Jaffa);
        Level level = new Level();
        Replicator rep = new Replicator(level);
        level.load(getClass().getResource("/levels/ultimatelevel.txt").getFile(), oneill, jaffa, rep);

        Group g = new Group();
        Scene scene = new Scene(g, View.gridSize * level.getWidth(), View.gridSize * level.getHeight(), Color.web("0xFFFFFF", 1.0));
        
        // Set up the drawing & controlling view
        View view = new View(level, oneill, jaffa);
        // Set focus so that view can listen to key events
        view.setFocusTraversable(true);
        level.setView(view);
        
        level.draw();
        
        g.getChildren().add(view);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);		
	}
}
