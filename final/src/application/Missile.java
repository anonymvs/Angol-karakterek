package application;

/**
 * 
 */
public class Missile implements IDrawable {
	
    private Direction dir;
    private MissileTimer timer;
    private MissileColor color;
    private LevelEntity tile = null;

    public Missile(MissileColor c, Direction d, Level level) {
        dir = d;
        color = c;
        timer = new MissileTimer(this, level);
    }
    
    public void stop() {
    	timer.stop();
    }

    public boolean move() {
        LevelEntity entity = tile.getNeighbour(dir);

        // If it's out of the map delete the reference of the previous floor
        // Return false to stop the timer
        if(entity == null) {
        	tile.setMissile(null);
            return false;
        }

        // Move was successful
        if(entity.missileAction(this))
        {
        	tile.setMissile(null);
        	tile = entity;
        	tile.setMissile(this);
            return true;
        }
        // MissileAction returns false therefore must kill the missile
    	tile.setMissile(null);
        return false;
    }

    public MissileColor getColor() {
        return color;
    }
    
    public Direction getDirection() {
    	return dir;
    }
    
    public void setDirection(Direction d) {
    	dir = d;
    }

    public void setTile(LevelEntity t) {
        tile = t;
    }
	@Override
	public void draw(View view, int x, int y) {
		view.drawMissile(x, y, color);
	}
}