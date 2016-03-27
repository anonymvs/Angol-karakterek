package generatedFile_v1;

/**
 * 
 */
public class Wall extends LevelEntity {

    private boolean portalable;
    private Portal portal;

    /**
     * @param bool
     */
    public Wall(boolean b) {
        portalable = b;
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