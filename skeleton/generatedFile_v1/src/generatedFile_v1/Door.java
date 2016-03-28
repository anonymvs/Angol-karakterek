package generatedFile_v1;

import java.util.*;

/**
 * 
 */
public final class Door extends Placeable {

    private boolean opened = false;

    /**
     * @param op - boolean used to open or close the door
     */
    public void open(boolean op) {
        opened = op;
    }
    
    public boolean isOpened() {
    	return opened;
    }

    /**
     * @param on - an instance of ONeill
     * @param b - an instance of a Box
     * @return
     */
    public final boolean boxEvent(ONeill on, Box b) {
    	return false; /* nem engedjük?*/
    };

    /**
     * @param on - an instance of ONeill
     */
    public final boolean moveEvent(ONeill on) {
    	return opened;
    };

}