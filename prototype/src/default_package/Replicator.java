package default_package;

/**
 * Created by hege on 2016.04.23..
 */
public class Replicator {
    private Level lvl;
    private Floor floor;
    private Direction dir;

    Replicator(Level l) {
        lvl = l;
        dir = Direction.Right;
    }

    public void move(Direction dir) {
        //System.out.println("REPLICATOR::move:\t A movement has been triggered.");
        LevelEntity entity = floor.getNeighbour(dir);
        boolean b = entity.moveAction(this);
        //if(b) System.out.println("REPLICATOR::move:\t Player has moved.");
    }

    public void replicate(Chasm ch) {
        floor.setRepl(null);
        floor = null;
        lvl.replicatorReplicated(ch);

    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor f) {
        floor = f;
    }
}
