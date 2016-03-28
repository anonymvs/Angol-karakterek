package generatedFile_v1;

import java.util.*;

/**
 * 
 */
public class ONeill {

    /**
     * 
     */
    private Direction dir;
    private Box box;
    private Floor floor;

    /**
     *
     * @param f
     * @param dir
     */
    public ONeill(Floor f, Direction dir) {
        System.out.printf("ONEILL: ONeill just came to life,");
        switch (dir) {
            case Left :
                System.out.printf(" and is facing to the LEFT\n");
                break;
            case Right :
                System.out.printf(" and is facing to the RIGHT\n");
                break;
            case Top :
                System.out.printf(" and is facing to the TOP\n");
                break;
            case Bottom :
                System.out.printf(" and is facing to the BOTTOM\n");
                break;
        }
        floor = f;
        this.dir = dir;
    }

    /**
     * 
     */
    public void move() {
        System.out.println("ONEILL: A movement has been triggered.");
    	LevelEntity entity = floor.getNeighbour(dir);
    	entity.moveAction(this);
        System.out.println("ONEILL: ONeill has moved.");
    }

    /**
     * 
     */
    public void boxing() {
    	LevelEntity entity = floor.getNeighbour(dir);
        entity.boxAction(this, null);
    }

    /**
     * @param b
     */
    public void setBox( Box b ) {
        box = b;
    }

    /**
     * 
     */
    public void kill() {
    	while(1 > 0)
    		System.out.println("Game Over");
    }
    
    public Floor getFloor() {
        return floor;
    }
    
    public void setFloor(Floor f) {
    	floor = f;
    }

    /**
     * 
     */
    public void shoot() {
    	
    }

    public void setDir(Direction arg) {
        dir = arg;
    }

}