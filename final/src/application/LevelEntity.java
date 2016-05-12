package application;

/**
 * 
 */
public abstract class LevelEntity implements IDrawable {

	protected LevelEntity north = null;
    protected LevelEntity south = null;
    protected LevelEntity west = null;
    protected LevelEntity east = null;
    protected Missile missile = null;

    /**
     * @param oneill - an instance of Player
     * @return
     */
    public abstract boolean moveAction(Player oneill);

	/**
	 * @param rep - an instance of Replicator
	 * @return
	 */
	public abstract boolean moveAction(Replicator rep);

    /**
     * @param oneill - an instance of Player
     * @param box - an instance of a Box
     * @return
     */
    public abstract boolean boxAction(Player oneill, Box box);

    /**
     * @param missile - an instance of a Missile
     * @return
     */
    public abstract boolean missileAction(Missile missile);

    /**
     * @param dir - an instance of a Direction
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

	public LevelEntity[] getNeighbourArray() {
		LevelEntity[] list = new LevelEntity[4];
		list[0] = east;
		list[1] = west;
		list[2] = north;
		list[3] = south;
		return list;
	}

    /**
     * @param dir
     * @param entity
     */
    public void setNeighbour(Direction dir, LevelEntity entity) {
    	switch (dir)
    	{
	    	case Right:
	    		east = entity;
	    		break;
	    	case Left:
	    		west = entity;
	    		break;
	    	case Top:
	    		north = entity;
	    		break;
	    	case Bottom:
	    		south = entity;
	    		break;
    	}
    }

    /**
     * @param m
     */
    public void setMissile(Missile m) {
        missile = m;
    }

	public boolean hasMissile() {
		if(missile != null) {
			return true;
		}
		return false;
	}
}