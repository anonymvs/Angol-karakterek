package generatedFile_v1;

/**
 * 
 */
public final class Floor extends LevelEntity {

	private ONeill oneill = null;
    private Placeable placed = null;
    private ZPM zpm = null;
	
	public Floor(Level l, boolean z) {
		if (z) {
			System.out.println("Floor with ZPM constructed.");
			zpm = new ZPM(l);
		} else {
			System.out.println("Floor without ZPM constructed");
		}
    }

    /**
     * @param o - an instance of ONeill, that we use to set the Floor's reference
     */
    public void setONeill(ONeill o) {
		oneill = o;
    }

    /**
     * @param p - an instance of Placeable class, which can be put on the Floor
     */
    public void setPlaced(Placeable p) {
        placed = p;
    }

    /**
     * @return
     */
    public Placeable getPlaceable() {
        return placed;
    }

    /**
     * @param o - an instance of ONeill
     * @return
     */
    public final boolean moveAction(ONeill o){
    	System.out.println("This Floor's move action has been called.");
    	// If there nothing placed on the floor then ONeill can move here
    	if(placed == null) {
            System.out.println("Yes, there is no object on this Floor.");
            return true;
        }
        System.out.println("Something is on this Floor, better check that out.");
    	boolean canMove = placed.moveEvent(o);
    	
    	if(canMove)
    	{
    		System.out.println("ONeill is free to move.");
            o.getFloor().setONeill(null);
    		o.setFloor(this);
    		oneill = o;
    		if(zpm != null) {
                System.out.println("There is a ZPM on this floor.");
    			zpm.collect();
    		}
    	}
    	
    	return canMove;
    };

    /**
     * @param o - an instance of ONeill
     * @param b - an instance of a Box
     * @return
     */
    public final boolean boxAction(ONeill o, Box b){
    	
    	
    	if(b != null) {
    		
    		if(placed == null)
        	{
        		placed = b;
        		return true;
        	}
        	
        	boolean canBox = placed.boxEvent(o, b);
        	
        	return canBox;
    		
    	}
    	else {
    		placed.boxEvent(o, b);
    		return false;
    	}
    	
    	
    };

    /**
     * @param mis - an instance of a Missile
     * @return
     */
    public final boolean missileAction( Missile mis ){
    	return true;
    };

}