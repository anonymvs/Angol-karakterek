package application;

//Class represents a door
public final class Door extends Placeable {

	// The doors state (first closed)
    private boolean opened;

    public Door() {
        opened = false;
    }

    // Set the door's state
    public void open(boolean op) {
        opened = op;
    }

    // Return with the state of the door
    public boolean isOpened() {
        return opened;
    }

    // We can't put box on a door
    public final boolean boxEvent(Player on, Box b) {
        return false;
    }

    // If it is opened, we can move to door
    public final boolean moveEvent(Player on) {
        return opened;
    }

    // If it is opened, replicator can move to door
    public final boolean moveEvent(Replicator rep) {
        return opened;
    }

	@Override
	// Draw a door to the x, y coordinate
	public void draw(View view, int x, int y) {
		if(opened)
			view.drawDoorOpened(x, y);
		else
			view.drawDoorClosed(x, y);
	}

	@Override
	public boolean missileEvent() {
		return opened;
	}

}