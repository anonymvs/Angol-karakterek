package default_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Timer;


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
        //load();
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
    public void load(String path, Player pl) {
        
        ArrayList<ArrayList<LevelEntity>> t = new ArrayList<ArrayList<LevelEntity>>();
        
        try{
	        BufferedReader br = new BufferedReader( new FileReader( path ) );
	        String tmp;
	        
	        int numOfLines = 0;
	        while( (tmp = br.readLine()) != null ){
    			t.add(new ArrayList<LevelEntity>());
	        	for( int i = 0; i < tmp.length(); i++ ){
	        		switch( Character.getNumericValue(tmp.charAt(i)) ){
	        		case 1:
	        			t.get(numOfLines).add( new Floor( this, false ) );
	        			break;
	        		case 2:
	        			t.get(numOfLines).add( new Wall( false ) );
	        			break;
	        		case 3:
	        			t.get(numOfLines).add( new Wall( true ) );
	        			break;
	        		case 4:
	        			t.get(numOfLines).add( new Chasm() );
	        			break;
	        		case 5:
	        			Floor f = new Floor( this, false );
	        			f.setPlaced( new Door() );
	        			t.get(numOfLines).add( f );
	        			break;
	        		}
	        	}
	        	numOfLines++;	        	
	        }
       
	        br.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
    }

    public void setElement(Player pl, Placeable entity, Replicator replicator, ZPM zpm, int x, int y) {

    }

    public void removeElement(Player pl, Placeable entity, Replicator replicator, ZPM zpm, int x, int y) {

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

    public void setWallPortalable(int x, int y) {

    }

    public void draw() {

    }
}