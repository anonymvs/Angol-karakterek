package generatedFile_v1;

import java.awt.*;
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
        System.out.printf("ONEILL::ONeill:\t ONeill just came to life,");
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
        System.out.println("ONEILL::move:\t A movement has been triggered.");
    	LevelEntity entity = floor.getNeighbour(dir);
    	entity.moveAction(this);
        System.out.println("ONEILL::move:\t ONeill has moved.");
    }

    /**
     * 
     */
    public void boxing() {
    	System.out.println("ONEILL::boxing");
    	LevelEntity entity = floor.getNeighbour(dir);
        entity.boxAction(this, box);
    }

    /**
     * @param b
     */
    public void setBox( Box b ) {
    	System.out.println("ONEILL::setBox");
        box = b;
    }

    /**
     * 
     */
    public void kill() {
    	System.out.println("ONEILL::kill:\t Game Over");
    }
    
    public Floor getFloor() {
    	System.out.println("ONEILL::getFloor");
        return floor;
    }
    
    public void setFloor(Floor f) {
    	System.out.println("ONEILL::setFloor");
    	floor = f;
    }

    /**
     * 
     */
    public void shoot() {
    	System.out.println("ONEILL::shoot: \t A Missile has been shot.");
    	Missile m = new Missile(Color.BLUE, dir);
    }

    public void setDir(Direction arg) {
    	System.out.println("ONEILL::setDir: ONeill's direction has changed.");
        dir = arg;
    }

}