package application;

// Class represents a missile
public class Missile implements IDrawable {
	
	// Missile's direction, timer, color, tile
    private Direction dir;
    private MissileTimer timer;
    private MissileColor color;
    private LevelEntity tile = null;
    private boolean tping = false;

    // Create a missile, with its own timer
    public Missile(MissileColor c, Direction d, Level level) {
        dir = d;
        color = c;
        timer = new MissileTimer(this, level);
    }
    
    // Stop the missile
    public void stop() {
    	timer.stop();
    }
    
    // Return true if teleporting
    public boolean isTeleporting() {
    	return tping;
    }
    
    // Set teleporting
    public void setTeleporting(boolean t) {
    	tping = t;
    }

    // Move missile
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

    // Get missile's color
    public MissileColor getColor() {
        return color;
    }
    
    // Get missile's direction
    public Direction getDirection() {
    	return dir;
    }
    
    // Set missile's direction
    public void setDirection(Direction d) {
    	dir = d;
    }

    // Set missile's tile
    public void setTile(LevelEntity t) {
        tile = t;
    }
    
	@Override
	// Draw a missile object to the x, y coordinate
	public void draw(View view, int x, int y) {
		view.drawMissile(x, y, color);
	}
}