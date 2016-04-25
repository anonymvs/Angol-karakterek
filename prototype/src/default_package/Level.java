package default_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Timer;

import default_package.*;


/**
 * 
 */
public class Level {

    public ArrayList<ArrayList<LevelEntity>> ls = new ArrayList<>();
    private Timer timer;
    private int zpmCount = 0;
    private int zpmCreaterCount = 0;
    
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
    public void load(String path, Player p1, Player p2) {
        
        try{
	        BufferedReader br = new BufferedReader( new FileReader( path ) );
	        String tmp;
	        
	        int numOfLines = 0;
	        int doorIndex = -1;
	        Door door = null;
	        
	        while( (tmp = br.readLine()) != null ){
    			ls.add(new ArrayList<LevelEntity>());
	        	for( int i = 0; i < tmp.length(); i++ ){
	        		switch( Character.getNumericValue(tmp.charAt(i)) ){
	        		case 1:
	        			ls.get(numOfLines).add( new Floor( this, false ) );
	        			break;
	        		case 2:
	        			ls.get(numOfLines).add( new Wall( false ) );
	        			break;
	        		case 3:
	        			ls.get(numOfLines).add( new Wall( true ) );
	        			break;
	        		case 4:
	        			ls.get(numOfLines).add( new Chasm() );
	        			break;
	        		case 5:
	        			Floor f = new Floor( this, false );
	        			Door d = new Door();
	        			door = d;
	        			f.setPlaced( d );
	        			doorIndex = i;
	        			ls.get(numOfLines).add( f );
	        			break;
	        		case 6:
	        			Floor f1 = new Floor(this, false);
	        			f1.setONeill( p1 );
	        			p1.setFloor(f1);
	        			ls.get(numOfLines).add( f1 );
	        			break;
	        		case 7:
	        			Floor f2 = new Floor(this, false);
	        			f2.setONeill( p2 );
	        			p2.setFloor(f2);
	        			ls.get(numOfLines).add( f2 );
	        			break;
	        		case 8:
	        			Floor f3 = new Floor(this, false);
	        			Box b = new Box(1);
	        			f3.setPlaced(b);
	        			ls.get(numOfLines).add( f3 );
	        			break;
	        		case 9:
	        			ls.get(numOfLines).add( new Chasm() );
	        			break;
	        		case 0:
	        			Floor f4 = new Floor(this, false);
	        			Opener o = new Opener(1);
	        			f4.setPlaced(o);
	        			ls.get(numOfLines).add( f4 );
	        			
	        			if(doorIndex == i - 2 && door != null) {
	        				o.setDoor(door);
	        			}
	        			break;
	        		}
	        	}
	        	numOfLines++;	        	
	        }
       
	        br.close();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
        
        for( int i = 0; i < ls.size(); i++ ){
        	for( int j = 0; j < ls.get(i).size(); j++){
        		
        		int ki = i;
        		int kj = j-1;
        		if( kj < 0 ){
        			ls.get(i).get(j).setNeighbour( Direction.Left, null );
        		} else {
        			ls.get(i).get(j).setNeighbour( Direction.Left, ls.get(ki).get(kj) );
        		}
        		
        		ki = i-1;
        		kj = j;
        		if( ki < 0 || kj >= ls.get(ki).size() ){
        			ls.get(i).get(j).setNeighbour( Direction.Top, null);
        		} else {
        			ls.get(i).get(j).setNeighbour( Direction.Top, ls.get(ki).get(kj) );
        		}
        		
        		ki = i;
        		kj = j+1;
        		if( kj >= ls.get(i).size() ){
        			ls.get(i).get(j).setNeighbour( Direction.Right, null);
        		} else {
        			ls.get(i).get(j).setNeighbour( Direction.Right, ls.get(ki).get(kj) );
        		}
        		
        		ki = i+1;
        		kj = j;
        		if( ki >= ls.size() || kj >= ls.get(ki).size() ){
        			ls.get(i).get(j).setNeighbour( Direction.Bottom, null);
        		} else {
        			ls.get(i).get(j).setNeighbour( Direction.Bottom, ls.get(ki).get(kj) );
        		}
        	}
        }
        
        // Setting Opener and Doors
        
        
        return;
    }

    public void setElement(Player pl, Placeable entity, Replicator replicator, ZPM zpm, int argx, int argy) {
        int x = argx - 1;
        int y = argy - 1;
        if(pl != null) {
            Floor tmp = new Floor(this, false);
            tmp.setONeill(pl);
            pl.setDir(Direction.Right);
            pl.setFloor(tmp);
            addToLevel(tmp, x, y);
        }
        if(entity != null) {
            Floor tmp = new Floor(this, false);
            tmp.setPlaced(entity);
            addToLevel(tmp, x, y);
        }
        if(replicator != null) {
            Floor tmp = new Floor(this, false);
            tmp.setRepl(replicator);
            replicator.setFloor(tmp);
            addToLevel(tmp, x, y);
        }
        if(zpm != null) {
            Floor tmp = new Floor(this, true);
            addToLevel(tmp, x, y);
        }
    }

    public void removeElement(Player pl, Placeable entity, Replicator replicator, ZPM zpm, int argx, int argy) {
        int x = argx - 1;
        int y = argy - 1;
        if(pl != null) {
            Floor tmp = new Floor(this, false);
            pl.setFloor(null);
            addToLevel(tmp, x, y);
        }
        if(entity != null) {
            Floor tmp = new Floor(this, false);
            addToLevel(tmp, x, y);
        }
        if(replicator != null) {
            Floor tmp = new Floor(this, false);
            replicator.setFloor(null);
            addToLevel(tmp, x, y);
        }
        if(zpm != null) {
            Floor tmp = new Floor(this, false);
            addToLevel(tmp, x, y);
        }
    }

    private void addToLevel(LevelEntity tmp, int x, int y) {
        LevelEntity[] list = ls.get(y).get(x).getNeighbourArray();
        if(list[0] != null) {
            list[0].setNeighbour(Direction.Left, tmp);
            tmp.setNeighbour(Direction.Right, list[0]);
        } else {
            tmp.setNeighbour(Direction.Right, null);
        }
        if(list[1] != null) {
            list[1].setNeighbour(Direction.Right, tmp);
            tmp.setNeighbour(Direction.Left, list[1]);
        } else {
            tmp.setNeighbour(Direction.Left, null);
        }
        if(list[2] != null) {
            list[2].setNeighbour(Direction.Bottom, tmp);
            tmp.setNeighbour(Direction.Top, list[2]);
        } else {
            tmp.setNeighbour(Direction.Top, null);
        }
        if(list[3] != null) {
            list[3].setNeighbour(Direction.Top, tmp);
            tmp.setNeighbour(Direction.Bottom, list[3]);
        } else {
            tmp.setNeighbour(Direction.Bottom, null);
        }
        ls.get(y).set(x, tmp);
    }

    public void replicatorReplicated(Chasm c) {
        Floor f = new Floor(this, false);
        LevelEntity[] le = c.getNeighbourArray();

        le[0].setNeighbour(Direction.Left, f);
        f.setNeighbour(Direction.Right, le[0]);

        le[1].setNeighbour(Direction.Right, f);
        f.setNeighbour(Direction.Left, le[1]);

        le[2].setNeighbour(Direction.Bottom, f);
        f.setNeighbour(Direction.Top, le[2]);

        le[3].setNeighbour(Direction.Top, f);
        f.setNeighbour(Direction.Bottom, le[3]);
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
    	if(zpmCount == 0 ){    		
    		System.out.println("Collected all the ZPMs.");
    		endOfGame();    		
    	}
    	
    	if(zpmCreaterCount == 2) {
    		createRandZpm(); 
    		zpmCreaterCount = 0;
    	}
    	zpmCreaterCount++;
    }
    
    public void createRandZpm() {
    	LevelEntity randEntity = null;
    	Random rand = new Random();
    	boolean foundFloor = false;
    	
    	while (!foundFloor) {
    		int y = rand.nextInt(ls.size());
    		int x = rand.nextInt(ls.get(y).size());
    		randEntity = ls.get(y).get(x);
    		
    		if(randEntity instanceof Floor) {
    			Floor randFloor = (Floor)randEntity;
    			if(randFloor.getZPM() != null) {
    				randFloor.setZPM(this);
    				foundFloor = true;
    				zpmCount++;
    			}
    		}
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

    public void setWallPortalable(int argx, int argy) {
        int x = argx - 1;
        int y = argy - 1;
        if(ls.get(y).get(x).getClass().getSimpleName().equals("Wall")){
            Wall tmp = new Wall(true);
            addToLevel(tmp, x, y);
        }
    }

    public void draw() {
        /*
        for(int i = 0; i < ls.size(); ++i) {
            for(int j = 0; j < ls.get(i).size(); ++j) {
                ls.get(i).get(j).draw();
            }
            System.out.print("\n");
        }
        */
        for(int i = 0; i < ls.size(); ++i) {
            recursiveDraw(ls.get(i).get(0));
        }
    }

    private void recursiveDraw(LevelEntity le) {
        if(le == null) {
            System.out.print("\n");
            return;
        }
        le.draw();
        recursiveDraw(le.getNeighbour(Direction.Right));

    }

    public String generateLists() {
        String boxes = "";
        String missiles = "";
        for(int i = 0; i < ls.size(); ++i) {
            for(int j = 0; j < ls.get(i).size(); ++j) {
                if(ls.get(i).get(j) instanceof Floor) {
                    Floor f = (Floor) ls.get(i).get(j);
                    if(f.hasBox()) {
                        boxes = boxes + "(" + Integer.toString(j + 1) + ", " + Integer.toString(i + 1) + "), ";
                    }
                }
                if(ls.get(i).get(j).hasMissile()) {
                    missiles = missiles + "(" + Integer.toString(j + 1) + ", " + Integer.toString(i + 1) + "), ";
                }
            }
        }
        String ret = "Boxes: " + boxes + "\nMissiles: " + missiles + "\n";
        return ret;
    }
}