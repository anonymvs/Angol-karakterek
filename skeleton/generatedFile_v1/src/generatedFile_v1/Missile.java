package generatedFile_v1;

import java.awt.Color;
import java.util.Timer;



/**
 * 
 */
public class Missile {
	
    private Direction dir;
    private Timer timer;
    private Color color;
    private LevelEntity tile = null;

    public Missile(Color c, Direction d) {
        System.out.println("MISSILE::Missile:\t A Missile has been constructed.");
        dir = d;
        color = c;
        timer = new Timer();
    }

    public void move() {
    	System.out.println("MISSILE::move");
        LevelEntity entity = tile.getNeighbour(dir);
        
        if(entity.missileAction(this))
        {
        	tile.setMissile(null);
        	tile = entity;
        }
    }

    public Color getColor() {
    	System.out.println("MISSILE::getColor");
        return color;
    }
    
    public Direction getDirection() {
    	System.out.println("MISSILE::getDirection");
    	return dir;
    }

}