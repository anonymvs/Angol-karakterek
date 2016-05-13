package application;

import java.util.ArrayList;
import java.util.List;

// Class represents an opener
public final class Opener extends Placeable {

	// The opener's door, the needed weight, weight on it, and the boxes on it
	private Door door = null;
	private int weightLimit;
	private int weightCount;
	private List<Box> boxList;

	// Create an opener, set attributes
	public Opener(int l) {
		boxList = new ArrayList<Box>();
		weightLimit = 2;
		weightCount = 0;
	}

	// Put box on the opener
	public void setBox(Box b) {
		boxList.add(b);
		weightCount += b.getWeight();
	}

	// Set the opener's door
	public void setDoor(Door d) {
		door = d;
	}

	//
	public final boolean boxEvent(Player o, Box b) {
		if(b == null) {
			//System.out.println("OPENER::boxEvent:\t Player doesn't have a Box");
			if(!boxList.isEmpty()) {
				//System.out.println("OPENER::boxEvent:\t Player takes the Openers box.");
				weightCount  -=  boxList.get(boxList.size()-1).getWeight();
				o.setBox(boxList.remove(boxList.size()-1));
				if(weightCount < weightLimit){
					if(door != null) door.open(false);
				}
				return false;
			} else {
				//System.out.println("OPENER::boxEvent:\t Neither Player neither the Opener has any Box, nothing happens :(");
				return false;
			}
		}

		// Player tries to put down a box
		else {
			boxList.add(b);
			weightCount  +=  boxList.get(boxList.size()-1).getWeight();
			if(weightCount >= weightLimit){
				if(door != null) door.open(true);
			}
			//System.out.println("OPENER::boxEvent:\t Player tries to put down a Box to an Opener, that has no Box yet, and succeeds");
			return true;
		}

	};

	/**
	 * @param o
	 */
	public final boolean moveEvent(Player o){
		//System.out.printf("OPENER::moveEvent: \t");
		if( o != null ){
			//System.out.printf("Player moved to an Opener.\n");
			door.open(true);
			return true;
		} else {
			//System.out.printf("Player has stepped off from an Opener\n");
			if(weightCount < weightLimit){
				door.open(false);
			}
			return false;
		}
	};

	public final boolean moveEvent(Replicator rep) {
		return true;
	}

	public int boxCount() {
		return boxList.size();
	}

	@Override
	// We can shoot over opener
	public boolean missileEvent() {
		return true;
	}
	
	@Override
	// Draw an opener object to the x, y coordinate
	public void draw(View view, int x, int y) {
		view.drawOpener(x, y);
		view.drawBox(x, y, boxList.size());
	}

}