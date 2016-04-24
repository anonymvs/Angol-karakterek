package default_package;

import java.awt.*;
import java.io.*;
import java.util.Random;

/**
 * Created by hege on 2016.03.28..
 */
public class Main {
    private Level lvl = new Level();
    private Player oneill = new Player("oneill");
    private Player jaffa = new Player("jaffa");
    private Replicator rep = new Replicator();
    private String commands = "";
    private String[] test;

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

            commandSwitch(strarray);
        }
    }

    public void help(String[] arg) throws IOException{
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

        System.out.println();
        commands = commands.concat(arg[0]);
        commands = commands.concat("\n");
        output();
    }

    public void savetest(String[] arg) throws IOException{
        if(arg.length != 2) {
            System.out.println("\n--- Invalid input! ---\n");
            return;
        }

        PrintStream out = new PrintStream(new FileOutputStream(arg[1]));
        out.print(commands);
        output();
    }

    public void loadtest(String[] arg) {
        try {
            FileReader fr = new FileReader(arg[1]);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            String[] tmp = new String[test.length + 1];
            tmp[test.length + 1] = line;
            test = tmp;

            while (line != null) {
                line = br.readLine();
                tmp = new String[test.length + 1];
                tmp[test.length + 1] = line;
                test = tmp;
            }

            for(int i = 0; i < test.length; ++i) {
                commandSwitch(test);
            }

        } catch(IOException e) {
            System.out.println("\n --- Invalid test name --- \n");
        }


        output();
    }

    public void load(String[] arg) {
        if(arg.length != 2) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }

        lvl.load(arg[1], oneill);

        commands = commands.concat(arg[0]);
        commands = commands.concat(arg[1]);
        commands = commands.concat("\n");
        output();
    }

    public void reset(String[] arg) {
        if(arg.length != 1) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }

        lvl.reset();

        
        commands = commands.concat(arg[0]);
        commands = commands.concat("\n");
        output();
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
        commands = commands.concat(arg[0]);
        commands = commands.concat(arg[1]);
        commands = commands.concat(arg[2]);
        commands = commands.concat("\n");
        output();
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
                rep.move(Direction.Top);
                break;
        }
        commands = commands.concat(arg[0]);
        commands = commands.concat("\n");
        output();
    }

    public void add(String[] arg) {
        if(arg.length != 4) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }

        try {
            int x = Integer.parseInt(arg[2]);
            int y = Integer.parseInt(arg[3]);

            switch (arg[1]) {
                case "oneill":
                    lvl.setElement(oneill, null, null, null, x, y);
                    break;
                case "jaffa":
                    lvl.setElement(jaffa, null, null, null, x, y);
                    break;
                case "replicator":
                    lvl.setElement(null, null, rep, null, x ,y);
                    break;
                case "door":
                    Door d = new Door();
                    lvl.setElement(null, d, null, null, x, y);
                    break;
                case "opener":
                    Opener o = new Opener(2);
                    lvl.setElement(null, o, null, null, x, y);
                    break;
                case "box":
                    Box b = new Box(1);
                    lvl.setElement(null, b, null, null, x, y);
                    break;
                case "zpm":
                    ZPM zpm = new ZPM(lvl);
                    lvl.setElement(null, null, null, zpm, x ,y);
                    break;
                default:
                    System.out.println("\n --- Invalid input! ---\n");
            }
        } catch(NumberFormatException e) {
            System.out.println("\n --- Integers are required of coordiantes --- \n");
        }

        commands = commands.concat(arg[0]);
        commands = commands.concat(arg[1]);
        commands = commands.concat(arg[2]);
        commands = commands.concat(arg[3]);
        commands = commands.concat("\n");
        output();
    }

    public void remove(String[] arg) {
        if(arg.length != 4) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }

        try {
            int x = Integer.parseInt(arg[2]);
            int y = Integer.parseInt(arg[3]);

            switch (arg[1]) {
                case "oneill":
                    lvl.removeElement(oneill, null, null, null, x, y);
                    break;
                case "jaffa":
                    lvl.removeElement(jaffa, null, null, null, x, y);
                    break;
                case "replicator":
                    lvl.removeElement(null, null, rep, null, x ,y);
                    break;
                case "door":
                    Door d = new Door();
                    lvl.removeElement(null, d, null, null, x, y);
                    break;
                case "opener":
                    Opener o = new Opener(2);
                    lvl.removeElement(null, o, null, null, x, y);
                    break;
                case "box":
                    Box b = new Box(1);
                    lvl.removeElement(null, b, null, null, x, y);
                    break;
                case "zpm":
                    ZPM zpm = new ZPM(lvl);
                    lvl.removeElement(null, null, null, zpm, x ,y);
                    break;
                default:
                    System.out.println("\n --- Invalid input! ---\n");
            }
        } catch(NumberFormatException e) {
            System.out.println("\n --- Integers are required of coordinates --- \n");
        }

        commands = commands.concat(arg[0]);
        commands = commands.concat(arg[1]);
        commands = commands.concat(arg[2]);
        commands = commands.concat(arg[3]);
        commands = commands.concat("\n");
        output();
    }

    public void boxing(String[] arg) {
        if(arg.length != 2) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }
        if(arg[1].equals("-o")) oneill.boxing();
        if(arg[1].equals("-j")) jaffa.boxing();

        commands = commands.concat(arg[0]);
        commands = commands.concat(arg[1]);
        commands = commands.concat("\n");
        output();
    }

    public void shoot(String[] arg) {
        if(arg.length != 2) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }
        switch (arg[1]) {
            case "-y":
                oneill.shoot(Color.YELLOW);
                break;
            case "-b":
                oneill.shoot(Color.BLUE);
                break;
            case "-r":
                jaffa.shoot(Color.RED);
                break;
            case "-g":
                jaffa.shoot(Color.GREEN);
                break;
        }

        commands = commands.concat(arg[0]);
        commands = commands.concat(arg[1]);
        commands = commands.concat("\n");
        output();
    }

    public void setpt(String[] arg) {
        if(arg.length != 3) {
            System.out.println("\n --- Invalid input! ---\n");
            return;
        }
        try {
            int x = Integer.parseInt(arg[1]);
            int y = Integer.parseInt(arg[2]);
            lvl.setWallPortalable(x, y);
        } catch (NumberFormatException e) {
            System.out.println("\n --- Integers are required of coordinates --- \n");
        }

        commands = commands.concat(arg[0]);
        commands = commands.concat(arg[1]);
        commands = commands.concat(arg[2]);
        commands = commands.concat("\n");
        output();
    }

    public void setreplmove(String[] arg) throws UnsupportedEncodingException{

        commands = commands.concat(arg[0]);
        commands = commands.concat("\n");
        output();
    }

    public static void menu() {

    }

    public void commandSwitch(String[] strarray) throws IOException{
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

    //Function to write out what happened
    //that includes the input commands, and the map drown out
    //also we must have the missiles, boxes listed out
    public void output() {
        lvl.draw();
        System.out.println("Previous Commands:");
        System.out.println(commands);
    }
}
