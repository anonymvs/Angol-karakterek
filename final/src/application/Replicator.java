package application;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

//Class represents a replicator
public class Replicator implements IDrawable {
	
	// Replicators parametes, direction, floor, level, timer
    private Direction dir;
    private Floor floor = null;
    private Level lvl;
    private Timer timer = null;

    // Creates a replicator
    Replicator(Level l, Floor f) {
        
    	// set attributes
    	lvl = l;
        floor = f;
        dir = Direction.Right;
        timer = new Timer();
        
        // create timer, it will move replicator
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
            	randMove();
            }
        };
        timer.schedule(tt, 1000, 1000);
    }
    
    // Replicator's random move
    private void randMove() {
    	
    	// creates a random number, and chooses a direction
        Random rand = new Random();
    	int randomNum = rand.nextInt((4 - 1) + 1) + 1;
        switch (randomNum) {
            case 1:
                move(Direction.Bottom);
                break;
            case 2:
                move(Direction.Left);
                break;
            case 3:
                move(Direction.Right);
                break;
            case 4:
                move(Direction.Top);
                break;
        }
    }

    // Replicator moves (in a random direction)
    public void move(Direction dir) {
        
    	// move, and redraw level
    	LevelEntity entity = floor.getNeighbour(dir);
        this.dir = dir;
        boolean b = entity.moveAction(this);
        lvl.draw();
    }

    // If replicator moves into a chasm, create floor in its place
    public void replicate(Chasm ch) {
        kill();
        
        // call levels function, to change chasm into a floor
        lvl.replicatorReplicated(ch);
        lvl.draw();
    }
    
    // Eliminate the replicator
    public void kill() {
    	
    	// set references to null, stop timer
    	floor.setRepl(null);
    	floor = null;
    	timer.cancel();
    }

    // Returns the floor the replicator stands on
    public Floor getFloor() {
        return floor;
    }

    // Sets the floor the replicator stands on
    public void setFloor(Floor f) {
        floor = f;
    }    

	@Override
	// Draw a replicator object to the x, y coordinate
	public void draw(View view, int x, int y) {
		view.drawReplicator(x, y, dir);
	}	
}
