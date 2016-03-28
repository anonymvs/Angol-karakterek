package generatedFile_v1;

import java.util.*;

/**
 * 
 */
public final class Door extends Placeable {

    private boolean opened = false;

    public Door() {
        System.out.println("DOOR: A Door has been constructed.");
    }

    /**
     * @param op - boolean used to open or close the door
     */
    public void open(boolean op) {
        opened = op;
        System.out.println("A Door has been opened.");
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
    	return false;
    };

    /**
     * @param on - an instance of ONeill
     */
    public final boolean moveEvent(ONeill on) {
    	return opened;
    };

}