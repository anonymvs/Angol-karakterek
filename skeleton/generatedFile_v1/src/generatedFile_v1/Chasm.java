package generatedFile_v1;

/**
 * 
 */
public class Chasm extends LevelEntity {
    
	public Chasm() {
		System.out.println("CHASM::LevelEntity:\t A Chasm has been constructed.");
	}

	@Override
	public final boolean moveAction(ONeill oneill) {
		System.out.println("CHASM::moveAction:\t Oneill will die.");
		oneill.kill();
		return false;
	}

	@Override
	public final boolean boxAction(ONeill oneill, Box box) {
		System.out.println("CHASM::boxAction:\t Box will die.");
		return true;
	}

	@Override
	public final boolean missileAction(Missile m) {
		System.out.println("CHASM::missileAction:\t Missiel is over this Chasm, nothing happens.");
		missile = m;
		return true;
	}

}