package default_package;


/**
 * Created by hege on 2016.03.29..
 */

public class Timer {
    ONeill o;
    int i;

    public Timer(ONeill on) {
        i = 0;
        o = on;
    }

    public void run() {
        while (i <= 100000) {
            i++;
        }
        timeOut();
    }

    public void timeOut() {
        System.out.println("Timer::timeOut(): \t ONeill your time is up.");
        o.kill();
    }
}
