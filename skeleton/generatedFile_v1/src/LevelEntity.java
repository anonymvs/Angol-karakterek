
import java.util.*;

/**
 * 
 */
public abstract class LevelEntity {

    /**
     * Default constructor
     */
    public LevelEntity() {
    }

    /**
     * 
     */
    private LevelEntity north;

    /**
     * 
     */
    private LevelEntity south;

    /**
     * 
     */
    private LevelEntity west;

    /**
     * 
     */
    private LevelEntity east;

    /**
     * 
     */
    private Missile tile;

    /**
     * 
     */
    private Set<Level> map;

    /**
     * 
     */
    private Missile tile;

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