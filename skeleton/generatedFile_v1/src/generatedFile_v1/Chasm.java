package generatedFile_v1;

/**
 * 
 */
public class Chasm extends LevelEntity {
    
	public Chasm() {
		System.out.println("CHASM: A Chasm has been constructed.");
	}

	@Override
	public final boolean moveAction(ONeill oneill) {
		oneill.kill();
		return false;
	}

	@Override
	public final boolean boxAction(ONeill oneill, Box box) {
		return true;
	}

	@Override
	public final boolean missileAction(Missile m) {
		missile = m;
		return true;
	}

}