package default_package;

/**
 * 
 */
public final class Floor extends LevelEntity {

	private Player oneill = null;
	private Replicator repl = null;
    private Placeable placed = null;
    private ZPM zpm = null;
	
	public Floor(Level l, boolean z) {
		if (z) {
			System.out.println("FLOOR::Floor:\t Floor with ZPM constructed.");
			zpm = new ZPM(l);
		} else {
			System.out.println("FLOOR::Floor:\t Floor without ZPM constructed");
		}
    }

    /**
     * @param o - an instance of Player, that we use to set the Floor's reference
     */
    public void setONeill(Player o) {
    	System.out.println("FLOOR::setOneill");
		if(placed != null) {
			System.out.println("FLOOR::setOneill: There is something on the floor that is being left.");
			placed.moveEvent(o);
		}
    	oneill = o;
    }

	public void setRepl(Replicator rep) {
		System.out.println("FLOOR::setOneill");
		if(placed != null) {
			System.out.println("FLOOR::setOneill: There is something on the floor that is being left.");
			placed.moveEvent(rep);
		}
		repl = rep;
	}

    /**
     * @param p - an instance of Placeable class, which can be put on the Floor
     */
    public void setPlaced(Placeable p) {
    	System.out.println("FLOOR::setPlaced");
        placed = p;
    }

    /**
     * @return
     */
    public Placeable getPlaceable() {
    	System.out.println("FLOOR::getPlaceable");
        return placed;
    }

    /**
     * @param o - an instance of Player
     * @return
     */
    public final boolean moveAction(Player o){
    	System.out.println("FLOOR::moveAction:\t This Floor's move action has been called.");
    	// If there nothing placed on the floor then Player can move here
    	if(placed == null) {
            System.out.println("FLOOR::moveAction:\t Yes, there is no object on this Floor.");
			o.getFloor().setONeill(null);
            return true;
        }
        System.out.println("FLOOR::moveAction:\t Something is on this Floor, better check that out.");
    	boolean canMove = placed.moveEvent(o);
    	
    	if(canMove)
    	{
    		System.out.println("FLOOR::moveAction:\t Player is free to move.");
            o.getFloor().setONeill(null);
    		o.setFloor(this);
    		oneill = o;
    		if(zpm != null) {
                System.out.println("FLOOR::moveAction:\t There is a ZPM on this floor, better collect it :P");
    			zpm.collect();
    		}
    	}
    	
    	return canMove;
    };

	public final boolean moveAction(Replicator rep){
		System.out.println("FLOOR::moveAction:\t This Floor's move action has been called.");
		// If there nothing placed on the floor then Player can move here
		if(placed == null) {
			System.out.println("FLOOR::moveAction:\t Yes, there is no object on this Floor.");
			rep.getFloor().setRepl(null);
			return true;
		}
		System.out.println("FLOOR::moveAction:\t Something is on this Floor, better check that out.");
		boolean canMove = placed.moveEvent(rep);

		if(canMove)
		{
			System.out.println("FLOOR::moveAction:\t Player is free to move.");
			rep.getFloor().setONeill(null);
			rep.setFloor(this);
			repl = rep;
			if(zpm != null) {
				System.out.println("FLOOR::moveAction:\t There is a ZPM on this floor, better collect it :P");
				zpm.collect();
			}
		}

		return canMove;
	};

    /**
     * @param o - an instance of Player
     * @param b - an instance of a Box
     * @return
     */
    public final boolean boxAction(Player o, Box b){
        System.out.println("FLOOR::boxAction:\t This Floor's box action has been called.");
    	
    	if(b != null) {
    		System.out.println("FLOOR::boxAction:\t ONeil is trying to drop down a box.");
    		if(placed == null)
        	{
        		System.out.println("FLOOR::boxAction: ONeil successfully put down the box.");
        		placed = b;
        		return true;
        	}
        	
        	boolean canBox = placed.boxEvent(o, b);
        	
        	return canBox;
    		
    	}
    	else {
            System.out.println("FLOOR::boxAction:\t ONeil is trying to pick up a box.");
            
            if (placed == null) {
            	System.out.println("FLOOR::boxAction:\t There is no placed object, therefore can't pick up a box.");
            	return false;
            }
            
    		boolean bool = placed.boxEvent(o, b);
            if (bool) {
                System.out.println("FLOOR::boxAction:\t The Box isn't on the Floor anymore.");
                placed = null;
            }
    		return false;
    	}    	
    };

    /**
     * @param mis - an instance of a Missile
     * @return
     */
    public final boolean missileAction( Missile mis ){
    	System.out.println("FLOOR::missileAction:\t true.");
    	return true;
    };

}