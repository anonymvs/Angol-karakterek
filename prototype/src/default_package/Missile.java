package default_package;

import java.awt.Color;
import java.util.Timer;



/**
 * 
 */
public class Missile {
	
    private Direction dir;
    private MissileTimer timer;
    private Color color;
    private LevelEntity tile = null;

    public Missile(Color c, Direction d) {
        dir = d;
        color = c;
        timer = new MissileTimer(this);
    }

    public boolean move() {
        LevelEntity entity = tile.getNeighbour(dir);

        if(entity == null) {
            return false;
        }

        if(entity.missileAction(this))
        {
        	tile.setMissile(null);
        	tile = entity;
            return true;
        }
        return true;
    }

    public Color getColor() {
        return color;
    }
    
    public Direction getDirection() {
    	return dir;
    }

    public void setTile(LevelEntity t) {
        tile = t;
    }
}