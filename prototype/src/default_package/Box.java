package default_package;

/**
 *
 */
public final class Box extends Placeable {
    private int weight;
    public Box(int w) {
        weight = w;
        System.out.println("BOX::Box:\t A box has been constructed.");
    }

    /**
     * @param on  an instance of Player
     * @param b   an instance of the Box class
     * @return
     */
    public final boolean boxEvent(Player p, Box b) {
        System.out.println("BOX::boxEvent:\t The Box's event has been triggered");
        if(b == null) {
            System.out.println("BOX::boxEvent:\t ONeil received the Box");
            p.setBox(this);
            return true;
        }
        System.out.println("BOX::boxEvent:\t ONeil already has a box. Can't receive another one");
        return false;
    };

    /**
     * @param on - an instance of Player
     */
    public final boolean moveEvent(Player on) {
        System.out.println("BOX::moveEvent:\t " + true );
        return true;
    };

    public final boolean moveEvent(Replicator rep) {
        return true;
    }

    public int getWeight() {
        return weight;
    }
}