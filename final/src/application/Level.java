package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



//Class represents a level
public class Level {

	// Levelentities, timer, zpm, level's  width and height, view
    public ArrayList<ArrayList<LevelEntity>> ls = new ArrayList<>();
    private Timer timer;
    private int zpmCount = 0;
    private int zpmCreaterCount = 0;
    private int width = 0; // Level width
    private int height = 0; // Level height
    private View view = null;
    private int zpmJaffa = 0;
    private int zpmONeill = 0;
    private String origiPath = null;
    private boolean timeUp = false;
    
    // Set the level's view
    public void setView(View v) {
    	view = v;
    }

	// Creates the timer, which ends the game, if it goes on too long
    private void createTimer() {
    	timer = new Timer();
    	
    	timer.schedule(new TimerTask() {
    		@Override
		    public void run() {
			    Platform.runLater(new Runnable() {
			       public void run() {
		               	timeUp = true;
		               	endOfGame();
			      }
			    });
			}
		}, 180*1000); // Timer expires after 180 seconds
    }

    // Load a level from path
    public void load(String path, Player oneill, Player jaffa) {
    	
    	origiPath = path;
    	
        try{
        	// create reader
	        BufferedReader br = new BufferedReader( new FileReader( path ) );
	        String tmp;
	        
	        // initialize
	        int numOfLines = 0;
	        int doorIndex = -1;
            boolean logic = false;
	        Door door = null;
	        
	        // read
	        while( (tmp = br.readLine()) != null ){
                if(tmp.equals("|")) logic = true;
                if(!logic) {
                    ls.add(new ArrayList<LevelEntity>());
                }
	        	if(!logic) {
                    for (int i = 0; i < tmp.length(); i++) {
	                   	switch (tmp.charAt(i)) {
	                        case 'f':
	                        	// Create floor
	                            ls.get(numOfLines).add(new Floor(this, false));
	                            break;
	                        case 'w':
	                        	// Simple wall
	                            ls.get(numOfLines).add(new Wall(false));
	                            break;
	                        case 'p':
	                        	// Create portal wall
	                            ls.get(numOfLines).add(new Wall(true));
	                            break;
	                        case 'c':
	                        	// Create chasm
	                            ls.get(numOfLines).add(new Chasm());
	                            break;
	                        case 'd':
	                        	// Create door
	                            Floor f = new Floor(this, false);
	                            Door d = new Door();
	                            door = d;
	                            f.setPlaced(d);
	                            doorIndex = i;
	                            ls.get(numOfLines).add(f);
	                            break;
	                        case 'O':
	                        	// Create O'Neill
	                            Floor f1 = new Floor(this, false);
	                            f1.setPlayer(oneill);
	                            oneill.setFloor(f1);
	                            ls.get(numOfLines).add(f1);
	                            break;
	                        case 'J':
	                        	// Create Jaffa
	                            Floor f2 = new Floor(this, false);
	                            f2.setPlayer(jaffa);
	                            jaffa.setFloor(f2);
	                            ls.get(numOfLines).add(f2);
	                            break;
	                        case 'b':
	                        	// Create box
	                            Floor f3 = new Floor(this, false);
	                            Box b = new Box(1);
	                            f3.setPlaced(b);
	                            ls.get(numOfLines).add(f3);
	                            break;
	                        case 'o':
	                        	// Create opener
	                            Floor f4 = new Floor(this, false);
	                            Opener o = new Opener(1);
	                            f4.setPlaced(o);
	                            ls.get(numOfLines).add(f4);
	                            if (doorIndex == i - 2 && door != null) {
	                                o.setDoor(door);
	                            }
	                            break;
	                        case 'z':
	                        	// Create ZPM
	                            zpmCount++;
	                            ls.get(numOfLines).add(new Floor(this, true));
	                            break;
	                    	case 'R':
	                    		// Create replicator
	                            Floor f5 = new Floor(this, false);
	                            Replicator rep = new Replicator(this, f5);
	                            f5.setRepl(rep);
	                            ls.get(numOfLines).add(f5);
	                            break;
	                   		}
                        
                    }
                } else {
                    if(!tmp.equals("|")) {
                        //the left pair of coords are for the Opener, the others in the line for the Door
                        String[] coordarray = tmp.split(" ");
                        Opener o = null;
                        Door d = null;
                        LevelEntity f1 = ls.get(Integer.parseInt(coordarray[1]) - 1).get(Integer.parseInt(coordarray[0]) - 1);
                        if(f1 instanceof Floor) {
                            Placeable op = ((Floor) f1).getPlaceable();
                            if(op instanceof Opener) {
                                o = ((Opener) op);
                            }
                        }

                        LevelEntity f2 = ls.get(Integer.parseInt(coordarray[3]) - 1).get(Integer.parseInt(coordarray[2]) - 1);
                        if(f2 instanceof Floor) {
                            Placeable doo = ((Floor) f2).getPlaceable();
                            if(doo instanceof Door) {
                                d = ((Door) doo);
                            }
                        }
                        if(o != null && d != null) {
                            o.setDoor(d);
                        }

                    }
                }
	        	numOfLines++;	        	
	        }
       
	        br.close();
	        
	        height = ls.size();
	        width = ls.get(0).size();
	        createTimer();
        } catch(Exception e){
	    	e.printStackTrace();
	    }
        
        for( int i = 0; i < ls.size(); i++ ){
        	for( int j = 0; j < ls.get(i).size(); j++){
        		
        		int ki = i;
        		int kj = j-1;
        		if( kj < 0 ){
        			ls.get(i).get(j).setNeighbour( Direction.Left, null );
        		} else {
        			ls.get(i).get(j).setNeighbour( Direction.Left, ls.get(ki).get(kj) );
        		}
        		
        		ki = i-1;
        		kj = j;
        		if( ki < 0 || kj >= ls.get(ki).size() ){
        			ls.get(i).get(j).setNeighbour( Direction.Top, null);
        		} else {
        			ls.get(i).get(j).setNeighbour( Direction.Top, ls.get(ki).get(kj) );
        		}
        		
        		ki = i;
        		kj = j+1;
        		if( kj >= ls.get(i).size() ){
        			ls.get(i).get(j).setNeighbour( Direction.Right, null);
        		} else {
        			ls.get(i).get(j).setNeighbour( Direction.Right, ls.get(ki).get(kj) );
        		}
        		
        		ki = i+1;
        		kj = j;
        		if( ki >= ls.size() || kj >= ls.get(ki).size() ){
        			ls.get(i).get(j).setNeighbour( Direction.Bottom, null);
        		} else {
        			ls.get(i).get(j).setNeighbour( Direction.Bottom, ls.get(ki).get(kj) );
        		}
        	}
        }
        
        return;
    }

	// Add an element to the level
    public void setElement(Player pl, Placeable entity, Replicator replicator, ZPM zpm, int argx, int argy) {
        int x = argx - 1;
        int y = argy - 1;
		// If there is a player on the field, and it as well
        if(pl != null) {
            Floor tmp = new Floor(this, false);
            tmp.setPlayer(pl);
            pl.setDir(Direction.Right);
            pl.setFloor(tmp);
            addToLevel(tmp, x, y);
        }
		// Add entitiy to the level
        if(entity != null) {
            Floor tmp = new Floor(this, false);
            tmp.setPlaced(entity);
            addToLevel(tmp, x, y);
        }
		// Add Replciator to the level
        if(replicator != null) {
            Floor tmp = new Floor(this, false);
            tmp.setRepl(replicator);
            replicator.setFloor(tmp);
            addToLevel(tmp, x, y);
        }

		// Place ZPM on the floor
        if(zpm != null) {
            zpmCount++;
            Floor tmp = new Floor(this, true);
            addToLevel(tmp, x, y);
        }
    }

	// Remove element from the level
    public void removeElement(Player pl, Placeable entity, Replicator replicator, ZPM zpm, int argx, int argy) {
        int x = argx - 1;
        int y = argy - 1;
		//Remove Player
        if(pl != null) {
            Floor tmp = new Floor(this, false);
            pl.setFloor(null);
            addToLevel(tmp, x, y);
        }
		// Remove entitiy
        if(entity != null) {
            Floor tmp = new Floor(this, false);
            addToLevel(tmp, x, y);
        }

		// Remove Replicator
        if(replicator != null) {
            Floor tmp = new Floor(this, false);
            replicator.setFloor(null);
            addToLevel(tmp, x, y);
        }

		// Remove ZPM
        if(zpm != null) {
            zpmCount--;
            Floor tmp = new Floor(this, false);
            addToLevel(tmp, x, y);
        }
    }

	// Add field to leve, and set is neighbours
    private void addToLevel(LevelEntity tmp, int x, int y) {
        LevelEntity[] list = ls.get(y).get(x).getNeighbourArray();
        if(list[0] != null) {
            list[0].setNeighbour(Direction.Left, tmp);
            tmp.setNeighbour(Direction.Right, list[0]);
        } else {
            tmp.setNeighbour(Direction.Right, null);
        }
        if(list[1] != null) {
            list[1].setNeighbour(Direction.Right, tmp);
            tmp.setNeighbour(Direction.Left, list[1]);
        } else {
            tmp.setNeighbour(Direction.Left, null);
        }
        if(list[2] != null) {
            list[2].setNeighbour(Direction.Bottom, tmp);
            tmp.setNeighbour(Direction.Top, list[2]);
        } else {
            tmp.setNeighbour(Direction.Top, null);
        }
        if(list[3] != null) {
            list[3].setNeighbour(Direction.Top, tmp);
            tmp.setNeighbour(Direction.Bottom, list[3]);
        } else {
            tmp.setNeighbour(Direction.Bottom, null);
        }
        ls.get(y).set(x, tmp);
    }

	// If the Replicator moves into a chasm, change it into a floor
    public void replicatorReplicated(Chasm c) {
        Floor f = new Floor(this, false);
        LevelEntity[] le = c.getNeighbourArray();

        le[0].setNeighbour(Direction.Left, f);
        f.setNeighbour(Direction.Right, le[0]);

        le[1].setNeighbour(Direction.Right, f);
        f.setNeighbour(Direction.Left, le[1]);

        le[2].setNeighbour(Direction.Bottom, f);
        f.setNeighbour(Direction.Top, le[2]);

        le[3].setNeighbour(Direction.Top, f);
        f.setNeighbour(Direction.Bottom, le[3]);
        
        // Find the chasm in the level list
        for(int i = 0; i < height; ++i) {
        	for(int j = 0; j < width; ++j) {
        		LevelEntity e = ls.get(i).get(j);
        		if(e == c) {
        			// Set the floor to be that element
        			ls.get(i).set(j, f);
        			break;
        		}
        	}
        }
    }

    // Reset the level
    public void reset() {
    	// Clear the game entity list and reload from the previous file
    	ls.clear();
    	// Create both players
    	Player oneill = new Player(PlayerType.ONeill);
        Player jaffa = new Player(PlayerType.Jaffa);
    	load(origiPath, oneill, jaffa);
    	// Set the necessary player references for the view
    	view.setONeill(oneill);
    	view.setJaffa(jaffa);
    	// Reset level properties
    	zpmCreaterCount = 0;
    	zpmCount = 0;
    	zpmONeill = 0;
    	zpmJaffa = 0;
    	timeUp = false;
    }

    // Decrease the number of zpms on level
    public void decreaseZPM(PlayerType pt) {    
    	// Create new zpm in a random place
    	if(zpmCreaterCount == 2) {
    		createRandZpm(); 
    		zpmCreaterCount = 0;
    	}
    	zpmCreaterCount++;
    	
    	// Increase the zpm count for players
    	if(pt == PlayerType.ONeill) {
    		zpmONeill++;
    	} else {
    		zpmJaffa++;
    	}
    	
    	// Decrease the remaining zpm count
    	zpmCount--;
    	if(zpmCount == 0) {
    		endOfGame();
    	}
    }
    
    // Creates random zpm
    public void createRandZpm() {
    	LevelEntity randEntity = null;
    	Random rand = new Random();
    	boolean foundFloor = false;
    	
    	while (!foundFloor) {
    		int y = rand.nextInt(ls.size());
    		int x = rand.nextInt(ls.get(y).size());
    		randEntity = ls.get(y).get(x);
    		
    		if(randEntity.canPutZPM()) {
    			Floor randFloor = (Floor)randEntity;
    			if(randFloor.getZPM() == null) {
    				randFloor.setZPM(this);
    				foundFloor = true;
    				zpmCount++;
    			}
    		}
    	}
    }

    // Defines the end of the game
    public void endOfGame() {
    	
    	if(timer != null)
    		timer.cancel();
    	
    	// Send an alert 
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Game Over");
    	alert.setHeaderText(null);
    	
    	// Determines who has won
    	String playerWin = null;
    	if(zpmONeill > zpmJaffa) {
    		playerWin = new String("O'Neill has won!");
    	} else if (zpmJaffa > zpmONeill) {
    		playerWin = new String("Jaffa has won!");
    	} else {
    		playerWin = new String("LZ has won!");
    	}
    	
    	// Determines the cause for game over
    	if(timeUp) {
        	alert.setContentText("Time is up!\n" + playerWin + "\nO'Neill ZPM Count: " + zpmONeill + "\nJaffa ZPM Count: " + zpmJaffa);
    	} else if(zpmCount == 0) {
        	alert.setContentText("All zpms have been collected!\n" + playerWin + "\nO'Neill ZPM Count: " + zpmONeill + "\nJaffa ZPM Count: " + zpmJaffa);
    	} else {
        	alert.setContentText("Both players have perished!\n" + playerWin + "\nO'Neill ZPM Count: " + zpmONeill + "\nJaffa ZPM Count: " + zpmJaffa);
    	}

    	// Show pop-up window
    	alert.showAndWait();
        reset();
    }
    
	// Draw the level
    public synchronized void draw() {
    	
    	for(int i = 0; i < height; ++i) {
    		for(int j = 0; j < width; ++j) {
    			ls.get(i).get(j).draw(view, j, i);
    		}
    	}
    }
    
    // Return with the level's width
    public int getWidth() {
    	return width;
    }
    
    // Return with the level's height
    public int getHeight() {
    	return height;
    }
}