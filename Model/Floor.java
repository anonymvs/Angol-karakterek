
import java.util.*;

/**
 * 
 */
public class Floor extends LevelEntity {

    /**
     * Default constructor
     */
    public Floor() {
    }

    /**
     * 
     */
    private ONeill floor;




    /**
     * @param Level
     */
    public void Floor(void Level) {
        // TODO implement here
    }

    /**
     * @param ONeill
     */
    public void setONeill(void ONeill) {
        // TODO implement here
    }

    /**
     * @param Placaeble
     */
    public void setPlaced(void Placaeble) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Placeable getPlaceable() {
        // TODO implement here
        return null;
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