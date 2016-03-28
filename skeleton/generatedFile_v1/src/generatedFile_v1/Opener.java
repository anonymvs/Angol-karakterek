package generatedFile_v1;

/**
 * 
 */
public final class Opener extends Placeable {

	private Box box = null;
	private Door door = null;

	public Opener() {
        System.out.println("An Opener has been constructed.");
    }
    
	public void setBox(Box b) {
        box = b;
    }

    public void setDoor(Door d) {
        door = d;
    }

    /**
     * @param o
     * @param b
     * @return
     */
    public final boolean boxEvent(ONeill o, Box b) {
    	
    	// ONeill tries to pick up a box
    	if(b == null)
    		return false;
    	
    	// ONeill tries to put down a box
    	if (box != null)
        	return false;
    	
		door.open( true );
		box = b;
		return true;
    	
    };

    /**
     * @param o
     */
    public final boolean moveEvent(ONeill o){
    	if( o != null ){
    		door.open(true);
        	return true;
    	} else {
    		door.open(false);
    		return false;
    	}    	
    };

}