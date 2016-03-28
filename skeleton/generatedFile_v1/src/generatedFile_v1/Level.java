package generatedFile_v1;

import java.util.*;

/**
 * 
 */
public class Level {

    public List<LevelEntity> ls = new ArrayList<LevelEntity>();

    /**
     * Default constructor
     */
    public Level() {
        System.out.println("LEVEL: Level contstructor been called.");
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
        System.out.println("LEVEL: Level's load function been called.");
        Floor floor = new Floor(this, false);
        ls.add(floor);
        Floor floorWzpm = new Floor(this, true);
        ls.add(floorWzpm);
        Wall wall = new Wall(false);
        ls.add(wall);
        Wall wallPortalable = new Wall(true);
        ls.add(wallPortalable);
        Chasm chasm = new Chasm();
        ls.add(chasm);
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