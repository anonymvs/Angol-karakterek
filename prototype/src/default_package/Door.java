package default_package;

import java.util.*;

/**
 * 
 */
public final class Door extends Placeable {

    private boolean opened = false;

    public Door() {
        System.out.println("DOOR::Door:\t A Door has been constructed.");
    }

    /**
     * @param op - boolean used to open or close the door
     */
    public void open(boolean op) {
        opened = op;
        System.out.println("DOOR::open:\t A Door's Opener has changed to " + opened + ".");
    }
    
    public boolean isOpened() {
    	System.out.println("DOOR::isOpened:\t Check whether a door is opened.");
    	return opened;
    }

    /**
     * @param on - an instance of ONeill
     * @param b - an instance of a Box
     * @return
     */
    public final boolean boxEvent(ONeill on, Box b) {
    	System.out.println("DOOR::boxEvent:\t false");
    	return false;
    };

    /**
     * @param on - an instance of ONeill
     */
    public final boolean moveEvent(ONeill on) {
    	System.out.println("DOOR::moveEvent:\t " + opened + ".");
    	return opened;
    };

}