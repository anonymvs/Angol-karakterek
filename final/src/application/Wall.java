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

	@Override
	public final boolean moveAction(Player oneill) {
		//System.out.println("wall::moveAction:\t false");
		return false;
	}

	@Override
	public final boolean moveAction(Replicator rep) {
		//System.out.println("wall::moveAction:\t false");
		return false;
	}

	@Override
	public final boolean boxAction(Player oneill, Box box) {
		//System.out.println("wall::boxAction:\t false");
		return false;
	}

	@Override
	public final boolean missileAction(Missile missile) {
		
		if(portalable) {
			//System.out.println("wall::missileAction:\t Portal got into portable");
			portal = new Portal(missile, this);
			return true;
		} else {
			return false;
			//System.out.println("wall::missileAction:\t Portal got into not portable");
		}
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