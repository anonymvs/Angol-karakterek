package generatedFile_v1;

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
    	
    	wall = w;
    	
    	dir = m.getDirection().inverz();
    	
    	// Open yellow portal
    	if(m.getColor() == Color.yellow) {
    		if (yellowPortal != null) {
    			yellowPortal.close();
    		}
			yellowPortal = this;
			
			if(bluePortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				LevelEntity blueNeighbour = bluePortal.getWallNeighbour(bluePortal.getDirection());
				
				myNeighbour.setNeighbour(dir.inverz(), blueNeighbour);
				blueNeighbour.setNeighbour(bluePortal.getDirection().inverz(), myNeighbour);
			}
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
				
				myNeighbour.setNeighbour(dir.inverz(), yellowNeighbour);
				yellowNeighbour.setNeighbour(yellowPortal.getDirection().inverz(), myNeighbour);
			}
    	}
    	
    }

    /**
     * 
     */
    public void close() {
    	    	
    	LevelEntity e = wall.getNeighbour(dir);
    	e.setNeighbour(dir.inverz(), wall);
    }

    /**
     * @return
     */
    public Direction getDirection() {
        return dir;
    }
    
    public LevelEntity getWallNeighbour(Direction d) {
    	return wall.getNeighbour(d);
    }

}