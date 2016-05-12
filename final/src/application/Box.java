package application;

/**
 *
 */
public final class Box extends Placeable {
    private int weight;
    public Box(int w) {
        weight = w;
    }

    /**
     * @param on  an instance of Player
     * @param b   an instance of the Box class
     * @return
     */
    public final boolean boxEvent(Player p, Box b) {
        if(b == null) {
            p.setBox(this);
            return true;
        }
        return false;
    };

    /**
     * @param on - an instance of Player
     */
    public final boolean moveEvent(Player on) {
        return true;
    };

    public final boolean moveEvent(Replicator rep) {
        return true;
    }

    public int getWeight() {
        return weight;
    }

	@Override
	public void draw(View view, int x, int y) {
		view.drawBox(x, y);		
	}
}