package generatedFile_v1;

/**
 * 
 */
public abstract class LevelEntity {

	protected LevelEntity north = null;
    protected LevelEntity south = null;
    protected LevelEntity west = null;
    protected LevelEntity east = null;
    protected Missile missile = null;

    /**
     * @param ONeill 
     * @return
     * NAGYON OBJEKTUM ORIENTÁLT
     */
    public abstract boolean moveAction(ONeill oneill);

    /**
     * @param ONeill 
     * @param Box 
     * NAGYON OBJEKTUM ORIENTÁLT
     * @return
     */
    public abstract boolean boxAction(ONeill oneill, Box box);

    /**
     * @param Missile 
     * NAGYON OBJEKTUM ORIENTÁLT
     * @return
     */
    public abstract boolean missileAction(Missile missile);

    /**
     * @param Direction 
     * NAGYON OBJEKTUM ORIENTÁLT
     * @return
     */
    public LevelEntity getNeighbour(Direction dir) {
    	
    	switch (dir)
    	{
	    	case Right:
	    		return east;
	    	case Left:
	    		return west;
	    	case Top:
	    		return north;
	    	case Bottom:
	    		return south;
	    	default:
	    		return null;
    	}
    }

    /**
     * @param Direction 
     * @param LevelEntity
     */
    public void setNeighbour(Direction dir, LevelEntity entity) {
    	switch (dir)
    	{
	    	case Right:
	    		east = entity;
	    	case Left:
	    		west = entity;
	    	case Top:
	    		north = entity;
	    	case Bottom:
	    		south = entity;
    	}
    }

    /**
     * @param Missile
     */
    public void setMissile(Missile m) {
        missile = m;
    }

}