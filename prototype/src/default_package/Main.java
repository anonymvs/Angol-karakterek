package default_package;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by hege on 2016.03.28..
 */
public class Main {

    public static void main(String args[]) {

        System.out.println("Initialization sequence: ");
        Level level = new Level();
        System.out.println("Initialization sequence is done.\n");

        int input = 10000;
        Scanner in = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (input != 0){
            menu();
            input = in.nextInt();
            try{
                String line = br.readLine();
            } catch(IOException e) {
                e.printStackTrace();
            }

            String[] strarray = line.split(" ");

        	switch(input) {
	    		case 1:
                    moveSeq(level);
                    break;
	    		case 2:
                    boxSeq(level);
                    break;
	    		case 3:
	    			doorSeq();
                    break;
	    		case 4:
	    			missileSeq(level);
                    break;
	    		case 5:
                    resetSeq(level);
                    break;
	    		case 6:
                    endofgameSeq(level);
                    break;
                case 7:
                    notYetHaveShownSeq(level);
                    break;
	    		case 0: System.exit(0);
                default:
                    break;
        	}

        	System.out.println();
        }
    }

    public static void moveSeq(Level level) {
        Floor f1 = new Floor(level, false);
        Floor f2 = new Floor(level, false);
        f1.setNeighbour(Direction.Bottom, f2);
        f2.setNeighbour(Direction.Top, f1);
        ONeill oneill1 = new ONeill(f1, Direction.Bottom);
        oneill1.move();
    }
    public static void boxSeq(Level level) {
        Floor f3 = new Floor(level, false);
        Floor f4 = new Floor(level, false);
        Floor f5 = new Floor(level, false);
        Door door = new Door();
        f3.setNeighbour(Direction.Bottom, f4);
        f4.setNeighbour(Direction.Top, f3);
        f3.setNeighbour(Direction.Left, f5);
        f5.setNeighbour(Direction.Right, f3);
        Opener opener1 = new Opener();
        opener1.setDoor(door);
        Box box1 = new Box();
        ONeill oneill2 = new ONeill(f3, Direction.Bottom);
        f4.setPlaced(box1);
        f5.setPlaced(opener1);
        oneill2.boxing();
        oneill2.setDir(Direction.Left);
        oneill2.boxing();
    }
    public static void doorSeq() {
        Opener op = new Opener();
        Door d = new Door();
        Box b = new Box();
        op.setDoor(d);
        op.boxEvent(null, b);
    }
    public static void missileSeq(Level level) {
        Floor f5 = new Floor(level, false);
        Floor f6 = new Floor(level, false);
        Wall wall = new Wall(true);
        f5.setNeighbour(Direction.Bottom, f6);
        f6.setNeighbour(Direction.Top, f5);
        f6.setNeighbour(Direction.Bottom, wall);
        wall.setNeighbour(Direction.Top, f6);
        ONeill oneill3 = new ONeill(f5, Direction.Bottom);
        oneill3.shoot();

    }
    public static void resetSeq(Level level) {
    	Floor f1 = new Floor(level, false);
        Chasm c = new Chasm();
        f1.setNeighbour(Direction.Bottom, c);
        c.setNeighbour(Direction.Top, f1);

        ONeill oneill1 = new ONeill(f1, Direction.Bottom);
        oneill1.move();

    }
    public static void endofgameSeq(Level level) {
        Floor f1 = new Floor(level, false);
        ONeill oneill = new ONeill(f1, Direction.Bottom);
        Timer t = new Timer(oneill);
        t.run();
    }

    private static void notYetHaveShownSeq(Level level) {
        Floor mid = new Floor(level, false);
        Floor left = new Floor(level, false);
        Floor right = new Floor(level, false);
        Wall bottom = new Wall(false);
        mid.setNeighbour(Direction.Bottom, bottom);
        mid.setNeighbour(Direction.Left, left);
        mid.setNeighbour(Direction.Right, right);
        right.setNeighbour(Direction.Left, mid);
        left.setNeighbour(Direction.Right, mid);
        ONeill oneill = new ONeill(mid, Direction.Bottom);
        Opener op = new Opener();
        Door door = new Door();
        op.setDoor(door);
        left.setPlaced(op);
        right.setPlaced(door);
        oneill.move();
        oneill.setDir(Direction.Right);
        oneill.move();
        oneill.setDir(Direction.Left);
        oneill.move();
        oneill.setDir(Direction.Right);
        oneill.move();
    }

    public static void menu() {
        System.out.println("Please select an option!");
        System.out.println("[1]: Move sequence");
        System.out.println("[2]: Box sequence");
        System.out.println("[3]: Door sequence");
        System.out.println("[4]: Missile sequence");
        System.out.println("[5]: Reset sequence");
        System.out.println("[6]: End of game sequence");
        System.out.println("[7]: Not yet have shown sequences");
        System.out.println("[0]: exit\n");
    }
}
