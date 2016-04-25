package default_package;

/**
 * 
 */
public class Chasm extends LevelEntity {
    
	public Chasm() {
		System.out.println("CHASM::LevelEntity:\t A Chasm has been constructed.");
	}

	@Override
	public final boolean moveAction(Player oneill) {
		System.out.println("CHASM::moveAction:\t Oneill will die.");
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
		System.out.println("CHASM::boxAction:\t Box will die.");
		return true;
	}

	@Override
	public final boolean missileAction(Missile m) {
		System.out.println("CHASM::missileAction:\t Missiel is over this Chasm, nothing happens.");
		missile = m;
		return true;
	}

	public void draw() {
		System.out.print(" ");
	}
}