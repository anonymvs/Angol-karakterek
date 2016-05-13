package application;

/**
 * 
 */
public class Portal {

    private static Portal bluePortal = null;
    private static Portal yellowPortal = null;
    private static Portal redPortal = null;
    private static Portal greenPortal = null;
    private Direction dir;
    private Wall wall;
	private MissileColor color;

    /**
     * 
     */
    public Portal(Missile m, Wall w) {
    	wall = w;    	
    	dir = m.getDirection().inverse();
    	
    	// Open yellow portal
    	if(m.getColor() == MissileColor.Yellow) {
    		if (yellowPortal != null) {
    			yellowPortal.close();
    		}
			yellowPortal = this;
			color = MissileColor.Yellow;
			
			if(bluePortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				myNeighbour.setMissileDirection(dir);
				LevelEntity blueNeighbour = bluePortal.getWallNeighbour(bluePortal.getDirection());
				blueNeighbour.setMissileDirection(bluePortal.getDirection());
				
				myNeighbour.setNeighbour(dir.inverse(), blueNeighbour);
				blueNeighbour.setNeighbour(bluePortal.getDirection().inverse(), myNeighbour);
			}
    	}
    	// Open blue portal
    	if(m.getColor() == MissileColor.Blue) {
    		if (bluePortal != null) {
    			bluePortal.close();
    		}
    		bluePortal = this;
			color = MissileColor.Blue;
    		
    		if(yellowPortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				myNeighbour.setMissileDirection(dir);
				LevelEntity yellowNeighbour = yellowPortal.getWallNeighbour(yellowPortal.getDirection());
				yellowNeighbour.setMissileDirection(yellowPortal.getDirection());
				
				myNeighbour.setNeighbour(dir.inverse(), yellowNeighbour);
				yellowNeighbour.setNeighbour(yellowPortal.getDirection().inverse(), myNeighbour);
			}
    	}
		//Open red portal
		if(m.getColor() == MissileColor.Red) {
			if (redPortal != null) {
				redPortal.close();
			}
			redPortal = this;
			color = MissileColor.Red;

			if(greenPortal != null) {
				LevelEntity myNeighbour = wall.getNeighbour(dir);
				myNeighbour.setMissileDirection(dir);
				LevelEntity greenNeighbour = greenPortal.getWallNeighbour(greenPortal.getDirection());
				greenNeighbour.setMissileDirection(greenPortal.getDirection());

				myNeighbour.setNeighbour(dir.inverse(), greenNeighbour);
				greenNeighbour.setNeighbour(greenPortal.getDirection().inverse(), myNeighbour);
			}
		}
		if(m.getColor() == MissileColor.Green) {
			if (greenPortal != null) {
				greenPortal.close();
			}
			greenPortal = this;
			color = MissileColor.Green;

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

    /**
     * 
     */
    public void close() {
    	LevelEntity e = wall.getNeighbour(dir);
    	e.setNeighbour(dir.inverse(), wall);
    	wall.closePortal();
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

	public MissileColor getColor() {
		return color;
	}

}