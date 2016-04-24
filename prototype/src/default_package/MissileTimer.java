package default_package;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hege on 2016.03.29..
 */

public class MissileTimer extends java.util.Timer{
    Timer t;
    Missile m;

    public MissileTimer(Missile missile) {
        t = new Timer("MissileTimer");
        m = missile;
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                if(!m.move()) this.cancel();
            }
        };
        t.schedule(tt, 0, 1000);
    }

}
