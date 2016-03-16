
import java.util.*;

/**
 * 
 */
public class Chasm extends LevelEntity {

    /**
     * Default constructor
     */
    public Chasm() {
    }

    /**
     * @param ONeill 
     * @return
     */
    public abstract bool moveAction(void ONeill);

    /**
     * @param ONeill 
     * @param Box 
     * @return
     */
    public abstract bool boxAction(void ONeill, void Box);

    /**
     * @param Missile 
     * @return
     */
    public abstract bool missileAction(void Missile);

}