package application;

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
	Image imgBoxSmall = new Image("graphics/boxSmall.gif", gridSize, gridSize, false, false);
	Image imgChasm = new Image("graphics/chasm.gif", gridSize, gridSize, false, false);
	Image imgWall = new Image("graphics/wall.gif", gridSize, gridSize, false, false);
	Image imgPortalWall= new Image("graphics/portalwall.gif", gridSize, gridSize, false, false);
	Image imgMissile = new Image("graphics/fireball.png", gridSize, gridSize, false, false);
	Image imgOpener = new Image("graphics/libre.gif", gridSize, gridSize, false, false);
	Image imgDoorOpened = new Image("graphics/doorOpened.gif", gridSize, gridSize, false, false);
	Image imgDoorClosed = new Image("graphics/doorClosed.gif", gridSize, gridSize, false, false);
	Image imgONeillNorth = new Image("graphics/oneillNorth.png", gridSize, gridSize, false, false);
	Image imgONeillSouth = new Image("graphics/oneillSouth.png", gridSize, gridSize, false, false);
	Image imgONeillEast = new Image("graphics/oneillEast.png", gridSize, gridSize, false, false);
	Image imgONeillWest = new Image("graphics/oneillWest.png", gridSize, gridSize, false, false);
	Image imgJaffaNorth = new Image("graphics/jaffaNorth.png", gridSize, gridSize, false, false);
	Image imgJaffaSouth = new Image("graphics/jaffaSouth.png", gridSize, gridSize, false, false);
	Image imgJaffaEast = new Image("graphics/jaffaEast.png", gridSize, gridSize, false, false);
	Image imgJaffaWest = new Image("graphics/jaffaWest.png", gridSize, gridSize, false, false);
	Image imgReplicatorNorth = new Image("graphics/replNorth.png", gridSize, gridSize, false, false);
	Image imgReplicatorSouth = new Image("graphics/replSouth.png", gridSize, gridSize, false, false);
	Image imgReplicatorEast = new Image("graphics/replEast.png", gridSize, gridSize, false, false);
	Image imgReplicatorWest = new Image("graphics/replWest.png", gridSize, gridSize, false, false);
	Image imgZPM = new Image("graphics/ZPM_insize.gif", gridSize, gridSize, false, false);
	Image imgPortalBlue = new Image("graphics/portalblue.gif", gridSize, gridSize, false, false);
	Image imgPortalYellow = new Image("graphics/portalyellow.gif", gridSize, gridSize, false, false);
	Image imgPortalRed = new Image("graphics/portalred.gif", gridSize, gridSize, false, false);
	Image imgPortalGreen = new Image("graphics/portalgreen.gif", gridSize, gridSize, false, false);
	Image imgMissileGreen = new Image("graphics/fbgreen.png", gridSize, gridSize, false, false);
	Image imgMissileRed = new Image("graphics/fbred.png", gridSize, gridSize, false, false);
	Image imgMissileYellow = new Image("graphics/fbyellow.png", gridSize, gridSize, false, false);
	Image imgMissileBlue = new Image("graphics/fbblue.png", gridSize, gridSize, false, false);
	
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
	
	void drawFloor(int x, int y) {
		gc.drawImage(imgFloor, x * gridSize, y * gridSize);
	}
	void drawChasm(int x, int y) {
		gc.drawImage(imgChasm, x * gridSize, y * gridSize);
	}
	void drawWall(int x, int y) {	
		gc.drawImage(imgWall, x * gridSize, y * gridSize);
	}
	void drawPortal(int x, int y, MissileColor color){
		switch (color)
		{
			case Blue:
				gc.drawImage(imgPortalBlue, x * gridSize, y * gridSize);
				break;
			case Yellow:
				gc.drawImage(imgPortalYellow, x * gridSize, y * gridSize);
				break;
			case Green:
				gc.drawImage(imgPortalGreen, x * gridSize, y * gridSize);
				break;
			case Red:
				gc.drawImage(imgPortalRed, x * gridSize, y * gridSize);
				break;
		}
	}
	void drawPortalWall(int x, int y) {
		gc.drawImage(imgPortalWall, x * gridSize, y * gridSize);	
	}
	void drawBox(int x, int y, int number) {
		for(int i = 0; i < number; i++) {
			gc.drawImage(imgBoxSmall, x * gridSize, y * gridSize - (i * 5));
		}
	}
	void drawBox(int x, int y) {	
		gc.drawImage(imgBox, x * gridSize, y * gridSize);
	}
	void drawONeill(int x, int y) {
		switch(oneill.getDirection()){
			case Right:
				gc.drawImage(imgONeillEast, x * gridSize, y * gridSize);
				break;
			case Left:
				gc.drawImage(imgONeillWest, x * gridSize, y * gridSize);
				break;
			case Top:
				gc.drawImage(imgONeillNorth, x * gridSize, y * gridSize);
				break;
			case Bottom:
				gc.drawImage(imgONeillSouth, x * gridSize, y * gridSize);
				break;
		}
		
	}
	void drawJaffa(int x, int y) {
		switch(jaffa.getDirection()){
			case Right:
				gc.drawImage(imgJaffaEast, x * gridSize, y * gridSize);
				break;
			case Left:
				gc.drawImage(imgJaffaWest, x * gridSize, y * gridSize);
				break;
			case Top:
				gc.drawImage(imgJaffaNorth, x * gridSize, y * gridSize);
				break;
			case Bottom:
				gc.drawImage(imgJaffaSouth, x * gridSize, y * gridSize);
				break;
		}
	}
	void drawOpener(int x, int y) {	
		gc.drawImage(imgOpener, x * gridSize, y * gridSize);
	}
	void drawReplicator(int x, int y, Direction dir) {	
		switch(dir){
		case Right:
			gc.drawImage(imgReplicatorEast, x * gridSize, y * gridSize);
			break;
		case Left:
			gc.drawImage(imgReplicatorWest, x * gridSize, y * gridSize);
			break;
		case Top:
			gc.drawImage(imgReplicatorNorth, x * gridSize, y * gridSize);
			break;
		case Bottom:
			gc.drawImage(imgReplicatorSouth, x * gridSize, y * gridSize);
			break;
	}
	}
	void drawMissile(int x, int y, MissileColor color) {
		switch (color){
			case Blue:
				gc.drawImage(imgMissileBlue, x * gridSize, y * gridSize);
				break;
			case Yellow:
				gc.drawImage(imgMissileYellow, x * gridSize, y * gridSize);
				break;
			case Green:
				gc.drawImage(imgMissileGreen, x * gridSize, y * gridSize);
				break;
			case Red:
				gc.drawImage(imgMissileRed, x * gridSize, y * gridSize);
				break;
		}
	}
	void drawZPM(int x, int y) {
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

		switch (key){
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
			case Y:
				oneill.shoot(MissileColor.Yellow, level);
				break;
			case B:
				oneill.shoot(MissileColor.Blue, level);
				break;
			case R:
				jaffa.shoot(MissileColor.Red, level);
				break;
			case G:
				jaffa.shoot(MissileColor.Green, level);
				break;
			case LEFT:
				jaffa.move(Direction.Left);
				break;
			case DOWN:
				jaffa.move(Direction.Bottom);
				break;
			case RIGHT:
				jaffa.move(Direction.Right);
				break;
			case UP:
				jaffa.move(Direction.Top);
				break;
			case SPACE:
				oneill.boxing();
				break;
			case BACK_SPACE:
				jaffa.boxing();
				break;
			default:
				break;
		}
		level.draw();
	}
	
}