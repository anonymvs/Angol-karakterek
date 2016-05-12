package application;

import java.awt.Color;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class View extends Canvas {
	private Player jaffa = null;
	private Player oneill = null;
	private Level level = null;
	
	// Determines the size of each cell
	final static int gridSize = 64;
	
	GraphicsContext gc;

	// Load all the the images
	Image imgFloor = new Image("graphics/floor.gif", gridSize, gridSize, false, false);
	Image imgBox = new Image("graphics/box.gif", gridSize, gridSize, false, false);
	Image imgChasm = new Image("graphics/chasm.gif", gridSize, gridSize, false, false);
	Image imgWall = new Image("graphics/wall.gif", gridSize, gridSize, false, false);
	Image imgPortalWall= new Image("graphics/portalwall.gif", gridSize, gridSize, false, false);
	Image imgMissile = new Image("graphics/fireball.png", gridSize, gridSize, false, false);
	Image imgOpener = new Image("graphics/libre.gif", gridSize, gridSize, false, false);
	Image imgDoorOpened = new Image("graphics/doorOpened.gif", gridSize, gridSize, false, false);
	Image imgDoorClosed = new Image("graphics/doorClosed.gif", gridSize, gridSize, false, false);
	Image imgONeill = new Image("graphics/oneillSingle.gif", gridSize, gridSize, false, false);
	Image imgJaffa = new Image("graphics/jaffaSingle.gif", gridSize, gridSize, false, false);
	Image imgReplicator = new Image("graphics/replSingle.gif", gridSize, gridSize, false, false);
	Image imgZPM = new Image("graphics/ZPM_insize.gif", gridSize, gridSize, false, false);
	
	View(Level level, Player oneill, Player jaffa) {
		super(gridSize * level.getWidth(), gridSize * level.getHeight());
		this.level = level;
		this.oneill = oneill;
		this.jaffa = jaffa;		
        
        gc = getGraphicsContext2D();
        
        // Keyevent
        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                handleKeyEvent(event);
            }
        });
	}
	
	void drawFloor(int x, int y){
		gc.drawImage(imgFloor, x * gridSize, y * gridSize);
	}
	void drawChasm(int x, int y){
		gc.drawImage(imgChasm, x * gridSize, y * gridSize);
	}
	void drawWall(int x, int y){	
		gc.drawImage(imgWall, x * gridSize, y * gridSize);
	}
	void drawPortal(int x, int y, Color color){
		// TODO
		gc.drawImage(imgFloor, x * gridSize, y * gridSize);	
	}
	void drawPortalWall(int x, int y){
		gc.drawImage(imgPortalWall, x * gridSize, y * gridSize);	
	}
	void drawBox(int x, int y, int number){	
		gc.drawImage(imgBox, x * gridSize, y * gridSize);
	}
	void drawONeill(int x, int y){
		gc.drawImage(imgONeill, x * gridSize, y * gridSize);
	}
	void drawJaffa(int x, int y){
		gc.drawImage(imgJaffa, x * gridSize, y * gridSize);
	}
	void drawOpener(int x, int y){	
		gc.drawImage(imgOpener, x * gridSize, y * gridSize);
	}
	void drawReplicator(int x, int y){	
		gc.drawImage(imgReplicator, x * gridSize, y * gridSize);
	}
	void drawMissile(int x, int y){	
		gc.drawImage(imgMissile, x * gridSize, y * gridSize);
	}
	void drawZPM(int x, int y){
		gc.drawImage(imgZPM, x * gridSize, y * gridSize);
	}
	void drawDoorOpened(int x, int y) {
		gc.drawImage(imgDoorOpened, x * gridSize, y * gridSize);
	}
	void drawDoorClosed(int x, int y) {
		gc.drawImage(imgDoorClosed, x * gridSize, y * gridSize);
	}
	
	private void handleKeyEvent(KeyEvent event) {
		KeyCode key = event.getCode();

		switch (key)
		{
			case A:
				oneill.move(Direction.Left);
				break;
			case S:
				oneill.move(Direction.Bottom);
				break;
			case D:
				oneill.move(Direction.Right);
				break;
			case W:
				oneill.move(Direction.Top);
				break;
			default:
				break;
		}
		level.draw();
	}
	
}