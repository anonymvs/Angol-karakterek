package generatedFile_v1;

/**
 * 
 */
public final class Box extends Placeable {
    /**
     * @param ONeill 
     * @param Box 
     * @return
     */
    public final boolean boxEvent(ONeill on, Box b) {
    	if(b == null)
    		on.setBox(this);
    	return false;
    };

    /**
     * @param ONeill
     */
    public final boolean moveEvent(ONeill on) {
    	return true;
    };

}