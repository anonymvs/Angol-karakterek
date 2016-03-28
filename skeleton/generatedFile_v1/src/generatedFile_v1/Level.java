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
        ls.add(floor);
        floor.setNeighbour(Direction.Bottom, new Floor(this, false));
        LevelEntity floorWzpm = new Floor(this, true);
        ls.add(floorWzpm);
        LevelEntity wall = new Wall(false);
        ls.add(wall);
        LevelEntity wallPortalable = new Wall(true);
        ls.add(wallPortalable);
        LevelEntity chasm = new Chasm();
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