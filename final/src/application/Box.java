package application;

// Class represents a box
public final class Box extends Placeable {
    // Weight of box, constructor with weight
	private int weight;
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
    };

    // We can step to any box
    public final boolean moveEvent(Player on) {
        return true;
    };

    // We can step to any box by replicator too
    public final boolean moveEvent(Replicator rep) {
        return true;
    }

    // Returns with the box weight
    public int getWeight() {
        return weight;
    }

	@Override
	// Draw a box object to the x, y coordinate
	public void draw(View view, int x, int y) {
		view.drawBox(x, y);		
	}
}