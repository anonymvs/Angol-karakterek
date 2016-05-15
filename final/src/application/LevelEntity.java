package application;

// Abstract class represents one element of the level
public abstract class LevelEntity implements IDrawable {

	// Neighbour elements, missile, and it's direction
	protected LevelEntity north = null;
    protected LevelEntity south = null;
    protected LevelEntity west = null;
    protected LevelEntity east = null;
    protected Missile missile = null;
    protected Direction missileDir = null;

    // Defines what happens, if a player wants to step on to the element
    public abstract boolean moveAction(Player oneill);

    // Defines what happens, if a replicator wants to step to the element
	public abstract boolean moveAction(Replicator rep);

	// Defines what happens, if a player wants to pick up or drop box
    public abstract boolean boxAction(Player oneill, Box box);

    // Defines what happens with a missile
    public abstract boolean missileAction(Missile missile);
    
    // Determines if we can create a zpm there
    abstract public boolean canPutZPM();

    // Returns the neighbour object, in Direction dir
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
    
    // Returns the array of neighbours
	public LevelEntity[] getNeighbourArray() {
		LevelEntity[] list = new LevelEntity[4];
		list[0] = east;
		list[1] = west;
		list[2] = north;
		list[3] = south;
		return list;
	}

    // Set the elements neighbour in a direction
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

    // Set the missile of the element
    public void setMissile(Missile m) {
        missile = m;
    }
    
    // Set the missiles direction on the element
    public void setMissileDirection(Direction dir) {
    	missileDir = dir;
    }

    // Returns true if element has missile over it
	public boolean hasMissile() {
		if(missile != null) {
			return true;
		}
		return false;
	}
}