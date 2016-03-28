package generatedFile_v1;

/**
 * 
 */
public final class Box extends Placeable {

    public Box() {
        System.out.println("A box has been constructed.");
    }

    /**
     * @param on  an instance of ONeill
     * @param b   an instance of the Box class
     * @return
     */
    public final boolean boxEvent(ONeill on, Box b) {
    	if(b == null)
    		on.setBox(this);
    	return false;
    };

    /**
     * @param on - an instance of ONeill
     */
    public final boolean moveEvent(ONeill on) {
    	return true;
    };

}