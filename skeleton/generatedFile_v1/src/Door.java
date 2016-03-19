
import java.util.*;

/**
 * 
 */
public final class Door extends Placeable {

    private boolean opened = false;

    /**
     * @param bool
     */
    public void open( boolean op ) {
        opened = op;
    }
    
    public boolean isOpened(){
    	return opened;
    }

    /**
     * @param ONeill 
     * @param Box 
     * @return
     */
    public final boolean boxEvent( ONeill on, Box b ){
    	return false; /* nem engedjük?*/
    };

    /**
     * @param ONeill
     */
    public final void moveEvent( ONeill on ){ };

}