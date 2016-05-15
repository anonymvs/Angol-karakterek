package application;

// Class represents a box
public final class Box extends Placeable {
    // The weight of the box
	private int weight;
    // Constructor, sets the weight of the box
    public Box(int w) {
        weight = w;
    }

    // Lift a box
    public final boolean boxEvent(Player p, Box b) {
        // if there is a box, we pick it up
    	if(b == null) {
            p.setBox(this);
            return true;
        }
    	
    	// else not
        return false;
    }

    // The Player can step to any box, returns true
    public final boolean moveEvent(Player on) {
        return true;
    }

    // The Player can step on to any box, even with a replicator on it
    public final boolean moveEvent(Replicator rep) {
        return true;
    }

    // Returns the weight of the box
    public int getWeight() {
        return weight;
    }

	@Override
	// Draw a box object to the x, y coordinate
	public void draw(View view, int x, int y) {
		view.drawBox(x, y);		
	}

	@Override
    // Missiles can travel over boxes
	public boolean missileEvent() {
		return true;
	}
}