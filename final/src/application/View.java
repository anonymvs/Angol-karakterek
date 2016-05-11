package application;

import java.awt.Color;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class View extends Canvas {
	private Player jaffa;
	private Player oneill;
	GraphicsContext gc;
	
	View(int width, int height) {
		super(width, height);
        gc = getGraphicsContext2D();
        gc.strokeOval(60, 60, 30, 30);
	}
	
	void drawFloor(int x, int y){	
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
	/*void KeyEvent(Event event){	
	}*/	
}