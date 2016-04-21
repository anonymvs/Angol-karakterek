package default_package;

/**
 * 
 */
public final class Box extends Placeable {

    public Box() {
        System.out.println("BOX::Box:\t A box has been constructed.");
    }

    /**
     * @param on  an instance of ONeill
     * @param b   an instance of the Box class
     * @return
     */
    public final boolean boxEvent(ONeill on, Box b) {
        System.out.println("BOX::boxEvent:\t The Box's event has been triggered");
    	if(b == null) {
            System.out.println("BOX::boxEvent:\t ONeil received the Box");
            on.setBox(this);
            return true;
        }
        System.out.println("BOX::boxEvent:\t ONeil already has a box. Can't receive another one");
    	return false;
    };

    /**
     * @param on - an instance of ONeill
     */
    public final boolean moveEvent(ONeill on) {
    	System.out.println("BOX::moveEvent:\t " + true );
    	return true;
    };

}