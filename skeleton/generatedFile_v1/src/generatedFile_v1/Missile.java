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
    	System.out.println("MISSILE::move:\t Missile's movement has been triggered.");
        LevelEntity entity = tile.getNeighbour(dir);
        
        if(entity.missileAction(this))
        {
        	tile.setMissile(null);
        	tile = entity;
        }
    }

    public Color getColor() {
    	System.out.println("MISSILE::getColor:\t Missile's Color has been asked.");
        return color;
    }
    
    public Direction getDirection() {
    	System.out.println("MISSILE::getDirection:\t Missile's Direction has been asked.");
    	return dir;
    }

    public void setTile(LevelEntity t) {
        tile = t;
    }
}