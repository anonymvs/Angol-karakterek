package application;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hege on 2016.04.23..
 */
public class Replicator implements IDrawable {
    private Level lvl;
    private Floor floor = null;
    private Direction dir;
    private Timer timer = null;

    Replicator(Level l, Floor f) {
        lvl = l;
        floor = f;
        dir = Direction.Right;
        timer = new Timer();
        
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
            	randMove();
            }
        };
        timer.schedule(tt, 1000, 1000);
    }
    
    private void randMove() {
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

    public void move(Direction dir) {
    	if(floor == null)
    		System.out.println("Null");
        LevelEntity entity = floor.getNeighbour(dir);
        this.dir = dir;
        boolean b = entity.moveAction(this);
        lvl.draw();
    }

    public void replicate(Chasm ch) {
        floor.setRepl(null);
        floor = null;
        timer.cancel();
        lvl.replicatorReplicated(ch);
        lvl.draw();
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor f) {
        floor = f;
    }    

	@Override
	public void draw(View view, int x, int y) {
		view.drawReplicator(x, y, dir);
	}	
}
