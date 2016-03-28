package generatedFile_v1;

import java.io.IOException;

/**
 * Created by hege on 2016.03.28..
 */
public class Main {

    public static void main(String args[]) {

        Level level = new Level();
        level.load();

        System.out.println("Initialization sequence is done.");

        System.out.println("Please select an option!");
        //System.out.println("[0]: Init sequence");
        System.out.println("[1]: Move sequence");
        System.out.println("[2]: Box sequence");
        System.out.println("[3]: Door sequence");
        System.out.println("[4]: Missile sequence");
        System.out.println("[5]: Reset sequence");
        System.out.println("[6]: End of game sequence");
        System.out.println("[x]: exit");

        char input = '0';

        while (input != 'x'){
            try {
                input = (char) System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        	switch(input) {
	    		case '1':
                    ONeill oneill = new ONeill(level.ls.get(0), Direction.Bottom);
	    		case '2': testBox();
	    		case '3': testDoor();
	    		case '4': testMissile();
	    		case '5': testReset();
	    		case '6': testEndOfGame();
	    		case 'x': System.exit(0);	
        	}
        }
    }
}
