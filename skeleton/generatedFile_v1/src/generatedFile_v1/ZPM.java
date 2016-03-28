package generatedFile_v1;

import java.util.*;

/**
 * 
 */
public class ZPM {


	private Level level = null;


    /**
     * @param l
     */
    public ZPM(Level l) {
    	System.out.println("A ZPM just occured on the map");
        level = l;
    }

    /**
     * 
     */
    public void collect() {
    	System.out.println("The count of the ZPM-s on this level has been decreased.");
        level.decreaseZPM();
    }

}