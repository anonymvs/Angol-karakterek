package application;

/**
 * 
 */
public class ZPM implements IDrawable {


	private Level level = null;


    /**
     * @param l
     */
    public ZPM(Level l) {
    	//System.out.println("ZPM::Zpm:\t A ZPM just occured on the map");
        level = l;
    }

    /**
     * 
     */
    public void collect() {
    	//System.out.println("ZPM::collect:\t The count of the ZPM-s on this level has been decreased.");
        level.decreaseZPM();
    }

	@Override
	public void draw(View view, int x, int y) {
		view.drawZPM(x, y);
	}

}