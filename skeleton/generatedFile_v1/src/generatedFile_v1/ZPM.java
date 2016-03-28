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
    	level = l;
    }

    /**
     * 
     */
    public void collect() {
    	level.decreaseZPM();
    }

}