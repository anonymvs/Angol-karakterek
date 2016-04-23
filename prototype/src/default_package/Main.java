package default_package;

import java.io.*;
import java.util.Scanner;

/**
 * Created by hege on 2016.03.28..
 */
public class Main {

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean b = true;

        while (b){
            menu();

            String line = br.readLine();
            String[] strarray = line.split(" ");

        	switch(strarray[0]) {
	    		case "help":
                    help(strarray);
                    break;
	    		case "savetest":
                    savetest(strarray);
                    break;
	    		case "loadtest":
                    loadtest(strarray);
                    break;
	    		case "load":
                    load(strarray);
                    break;
	    		case "reset":
                    reset(strarray);
                    break;
	    		case "move":
                    move(strarray);
                    break;
                case "movereplicator":
                    movereplicator(strarray);
                    break;
                case "add":
                    add(strarray);
                    break;
                case "remove":
                    remove(strarray);
                    break;
                case "boxing":
                    boxing(strarray);
                    break;
                case "shoot":
                    shoot(strarray);
                    break;
                case "setpt":
                    setpt(strarray);
                    break;
                case "exit":
                    System.exit(0);
                    break;
                case "setreplmove":
                    setreplmove(strarray);
                    break;
                default:
                    break;
        	}
        }
    }

    public static void help(String[] arg) throws IOException{
        FileReader fr = new FileReader("help.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        System.out.println(line);

        while(line != null) {
            line = br.readLine();
            if(line != null) {
                System.out.println(line);
            }
        }
    }

    public static void savetest(String[] arg) {

    }

    public static void loadtest(String[] arg) {

    }

    public static void load(String[] arg) {

    }

    public static void reset(String[] arg) {

    }

    public static void move(String[] arg) {

    }

    public static void movereplicator(String[] arg) {

    }

    public static void add(String[] arg) {

    }

    public static void remove(String[] arg) {

    }

    public static void boxing(String[] arg) {

    }

    public static void shoot(String[] arg) {

    }

    public static void setpt(String[] arg) {

    }

    public static void setreplmove(String[] arg) {

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
