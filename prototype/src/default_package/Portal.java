package default_package;

import java.awt.Color;

/**
 * 
 */
public class Portal {

    private static Portal bluePortal = null;
    private static Portal yellowPortal = null;
    private Direction dir;
    private Wall wall;

    /**
     * @param m
     * @param w
     */
    public Portal(Missile m, Wall w) {
    	System.out.println("PORTAL::Portal:\t Portal contstructor been called.");
    	wall = w;
    	
    	dir = m.getDirection().inverse();
    	
    	// Open yellow portal
    	if(m.getColor() == Color.yellow) {
    		if (yellowPortal != null) {
    			yellowPortal.close();
    		}
			yellowPortal = this;
			
			if(bluePortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				LevelEntity blueNeighbour = bluePortal.getWallNeighbour(bluePortal.getDirection());
				
				myNeighbour.setNeighbour(dir.inverse(), blueNeighbour);
				blueNeighbour.setNeighbour(bluePortal.getDirection().inverse(), myNeighbour);
			}
	    	System.out.println("PORTAL::Portal:\t Yellow portal opened.");
    	}
    	// Open blue portal
    	else {
    		if (bluePortal != null) {
    			bluePortal.close();
    		}
    		bluePortal = this;
    		
    		if(yellowPortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				LevelEntity yellowNeighbour = yellowPortal.getWallNeighbour(yellowPortal.getDirection());
				
				myNeighbour.setNeighbour(dir.inverse(), yellowNeighbour);
				yellowNeighbour.setNeighbour(yellowPortal.getDirection().inverse(), myNeighbour);
			}
        	System.out.println("PORTAL::Portal:\t Blue portal opened.");
    	}
    	
    }

    /**
     * 
     */
    public void close() {
    	LevelEntity e = wall.getNeighbour(dir);
    	e.setNeighbour(dir.inverse(), wall);
    	System.out.println("PORTAL::close:\t Portal has been closed.");
    }

    /**
     * @return
     */
    public Direction getDirection() {
    	System.out.println("PORTAL::getDirection");
    	return dir;
    }
    
    public LevelEntity getWallNeighbour(Direction d) {
    	System.out.println("PORTAL::getWallNeighbour");
    	return wall.getNeighbour(d);
    }

}