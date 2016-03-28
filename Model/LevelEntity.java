
import java.util.*;

/**
 * 
 */
public abstract class LevelEntity {
    /**
     * Neighbours
     */
    private LevelEntity north;
    private LevelEntity south;
    private LevelEntity west;
    private LevelEntity east;

    /**
     * Missile reference
     */
    private Missile missile;

    /**
     * @param oneill
     * @return
     */
    public abstract boolean moveAction(ONeill oneill);

    /**
     * @param oneill
     * @param box
     * @return
     */
    public abstract boolean boxAction(ONeill oneill, Box box);

    /**
     * @param m
     * @return
     */
    public abstract boolean missileAction(Missile m);

    /**
     * @param dir
     * @return
     */
    public LevelEntity getNeighbour(Direction dir) {
        // TODO implement here
        return null;
    }

    /**
     * @param dir
     * @param le
     */
    public void setNeighbour(Direction dir, LevelEntity le) {
        // TODO implement here
    }

    /**
     * @param m
     */
    public void setMissile(Missile m) {
        // TODO implement here
    }

}