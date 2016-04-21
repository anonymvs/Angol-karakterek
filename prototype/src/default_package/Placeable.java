package default_package;

import java.util.*;

/**
 * 
 */
public abstract class Placeable {


    /**
     * @param o
     * @param b
     * @return
     */
    public abstract boolean boxEvent(ONeill o, Box b);

    /**
     * @param o
     */
    public abstract boolean moveEvent(ONeill o);

}