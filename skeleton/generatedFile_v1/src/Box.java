
import java.util.*;

/**
 * 
 */
public final class Box extends Placeable {
    /**
     * @param ONeill 
     * @param Box 
     * @return
     */
    public final boolean boxEvent( ONeill on, Box b){
    	if( b != null ){
    		return false;
    	}
    	
    	return true;
    };

    /**
     * @param ONeill
     */
    public final void moveEvent( ONeill on ){};

}