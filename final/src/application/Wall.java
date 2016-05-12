package application;

/**
 * 
 */
public class Wall extends LevelEntity implements IDrawable {

    private boolean portalable;
    private Portal portal;

    /**
     * @param b
     */
    public Wall(boolean b) {

		portalable = b;

		if(b) {
			//System.out.println("WALL::Wall:\t A Wall has been constructed which is available for portals.");
		} else {
			//System.out.println("WALL::Wall:\t A Wall has been constructed which is NOT available for portals.");
		}
    }
    
    public void closePortal() {
    	portal = null;
    }

	@Override
	public final boolean moveAction(Player oneill) {
		//System.out.println("wall::moveAction:\t false");
		return false;
	}

	@Override
	public final boolean moveAction(Replicator rep) {
		return false;
	}

	@Override
	public final boolean boxAction(Player oneill, Box box) {
		return false;
	}

	@Override
	public final boolean missileAction(Missile missile) {
		
		if(portalable) {
			portal = new Portal(missile, this);
			return true;
		}
		return false;
	}

	public void setPortalable(boolean b) {
		portalable = b;
	}

	@Override
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

}