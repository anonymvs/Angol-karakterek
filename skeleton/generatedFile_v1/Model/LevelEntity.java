
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
     * @param ONeill 
     * @return
     */
    public abstract bool moveAction(ONeill oneill);

    /**
     * @param ONeill 
     * @param Box 
     * @return
     */
    public abstract bool boxAction(ONeill oneill, Box box);

    /**
     * @param Missile 
     * @return
     */
    public abstract bool missileAction(void Missile);

    /**
     * @param Direction 
     * @return
     */
    public LevelEntity getNeighbour(void Direction) {
        // TODO implement here
        return null;
    }

    /**
     * @param Direction 
     * @param LevelEntity
     */
    public void setNeighbour(void Direction, void LevelEntity) {
        // TODO implement here
    }

    /**
     * @param Missile
     */
    public void setMissile(void Missile) {
        // TODO implement here
    }

}