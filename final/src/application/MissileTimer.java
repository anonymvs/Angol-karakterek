package application;


import java.util.Timer;
import java.util.TimerTask;

// Class represents missile's timer
public class MissileTimer extends java.util.Timer{
	
	// The timer, it's missile, and level
    Timer t;
    Missile m;
    Level l;
    private boolean stopped = false;

    // Construct missile timer
    public MissileTimer(Missile missile, Level level) {
    	
    	// Set variables
        t = new Timer("MissileTimer");
        m = missile;
        l = level;
        
        // The timer, it stops missile if it's needed
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
            	if(stopped) {
            		m = null;
            		return;
            	}
                if(!m.move()) {
                	this.cancel();
                }
            	l.draw();
            }
        };
        t.schedule(tt, 250, 250);
    }
    
    // Stoppes the missile
    public void stop() {
    	this.cancel();
    	stopped = true;
    }
}