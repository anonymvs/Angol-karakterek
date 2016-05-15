package application;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

// The view that manages the images
public class View extends Canvas {
	
	// Reference for Jaffa
	private Player jaffa = null;
	// Reference for O'Neill
	private Player oneill = null;
	// Reference for the level
	private Level level = null;
	
	// Determines the size of each cell
	final static int gridSize = 50;
	// Set the relative path
	final String rltvPath = new String("bin/graphics/");
	
	GraphicsContext gc;

	// Loads all the images
	// Loads the image of a floor element
	Image imgFloor = new Image(new File(rltvPath + "floor.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a simple box
	Image imgBox = new Image(new File(rltvPath + "box.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a small box
	Image imgBoxSmall = new Image(new File(rltvPath + "boxSmall.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a chasm element
	Image imgChasm = new Image(new File(rltvPath + "chasm.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a wall element
	Image imgWall = new Image(new File(rltvPath + "wall.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a wall element that a portal can be created on
	Image imgPortalWall= new Image(new File(rltvPath + "portalwall.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of an opener
	Image imgOpener = new Image(new File(rltvPath + "libre.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of an open door
	Image imgDoorOpened = new Image(new File(rltvPath + "doorOpened.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a closed door
	Image imgDoorClosed = new Image(new File(rltvPath + "doorClosed.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of O'Neill looking up
	Image imgONeillNorth = new Image(new File(rltvPath + "oneillNorth.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of O'Neill looking down
	Image imgONeillSouth = new Image(new File(rltvPath + "oneillSouth.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of O'Neill looking right
	Image imgONeillEast = new Image(new File(rltvPath + "oneillEast.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of O'Neill looking left
	Image imgONeillWest = new Image(new File(rltvPath + "oneillWest.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of Jaffa looking up
	Image imgJaffaNorth = new Image(new File(rltvPath + "jaffaNorth.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of Jaffa looking down
	Image imgJaffaSouth = new Image(new File(rltvPath + "jaffaSouth.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of Jaffa looking right
	Image imgJaffaEast = new Image(new File(rltvPath + "jaffaEast.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of Jaffa looking left
	Image imgJaffaWest = new Image(new File(rltvPath + "jaffaWest.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of the Replicator looking up
	Image imgReplicatorNorth = new Image(new File(rltvPath + "replNorth.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of the Replicator looking down
	Image imgReplicatorSouth = new Image(new File(rltvPath + "replSouth.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of the Replicator looking right
	Image imgReplicatorEast = new Image(new File(rltvPath + "replEast.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of the Replicator looking left
	Image imgReplicatorWest = new Image(new File(rltvPath + "replWest.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a ZPM
	Image imgZPM = new Image(new File(rltvPath + "ZPM_insize.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a blue portal
	Image imgPortalBlue = new Image(new File(rltvPath + "portalblue.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a yellow portal
	Image imgPortalYellow = new Image(new File(rltvPath + "portalyellow.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a red portal
	Image imgPortalRed = new Image(new File(rltvPath + "portalred.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a green portal
	Image imgPortalGreen = new Image(new File(rltvPath + "portalgreen.gif").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a green missile
	Image imgMissileGreen = new Image(new File(rltvPath + "fbgreen.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a red missile
	Image imgMissileRed = new Image(new File(rltvPath + "fbred.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a yellow missile
	Image imgMissileYellow = new Image(new File(rltvPath + "fbyellow.png").toURI().toString(), gridSize, gridSize, false, false);
	// Loads the image of a blue missile
	Image imgMissileBlue = new Image(new File(rltvPath + "fbblue.png").toURI().toString(), gridSize, gridSize, false, false);
	
	// Construct the view object 
	View(Level level, Player oneill, Player jaffa) {
		
		// sets the width, height
		super(gridSize * level.getWidth(), gridSize * level.getHeight());
		// sets the players, and level
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

		// O'Neills keys
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
		
		// Jaffas keys
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
		
		// Eliminates oneill or jaffa if it is necessary
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