
import java.util.*;

/**
 * 
 */
public class Door extends Placeable {

    /**
     * Default constructor
     */
    public Door() {
    }

    /**
     * 
     */
    private bool opened;

    /**
     * @param bool
     */
    public void open(void bool) {
        // TODO implement here
    }

    /**
     * @param ONeill 
     * @param Box 
     * @return
     */
    public abstract bool boxEvent(void ONeill, void Box);

    /**
     * @param ONeill
     */
    public abstract void moveEvent(void ONeill);

}