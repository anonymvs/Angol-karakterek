package application;

/**
 * 
 */
public abstract class Placeable implements IDrawable {


    /**
     * @param o
     * @param b
     * @return
     */
    public abstract boolean boxEvent(Player o, Box b);

    /**
     * @param o
     */
    public abstract boolean moveEvent(Player o);

    public abstract boolean moveEvent(Replicator rep);
    
    public abstract boolean missileEvent();
}