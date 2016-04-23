package generatedFile_v1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

/**
 * 
 */
public class Level {

    public List<LevelEntity> ls = new ArrayList<LevelEntity>();
    
    /**
     * Default constructor
     */
    public Level() {
        System.out.println("LEVEL::Level:\t Level contstructor been called.");
        load();
    }

    /**
     * 
     */
    private Timer timer;

    /**
     * 
     */
    private int zpmCount;


    /**
     * 
     */
    public void load() {
        System.out.println("LEVEL::load:\t Level's load function been called.");
	        
	        Floor floor = new Floor(this, false);
	        ls.add(floor);
	        Floor floorWzpm = new Floor(this, true);
	        ls.add(floorWzpm);
	        Wall wall = new Wall(false);
	        ls.add(wall);
	        Wall wallPortalable = new Wall(true);
	        ls.add(wallPortalable);
	        Chasm chasm = new Chasm();
	        ls.add(chasm);
	        Placeable box = new Box();
	        Placeable opener = new Opener();
	        Placeable door = new Door();
	        ONeill oneill = new ONeill(floor, Direction.Bottom);
	        floor.setONeill(oneill);
        
   }

    /**
     * 
     */
    public void reset() {
        // TODO implement here
        System.out.println("LEVEL::reset:\t A reset has been asked. The level is going to be reloaded.");
    }

    /**
     * 
     */
    public void decreaseZPM() {
        // TODO implement here
    	
    	if( --zpmCount == 0 ){
    		
    		System.out.println("Level::decreaseZPM:\t Collected all the ZPM-s.");
    		endOfGame();
    		
    	} else {
    		System.out.println("Level::decreaseZPM:\t ZPM decreased to " + zpmCount + ".");
    	}
    }

    /**
     * 
     */
    public void endOfGame() {
        // TODO implement here
        System.out.println("LEVEL::level:\t The end of the game has been triggered.");
        reset();
    }

}