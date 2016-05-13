package application;

// Class represents a zpm
public class ZPM implements IDrawable {
	
	// The zpm's level
	private Level level = null;


    // Create a zpm to a level
    public ZPM(Level l) {
    	//System.out.println("ZPM::Zpm:\t A ZPM just occured on the map");
        level = l;
    }

    // collect the zpm
    public void collect() {
    	//System.out.println("ZPM::collect:\t The count of the ZPM-s on this level has been decreased.");
        level.decreaseZPM();
    }

	@Override
	// Draw a zpm object to the x, y coordinate
	public void draw(View view, int x, int y) {
		view.drawZPM(x, y);
	}

}