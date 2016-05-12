package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public final class Opener extends Placeable {

	private Door door = null;
	private int weightLimit;
	private int weightCount;
	private List<Box> boxList;

	public Opener(int l) {
		//System.out.println("OPENER::Opener:\t An Opener has been constructed.");
		boxList = new ArrayList<Box>();
		weightLimit = l;
		weightCount = 0;
	}

	public void setBox(Box b) {
		//System.out.println("OPENER::setBox");
		boxList.add(b);
		weightCount += b.getWeight();
	}

	public void setDoor(Door d) {
		//System.out.println("OPENER::setDoor");
		door = d;
	}

	/**
	 * @param o
	 * @param b
	 * @return
	 */
	public final boolean boxEvent(Player o, Box b) {
		//System.out.println("OPENER::boxEvent:\t The Openers box event has been triggered");
		// Player tries to pick up a box
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
	public void draw(View view, int x, int y) {
		view.drawOpener(x, y);
		view.drawBox(x, y, boxList.size());
	}

}