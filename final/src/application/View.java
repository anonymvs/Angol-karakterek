package application;

import java.awt.Color;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class View extends Canvas {
	private Player jaffa;
	private Player oneill;
	GraphicsContext gc;
	
	Image imgFloor = null;
	
	View(int width, int height) {
		super(width, height);
		
        //imgFloor = new Image("/final/floor.png");
        
        gc = getGraphicsContext2D();
        gc.strokeOval(60, 60, 30, 30);
        //drawFloor(60, 60);
	}
	
	void drawFloor(int x, int y){
		gc.drawImage(imgFloor, x, y);
	}
	void drawChasm(int x, int y){	
	}
	void drawWall(int x, int y){	
	}
	void drawPortal(int x, int y, Color color){	
	}
	void drawBox(int x, int y, int number){	
	}
	void drawPlayer(int x, int y, PlayerType playerType){	
	}
	void drawOpener(int x, int y){	
	}
	void drawReplicator(int x, int y){	
	}
	void drawMissile(int x, int y){	
	}
	void drawZPM(int x, int y){
	}
}