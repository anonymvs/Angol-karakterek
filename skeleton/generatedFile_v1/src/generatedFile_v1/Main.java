package generatedFile_v1;

import java.io.Console;
import java.io.IOException;
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

        while (input != 0){
            menu();
            input = in.nextInt();

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
	    			missileSeq();
                    break;
	    		case 5:
                    resetSeq();
                    break;
	    		case 6:
                    endofgameSeq();
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
        f3.setNeighbour(Direction.Bottom, f4);
        f4.setNeighbour(Direction.Top, f3);
        f3.setNeighbour(Direction.Left, f5);
        f5.setNeighbour(Direction.Right, f3);
        Opener opener1 = new Opener();
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
    public static void missileSeq() {

    }
    public static void resetSeq() {

    }
    public static void endofgameSeq() {

    }

    public static void menu() {
        System.out.println("Please select an option!");
        System.out.println("[1]: Move sequence");
        System.out.println("[2]: Box sequence");
        System.out.println("[3]: Door sequence");
        System.out.println("[4]: Missile sequence");
        System.out.println("[5]: Reset sequence");
        System.out.println("[6]: End of game sequence");
        System.out.println("[0]: exit\n");
    }
}
