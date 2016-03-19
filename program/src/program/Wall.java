package program;

import java.util.*;

/**
 * 
 */
public class Wall extends LevelEntity {

	/**
	 * Default constructor
	 */
	public Wall() {
	}

	/**
	 * 
	 */
	private bool portalable;

	/**
	 * 
	 */
	private Portal wall;

	/**
	 * @param bool
	 */
	public void Wall(void bool) {
		// TODO implement here
	}

	/**
	 * @param ONeill
	 * @return
	 */
	public abstract bool moveAction(void ONeill);

	/**
	 * @param ONeill
	 * @param Box
	 * @return
	 */
	public abstract bool boxAction(void ONeill, void Box);

	/**
	 * @param Missile
	 * @return
	 */
	public abstract bool missileAction(void Missile);

}