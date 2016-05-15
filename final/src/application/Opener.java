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

	// Place box on the opener
	public void setBox(Box b) {
		boxList.add(b);
		weightCount += b.getWeight();
	}

	// Set the opener's door reference
	public void setDoor(Door d) {
		door = d;
	}

	// Defines what happens, if a player wants to pick up, or drop box
	public final boolean boxEvent(Player o, Box b) {
		
		// player tries to pick up a box
		if(b == null) {
			
			// get box from the box list
			if(!boxList.isEmpty()) {
				weightCount  -=  boxList.get(boxList.size()-1).getWeight();
				o.setBox(boxList.remove(boxList.size()-1));
				if(weightCount < weightLimit){
					if(door != null) door.open(false);
				}
				return false;
			} else {
				return false;
			}
		}

		// player tries to put down a box
		else {
			boxList.add(b);
			weightCount  +=  boxList.get(boxList.size()-1).getWeight();
			if(weightCount >= weightLimit){
				if(door != null) door.open(true);
			}
			return true;
		}

	};

	// Defines what happens, if a player steps on to an opener
	public final boolean moveEvent(Player o){

		// we open it, or not
		if( o != null ){
			door.open(true);
			return true;
		} else {
			if(weightCount < weightLimit){
				door.open(false);
			}
			return false;
		}
	};

	// The Player can step on to the opener
	public final boolean moveEvent(Replicator rep) {
		return true;
	}

	// Return the number of boxes on the opener
	public int boxCount() {
		return boxList.size();
	}

	@Override
	// The Player can shoot over opener
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