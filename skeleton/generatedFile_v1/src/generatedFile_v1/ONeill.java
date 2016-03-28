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
    public ONeill(LevelEntity f, Direction dir) {
        System.out.printf("ONeill just came to life,");
        switch (dir) {
            case Left :
                System.out.printf(" and is facing to the LEFT");
                break;
            case Right :
                System.out.printf(" and is facing to the RIGHT");
                break;
            case Top :
                System.out.printf(" and is facing to the TOP");
                break;
            case Bottom :
                System.out.printf(" and is facing to the BOTTOM");
                break;
        }
    }

    /**
     * 
     */
    public void move() {
    	LevelEntity entity = floor.getNeighbour(dir);
    	entity.moveAction(this);
        System.out.println("ONeill has moved.");
    }

    /**
     * 
     */
    public void boxing() {
    	
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

}