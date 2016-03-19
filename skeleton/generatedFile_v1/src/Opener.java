
import java.util.*;

/**
 * 
 */
public final class Opener extends Placeable {

	private Box box = null;
	private Door door;
    
	public void setBox(Box b) {
        box = b;
    }

    public void setDoor(Door d) {
        door = d;
    }

    /**
     * @param ONeill 
     * @param Box 
     * @return
     */
    public final boolean boxEvent(ONeill on, Box b){
    	if( box != null ){
    		door.open( true );
    		return true;
    	}
    	
    	return false;
    };

    /**
     * @param ONeill
     */
    public final void moveEvent(ONeill on){
    	if( on != null ){
    		door.open( true );
    	} else {
    		door.open( false );
    	}
    };

}