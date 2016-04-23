package default_package;

/**
 * 
 */
public final class Opener extends Placeable {

	private Box box = null;
	private Door door = null;

	public Opener() {
        System.out.println("OPENER::Opener:\t An Opener has been constructed.");
    }
    
	public void setBox(Box b) {
		System.out.println("OPENER::setBox");
        box = b;
    }

    public void setDoor(Door d) {
		System.out.println("OPENER::setDoor");
        door = d;
    }

    /**
     * @param o
     * @param b
     * @return
     */
    public final boolean boxEvent(Player o, Box b) {
    	System.out.println("OPENER::boxEvent:\t The Openers box event has been triggered");
    	// Player tries to pick up a box
    	if(b == null) {
			System.out.println("OPENER::boxEvent:\t Player doesn't have a Box");
			if(box != null) {
				System.out.println("OPENER::boxEvent:\t Player takes the Openers box.");
				o.setBox(box);
				box = null;
				return true;
			} else {
				System.out.println("OPENER::boxEvent:\t Neither Player neither the Opener has any Box, nothing happens :(");
				return false;
			}
		}
    	
    	// Player tries to put down a box
    	if (box == null) {
			System.out.println("OPENER::boxEvent:\t Player tries to put down a Box to an Opener, that has no Box yet, and succeeds");
			door.open( true );
			box = b;
			return true;
		}
		System.out.println("OPENER::boxEvent:\t Player has a Box, the Opener also has a box, but Player can not put another Box on the Opener");
		return false;
    	
    };

    /**
     * @param o
     */
    public final boolean moveEvent(Player o){
    	System.out.printf("OPENER::moveEvent: \t");
    	if( o != null ){
            System.out.printf("Player moved to an Opener.\n");
    		door.open(true);
        	return true;
    	} else {
            System.out.printf("Player has stepped off from an Opener\n");
    		door.open(false);
    		return false;
    	}    	
    };

}