package generatedFile_v1;

import java.util.*;

/**
 * 
 */
public class Level {

    private List<LevelEntity> ls = new ArrayList<LevelEntity>();

    /**
     * Default constructor
     */
    public Level() {
        System.out.println("Level contstructor been called.");
        load();
    }

    /**
     * 
     */
    private Timer timer;

    /**
     * 
     */
    private int zpmCount;


    /**
     *
     */
    public void Level() {
        // TODO implement here
    }

    /**
     * 
     */
    public void load() {
        System.out.println("Level's load function been called.");
        LevelEntity floor = new Floor(this, false);
        LevelEntity floorWzpm = new Floor(this, true);
        LevelEntity wall = new Wall(false);
        LevelEntity wallPortalable = new Wall(true);
        LevelEntity chasm = new Chasm();
        Placeable box = new Box();
        Placeable opener = new Opener();
        Placeable door = new Door();
        ONeill oneill = new ONeill(floor, Direction.Bottom);
    }

    /**
     * 
     */
    public void reset() {
        // TODO implement here
    }

    /**
     * 
     */
    public void decreaseZPM() {
        // TODO implement here
    }

    /**
     * 
     */
    public void endOfGame() {
        // TODO implement here
    }

}