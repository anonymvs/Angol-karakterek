package application;

//Class represents a portal
public class Portal {

	// The color of portal, direction, the wall it's on, color object to choose it
	private static Portal bluePortal = null;
    private static Portal yellowPortal = null;
    private static Portal redPortal = null;
    private static Portal greenPortal = null;
    private Direction dir;
    private Wall wall;
	private MissileColor color;

    // Create a portal
    public Portal(Missile m, Wall w) {
    	// set the wall, and direction
    	wall = w;    	
    	dir = m.getDirection().inverse();
    	
    	// close yellow portal if it is on the wall
    	if(yellowPortal != null){
        	if(m.getColor() != MissileColor.Yellow && yellowPortal.wall == wall){
        		yellowPortal.close();
        	}
        }
    	
    	// close blue portal if it is on the wall
    	if(bluePortal != null){
        	if(m.getColor() != MissileColor.Blue && bluePortal.wall == wall){
        		bluePortal.close();
        	}
    	}
        
    	// close red portal if it is on the wall
    	if(redPortal != null){
            if(m.getColor() != MissileColor.Red && redPortal.wall == wall){
            	redPortal.close();
            }
        }
         	
    	// close green portal if it is on the wall
    	if(greenPortal != null){
    		if(m.getColor() != MissileColor.Green && greenPortal.wall == wall){
    			greenPortal.close();
    		}
        }
    	
    	// open yellow portal
    	if(m.getColor() == MissileColor.Yellow) {
    		
    		// close other yellow, set yellowportal
    		if (yellowPortal != null) {
    			yellowPortal.close();
    		}
			yellowPortal = this;
			color = MissileColor.Yellow;
			
			// if there is a pair of portals, change renferences of floors
			if(bluePortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				myNeighbour.setMissileDirection(dir);
				LevelEntity blueNeighbour = bluePortal.getWallNeighbour(bluePortal.getDirection());
				blueNeighbour.setMissileDirection(bluePortal.getDirection());
				
				myNeighbour.setNeighbour(dir.inverse(), blueNeighbour);
				blueNeighbour.setNeighbour(bluePortal.getDirection().inverse(), myNeighbour);
			}
    	}
    	// open blue portal
    	if(m.getColor() == MissileColor.Blue) {
    		
    		// close other blue, set blueportal
    		if (bluePortal != null) {
    			bluePortal.close();
    		}
    		bluePortal = this;
			color = MissileColor.Blue;
    		
			// if there is a pair of portals, change renferences of floors
			if(yellowPortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				myNeighbour.setMissileDirection(dir);
				LevelEntity yellowNeighbour = yellowPortal.getWallNeighbour(yellowPortal.getDirection());
				yellowNeighbour.setMissileDirection(yellowPortal.getDirection());
				
				myNeighbour.setNeighbour(dir.inverse(), yellowNeighbour);
				yellowNeighbour.setNeighbour(yellowPortal.getDirection().inverse(), myNeighbour);
			}
    	}
		// open red portal
		if(m.getColor() == MissileColor.Red) {
			
			// close other red, set redportal
    		if (redPortal != null) {
				redPortal.close();
			}
			redPortal = this;
			color = MissileColor.Red;

			// if there is a pair of portals, change renferences of floors
			if(greenPortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				myNeighbour.setMissileDirection(dir);
				LevelEntity greenNeighbour = greenPortal.getWallNeighbour(greenPortal.getDirection());
				greenNeighbour.setMissileDirection(greenPortal.getDirection());

				myNeighbour.setNeighbour(dir.inverse(), greenNeighbour);
				greenNeighbour.setNeighbour(greenPortal.getDirection().inverse(), myNeighbour);
			}
		}
		// open green portal
		if(m.getColor() == MissileColor.Green) {
			
			// close other green, set greenportal
    		if (greenPortal != null) {
				greenPortal.close();
			}
			greenPortal = this;
			color = MissileColor.Green;

			// if there is a pair of portals, change renferences of floors
			if(redPortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				myNeighbour.setMissileDirection(dir);
				LevelEntity redNeighbour = redPortal.getWallNeighbour(redPortal.getDirection());
				redNeighbour.setMissileDirection(redPortal.getDirection());

				myNeighbour.setNeighbour(dir.inverse(), redNeighbour);
				redNeighbour.setNeighbour(redPortal.getDirection().inverse(), myNeighbour);
			}
		}
    }

    // Close portal
    public void close() {
    	LevelEntity e = wall.getNeighbour(dir);
    	e.setNeighbour(dir.inverse(), wall);
    	wall.closePortal();
    	e.setMissileDirection(null);
    }

    // Get the direction of portal
    public Direction getDirection() {
    	return dir;
    }
    
    // Get the neighbour of wall
    public LevelEntity getWallNeighbour(Direction d) {
    	return wall.getNeighbour(d);
    }

    // Get the color of portal
	public MissileColor getColor() {
		return color;
	}

}