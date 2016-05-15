package application;

//Class represents a door
public final class Door extends Placeable {

	// The doors state (default closed)
    private boolean opened;

    public Door() {
        opened = false;
    }

    // Set the door's state
    public void open(boolean op) {
        opened = op;
    }

    // Returns the state of the door
    public boolean isOpened() {
        return opened;
    }

    // The Player can't put box on a door
    public final boolean boxEvent(Player on, Box b) {
        return false;
    }

    // If it is opened, The Player can move onto a door
    public final boolean moveEvent(Player on) {
        return opened;
    }

    // If it is opened, replicator can move onto door
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
    // If the door is opened, the missile can travel through it
	public boolean missileEvent() {
		return opened;
	}

}