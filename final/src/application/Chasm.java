package application;

// Class represents a chasm
public class Chasm extends LevelEntity {
    
	@Override
	// The Player is eliminated, if he steps on a chasm
	public final boolean moveAction(Player oneill) {
		oneill.kill();
		return false;
	}

	@Override
	// The chasm changes into a floor, if the replicator steps on it
	public final boolean moveAction(Replicator rep) {
		rep.replicate(this);
		return false;
	}

	@Override
	// The Player can put a box into a chasm
	public final boolean boxAction(Player oneill, Box box) {
		return true;
	}

	@Override
	// A missile can fly over a chasm
	public final boolean missileAction(Missile m) {

		missile = m;
		return true;
	}

	// Draws a chasm to the x, y coordinate
	public void draw(View view, int x, int y) {
		view.drawChasm(x, y);
		// If there is a missile above the chasm, draw it as well
		if(missile != null)
			view.drawMissile(x, y, missile.getColor());
	}

	@Override
	// ZPM can not be placed on Floor the contains a box
	public boolean canPutZPM() {
		return false;
	}
}