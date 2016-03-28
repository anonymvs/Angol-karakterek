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
                    Floor f1 = new Floor(level, false);
                    Floor f2 = new Floor(level, false);
                    f1.setNeighbour(Direction.Bottom, f2);
                    f2.setNeighbour(Direction.Top, f1);
                    ONeill oneill1 = new ONeill(f1, Direction.Bottom);
                    oneill1.move();
	    		case 2:
                    Floor f3 = new Floor(level, false);
                    Floor f4 = new Floor(level, false);
                    Floor f5 = new Floor(level, false);
                    Opener opener1 = new Opener();
                    ONeill oneill2 = new ONeill(f3, Direction.Bottom);
                    Box box1 = new Box();
                    f4.setPlaced(box1);
                    f5.setPlaced(opener1);
                    oneill2.boxing();
                    break;
	    		case 3:
	    			Opener op = new Opener();
	    			Door d = new Door();
	    			Box b = new Box();
	    			op.setDoor(d);
	    			op.boxEvent(null, b);
                    break;
	    		case 4:
	    			System.out.println();
                    break;
	    		case 5:
                    System.out.println();
                    break;
	    		case 6:
                    System.out.println();
                    break;
	    		case 0: System.exit(0);
                default:
                	System.out.println();
                    break;
        	}
        	
        	System.out.println();
        }
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
