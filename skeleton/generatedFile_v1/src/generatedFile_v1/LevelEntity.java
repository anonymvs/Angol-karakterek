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
     * @param oneill - an instance of ONeill
     * @return
     */
    public abstract boolean moveAction(ONeill oneill);

    /**
     * @param oneill - an instance of ONeill
     * @param box - an instance of a Box
     * @return
     */
    public abstract boolean boxAction(ONeill oneill, Box box);

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
		System.out.println("LEVELENTITY::getNeighbour:\t This LevelEntity has been ask to return it's neighbour's reference.");
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
     * @param dir
     * @param entity
     */
    public void setNeighbour(Direction dir, LevelEntity entity) {
    	System.out.println("LEVELENTITY::setNeighbour");
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
    	System.out.println("LEVELENTITY::setMissile");
        missile = m;
    }

}