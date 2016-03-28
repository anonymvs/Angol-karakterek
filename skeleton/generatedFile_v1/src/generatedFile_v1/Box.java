package generatedFile_v1;

/**
 * 
 */
public final class Box extends Placeable {

    public Box() {
        System.out.println("BOX: A box has been constructed.");
    }

    /**
     * @param on  an instance of ONeill
     * @param b   an instance of the Box class
     * @return
     */
    public final boolean boxEvent(ONeill on, Box b) {
        System.out.println("BOX: The Box's event has been triggered");
    	if(b == null) {
            System.out.println("BOX: ONeil received the Box");
            on.setBox(this);
            return true;
        }
        System.out.println("BOX: ONeil already has a box. Can't receive another one");
    	return false;
    };

    /**
     * @param on - an instance of ONeill
     */
    public final boolean moveEvent(ONeill on) {
    	return true;
    };

}