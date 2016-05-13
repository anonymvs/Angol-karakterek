package application;

// Class represents a wall
public class Wall extends LevelEntity implements IDrawable {

	// We can make portal on it, or not, and it's reference
    private boolean portalable;
    private Portal portal;

    // Creates a wall
    public Wall(boolean b) {
		portalable = b;
    }
    
    // Close the portal on a wall
    public void closePortal() {
    	portal = null;
    }

	@Override
	// We can't step on wall with player
	public final boolean moveAction(Player oneill) {
		return false;
	}

	@Override
	// We can't step on wall with replicator
	public final boolean moveAction(Replicator rep) {
		return false;
	}

	@Override
	// We can't put box to the wall
	public final boolean boxAction(Player oneill, Box box) {
		return false;
	}

	@Override
	// We do it, if a missile arrives
	public final boolean missileAction(Missile missile) {
		
		// if portalable, we create portal, and stop missile
		if(portalable) {
			portal = new Portal(missile, this);
			missile.stop();
		}
		
		// we can't shoot through wall
		return false;
	}

	// Set to wall's portalable option
	public void setPortalable(boolean b) {
		portalable = b;
	}

	@Override
	// Draw a wall object to the x, y coordinate
	public void draw(View view, int x, int y) {
		if(portal != null) {
        	view.drawPortal(x, y, portal.getColor());
        } else {
            if (portalable) {
            	view.drawPortalWall(x, y);
                return;
            } else {
            	view.drawWall(x, y);
                return;
            }
        }
	}

	@Override
	public boolean canPutZPM() {
		return false;
	}

}