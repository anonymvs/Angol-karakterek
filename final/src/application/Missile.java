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

    public MissileColor getColor() {
        return color;
    }
    
    public Direction getDirection() {
    	return dir;
    }

    public void setTile(LevelEntity t) {
        tile = t;
    }

	@Override
	public void draw(View view, int x, int y) {
		view.drawMissile(x, y, color);
	}
}