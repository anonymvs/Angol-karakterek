package application;

/**
 *
 */
public final class Door extends Placeable {

    private boolean opened;

    public Door() {
        opened = false;
    }

    /**
     * @param op - boolean used to open or close the door
     */
    public void open(boolean op) {
        opened = op;
    }

    public boolean isOpened() {
        return opened;
    }

    /**
     * @param on - an instance of Player
     * @param b - an instance of a Box
     * @return
     */
    public final boolean boxEvent(Player on, Box b) {
        return false;
    }

    /**
     * @param on - an instance of Player
     */
    public final boolean moveEvent(Player on) {
        return opened;
    }

    public final boolean moveEvent(Replicator rep) {
        return false;
    }

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		if(opened)
			System.out.print("c");
		else
			System.out.print("d");
	}

}