package application;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

// The view will manage the images
public class View extends Canvas {
	
	// Players, and level
	private Player jaffa = null;
	private Player oneill = null;
	private Level level = null;
	
	// Determines the size of each cell
	final static int gridSize = 50;
	
	GraphicsContext gc;

	// Load all the images
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
	
	// Construct the view object 
	View(Level level, Player oneill, Player jaffa) {
		
		// set the width, and height and sets the players, and level
		super(gridSize * level.getWidth(), gridSize * level.getHeight());
		this.level = level;
		this.oneill = oneill;
		this.jaffa = jaffa;		
        
        gc = getGraphicsContext2D();
        
        // keyevent
        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                handleKeyEvent(event);
            }
        });
	}
	
	public void setONeill(Player o) {
		oneill = o;
	}
	
	public void setJaffa(Player j) {
		jaffa = j;
	}
	
	// Draw floor
	void drawFloor(int x, int y) {
		gc.drawImage(imgFloor, x * gridSize, y * gridSize);
	}
	
	// Draw chasm
	void drawChasm(int x, int y) {
		gc.drawImage(imgChasm, x * gridSize, y * gridSize);
	}
	
	// Draw wall
	void drawWall(int x, int y) {	
		gc.drawImage(imgWall, x * gridSize, y * gridSize);
	}
	
	// Draw portal in its color
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
	
	// Draw portalable wall
	void drawPortalWall(int x, int y) {
		gc.drawImage(imgPortalWall, x * gridSize, y * gridSize);	
	}
	
	// Draw boxes
	void drawBox(int x, int y, int number) {
		for(int i = 0; i < number; i++) {
			gc.drawImage(imgBoxSmall, x * gridSize, y * gridSize - (i * 5));
		}
	}
	
	// Draw box
	void drawBox(int x, int y) {	
		gc.drawImage(imgBox, x * gridSize, y * gridSize);
	}
	
	// Draw oneill with his direction
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
	
	// Draw jaffa with his direction
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
	
	// Draw opener
	void drawOpener(int x, int y) {	
		gc.drawImage(imgOpener, x * gridSize, y * gridSize);
	}
	
	// Draw replicator with its direction
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
	
	// Draw missile with its color
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
	
	// Draw zpm
	void drawZPM(int x, int y) {
		gc.drawImage(imgZPM, x * gridSize, y * gridSize);
	}
	
	// Draw opened door
	void drawDoorOpened(int x, int y) {
		gc.drawImage(imgDoorOpened, x * gridSize, y * gridSize);
	}

	// Draw closed door
	void drawDoorClosed(int x, int y) {
		gc.drawImage(imgDoorClosed, x * gridSize, y * gridSize);
	}
	
	// Handle the button presses
	private void handleKeyEvent(KeyEvent event) {
		KeyCode key = event.getCode();

		// oneills keys
		if(oneill != null) {
			switch(key) {
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
			case SPACE:
				oneill.boxing();
				break;
			default:
				break;
			}
		}
		
		// jaffas keys
		if(jaffa != null) {
			switch (key) {
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
			case BACK_SPACE:
				jaffa.boxing();
				break;
			default:
				break;
			}
		}
		
		// kills oneill, jaffa if it is necessary
		if(oneill != null && !oneill.isAlive())
			oneill = null;
		if(jaffa != null && !jaffa.isAlive())
			jaffa = null;
		
		if(oneill == null && jaffa == null)
			level.endOfGame();
		
		// redraw level
		level.draw();
	}
	
}