package application;

// Class represents a wall
public class Wall extends LevelEntity implements IDrawable {

	// Show weather portal is portalable or not
    private boolean portalable;
	// References the portal on the wall
    private Portal portal;

    // Creates a wall
    public Wall(boolean b) {
		portalable = b;
    }
    
    // Closes the portal on a wall
    public void closePortal() {
    	portal = null;
    }

	@Override
	// The Player can't step on a wall
	public final boolean moveAction(Player oneill) {
		return false;
	}

	@Override
	// The replicators can't step on a wall
	public final boolean moveAction(Replicator rep) {
		return false;
	}

	@Override
	// The Player can't put a box on a wall
	public final boolean boxAction(Player oneill, Box box) {
		return false;
	}

	@Override
	// Defines what happens if a missile hits a wall
	public final boolean missileAction(Missile missile) {
		
		// if its portalable, stop the missile, and create a portal
		if(portalable) {
			portal = new Portal(missile, this);
			missile.stop();
		}
		
		// missile can't travel through walls
		return false;
	}

	// Set the wall's portalable option
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
	// ZPM can't be placed on walls
	public boolean canPutZPM() {
		return false;
	}

}