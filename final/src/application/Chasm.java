package application;

// Class represents a chasm
public class Chasm extends LevelEntity {
    
	@Override
	// The chasm kill us, if we step on it
	public final boolean moveAction(Player oneill) {
		oneill.kill();
		return false;
	}

	@Override
	// The chasm change to a floor if replicator step on it
	public final boolean moveAction(Replicator rep) {
		rep.replicate(this);
		return false;
	}

	@Override
	// We can put box into the chasm
	public final boolean boxAction(Player oneill, Box box) {
		return true;
	}

	@Override
	// A missile can fly over a chasm
	public final boolean missileAction(Missile m) {

		missile = m;
		return true;
	}

	// Draw a chasm to the x, y coordinate
	public void draw(View view, int x, int y) {
		view.drawChasm(x, y);
		if(missile != null)
			view.drawMissile(x, y, missile.getColor());
	}
}