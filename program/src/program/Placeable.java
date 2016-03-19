package program;

import java.util.*;

/**
 * 
 */
public abstract class Placeable {

	/**
	 * Default constructor
	 */
	public Placeable() {
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