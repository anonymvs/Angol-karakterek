package default_package;

import java.io.*;
import java.util.Random;

/**
 * Created by hege on 2016.03.28..
 */
public class Main {
    private Level lvl = new Level();
    private Player oneill = new Player();
    private Player jaffa = new Player();
    private Replicator rep = new Replicator();

    public static void main(String args[]) throws IOException{
        new Main();
    }

    Main() throws IOException {
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
        if(arg.length != 1) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }

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

    public void load(String[] arg) {
        if(arg.length != 2) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }

        lvl.load(arg[1], oneill);
    }

    public void reset(String[] arg) {
        if(arg.length != 1) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }
        lvl.reset();
    }

    public void move(String[] arg) {
        if(arg.length != 3) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }
        if(arg[1].equals("-o")) {
            switch(arg[2]) {
                case "right":
                    oneill.move(Direction.Right);
                    break;
                case "left":
                    oneill.move(Direction.Left);
                    break;
                case "up":
                    oneill.move(Direction.Top);
                    break;
                case "down":
                    oneill.move(Direction.Bottom);
                    break;
            }
        }

        if(arg[1].equals("-j")) {
            switch(arg[2]) {
                case "right":
                    oneill.move(Direction.Right);
                    break;
                case "left":
                    oneill.move(Direction.Left);
                    break;
                case "up":
                    oneill.move(Direction.Top);
                    break;
                case "down":
                    oneill.move(Direction.Bottom);
                    break;
            }
        }
    }

    public void movereplicator(String[] arg) {
        if(arg.length != 1) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }

        Random rand = new Random();
        int randomNum = rand.nextInt((4 - 1) + 1) + 1;

        switch (randomNum) {
            case 1:
                rep.move(Direction.Bottom);
                break;
            case 2:
                rep.move(Direction.Left);
                break;
            case 3:
                rep.move(Direction.Right);
                break;
            case 4:
                rep.move(Direction.Top)
                break;
        }

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
