package application;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hege on 2016.03.29..
 */

public class MissileTimer extends java.util.Timer{
    Timer t;
    Missile m;
    Level l;

    public MissileTimer(Missile missile, Level level) {
        t = new Timer("MissileTimer");
        m = missile;
        l = level;
        
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if(!m.move()) {
                	this.cancel();
                	l.draw();
                }
            }
        };
        t.schedule(tt, 0, 1000);
    }

}