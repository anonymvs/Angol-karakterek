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
			zpm = new ZPM(l);
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
    	
    	// If there nothing placed on the floor then ONeill can here
    	if(placed == null)
    		return true;
    	
    	boolean canMove = placed.moveEvent(o);
    	
    	if(canMove)
    	{
    		o.getFloor().setONeill(null);
    		o.setFloor(this);
    		oneill = o;
    		if(zpm != null) {
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