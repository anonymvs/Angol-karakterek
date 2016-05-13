package application;

// Abstract class represents things can be on the floor
public abstract class Placeable implements IDrawable {


    // Defines what we have to do, if want to put a box on it, or pick it up
    public abstract boolean boxEvent(Player o, Box b);

    // Defines what we have to do, if player want to step on it
    public abstract boolean moveEvent(Player o);

    // Defines what we have to do, if replicator want to step on it
    public abstract boolean moveEvent(Replicator rep);
    
    // Defines what we have to do, if missile want to fly over it
    public abstract boolean missileEvent();
}