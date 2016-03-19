
import java.util.*;

/**
 * 
 */
public abstract class Placeable {

    /**
     * Default constructor
     */
    public Placeable() {
    }

    /**
     * @param ONeill 
     * @param Box 
     * @return
     */
    public abstract boolean boxEvent(ONeill o, Box b);

    /**
     * @param ONeill
     */
    public abstract void moveEvent(ONeill o);

}