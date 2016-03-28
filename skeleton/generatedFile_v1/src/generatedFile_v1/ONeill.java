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
     */
    public void move() {
    	LevelEntity entity = floor.getNeighbour(dir);
    	entity.moveAction(this);
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