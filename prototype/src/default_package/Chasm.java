package default_package;

/**
 * 
 */
public class Chasm extends LevelEntity {
    
	public Chasm() {

	}

	@Override
	public final boolean moveAction(Player oneill) {

		oneill.kill();
		return false;
	}

	@Override
	public final boolean moveAction(Replicator rep) {
		rep.replicate(this);
		return false;

	}

	@Override
	public final boolean boxAction(Player oneill, Box box) {

		return true;
	}

	@Override
	public final boolean missileAction(Missile m) {

		missile = m;
		return true;
	}

	public void draw() {
		System.out.print(" ");
	}
}