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
			System.out.println("WALL::Wall:\t A Wall has been constructed which is available for portals.");
		} else {
			System.out.println("WALL::Wall:\t A Wall has been constructed which is NOT available for portals.");
		}
    }

	@Override
	public final boolean moveAction(ONeill oneill) {
		System.out.println("wall::moveAction:\t false");
		return false;
	}

	@Override
	public final boolean boxAction(ONeill oneill, Box box) {
		System.out.println("wall::boxAction:\t false");
		return false;
	}

	@Override
	public final boolean missileAction(Missile missile) {
		
		if(portalable) { //portable? missileactionre? arra nincs hat�sa, nem?
			System.out.println("wall::missileAction:\t Portal got into portable");
			portal = new Portal(missile, this);
		} else {
			System.out.println("wall::missileAction:\t Portal got into not portable");
		}
		
		return true;
	}

}