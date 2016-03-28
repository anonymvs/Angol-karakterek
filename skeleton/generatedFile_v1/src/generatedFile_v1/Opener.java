package generatedFile_v1;

/**
 * 
 */
public final class Opener extends Placeable {

	private Box box = null;
	private Door door = null;

	public Opener() {
        System.out.println("OPENER: An Opener has been constructed.");
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
    	System.out.println("OPENER: The Openers box event has been triggered");
    	// ONeill tries to pick up a box
    	if(b == null) {
			System.out.println("OPENER: ONeill doesn't have a Box");
			if(box != null) {
				System.out.println("OPENER: ONeill takes the Openers box.");
				o.setBox(box);
				box = null;
				return true;
			} else {
				System.out.println("OPENER: Neither ONeill neither the Opener has any Box, nothing happens :(");
				return false;
			}
		}
    	
    	// ONeill tries to put down a box
    	if (box == null) {
			System.out.println("OPENER: ONeill tries to put down a Box to an Opener, that has no Box yet");
			door.open( true );
			box = b;
			return true;
		}
		System.out.println("OPENER: ONeill has a Box, the Opener also has a box, but ONeill can not put another Box on the Opener");
		return false;
    	
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