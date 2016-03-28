package generatedFile_v1;

/**
 * 
 */
public class Wall extends LevelEntity {

    private boolean portalable;
    private Portal portal;

    /**
     * @param b
     */
    public Wall(boolean b) {

		portalable = b;

		if(b) {
			System.out.println("A Wall has been constructed which is available for portals.");
		} else {
			System.out.println("A Wall has been constructed which is NOT available for portals.");
		}
    }

	@Override
	public final boolean moveAction(ONeill oneill) {
		return false;
	}

	@Override
	public final boolean boxAction(ONeill oneill, Box box) {
		return false;
	}

	@Override
	public final boolean missileAction(Missile missile) {
		
		if(portalable) {
			portal = new Portal(missile, this);
		}
		
		return true;
	}

}