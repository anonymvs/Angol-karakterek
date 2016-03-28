package generatedFile_v1;

/**
 * Created by hege on 2016.03.28..
 */
public class Main {
	
	
    public static void main(String args[]) {
    	
        Level level = new Level();
        level.load();
        
    	char o;
        System.out.println("Please select an option!");
        System.out.println("[0]: Init sequence");
        System.out.println("[1]: Move sequence");
        System.out.println("[2]: Box sequence");
        System.out.println("[3]: Door sequence");
        System.out.println("[4]: Missile sequence");
        System.out.println("[5]: Reset sequence");
        System.out.println("[6]: End of game sequence");
        System.out.println("[x]: exit");
        
        for(int i = 0; o != 'x'; i++){
        	o = (char) System.in.read();
        	switch(o){
	    		case '0': testInit();
	    		case '1': testMove();
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
