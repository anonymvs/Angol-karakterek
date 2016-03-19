package program;

import java.util.*;

/**
 * 
 */
public class Opener extends Placeable {

	/**
	 * Default constructor
	 */
	public Opener() {
	}

	/**
	 * @param Box
	 */
	public void setBox(void Box) {
		// TODO implement here
	}

	/**
	 * @param Door
	 */
	public void setDoor(void Door) {
		// TODO implement here
	}

	/**
	 * @param ONeill
	 * @param Box
	 * @return
	 */
	public abstract bool boxEvent(void ONeill, void Box);

	/**
	 * @param ONeill
	 */
	public abstract void moveEvent(void ONeill);

}