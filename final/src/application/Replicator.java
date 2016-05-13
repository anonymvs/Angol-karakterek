package application;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

//Class represents a replicator
public class Replicator implements IDrawable {
	
	// Replicator parametes, direction, floor, level, timer
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
        
        // create timer, it will step replicator
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
    	
    	// creates a random number, and choose a direction
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

    // Replicator's move (after random direction)
    public void move(Direction dir) {
        
    	// step end redraw level
    	LevelEntity entity = floor.getNeighbour(dir);
        this.dir = dir;
        boolean b = entity.moveAction(this);
        lvl.draw();
    }

    // If replicator step into chasm create floor
    public void replicate(Chasm ch) {
        kill();
        
        // call levels function to change chasm to floor
        lvl.replicatorReplicated(ch);
        lvl.draw();
    }
    
    // Kill the replicator
    public void kill() {
    	
    	// set references null, stop timer
    	floor.setRepl(null);
    	floor = null;
    	timer.cancel();
    }

    // Return with the floor replicator stands on
    public Floor getFloor() {
        return floor;
    }

    // Set the floor replicator stands on
    public void setFloor(Floor f) {
        floor = f;
    }    

	@Override
	// Draw a replicator object to the x, y coordinate
	public void draw(View view, int x, int y) {
		view.drawReplicator(x, y, dir);
	}	
}
