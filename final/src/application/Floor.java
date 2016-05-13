package application;

//Class represents a floor
public final class Floor extends LevelEntity {

	// The possible objects in the floor
	private Player player = null;
	private Replicator repl = null;
    private Placeable placed = null;
    private ZPM zpm = null;
	
	// Create a floor to a level, and set it's zpm
    public Floor(Level l, boolean z) {
		if(z) {
			zpm = new ZPM(l);
		}
    }

    // Set the zpm on the floor
	public void setZPM(Level lvl) {
		zpm = new ZPM(lvl);
	}

    // Get if there is a zpm on the floor
	public ZPM getZPM() {
		return zpm;
	}

    // Set the floor's player to the parameter
    public void setPlayer(Player o) {
		// If there is something on the floor, we call it's moveEvent
    	if(placed != null) {
			placed.moveEvent(o);
		}
    	player = o;
    }

	// Set the floor's replicator to the parameter
	public void setRepl(Replicator rep) {
		// If there is something on the floor, we call it's moveEvent
		if(placed != null) {
			placed.moveEvent(rep);
		}
		repl = rep;
	}

    // Set the placeable element on the floor
    public void setPlaced(Placeable p) {
        placed = p;
    }

    // Get the placeable element which is on the floor
    public Placeable getPlaceable() {
        return placed;
    }

    // Defines what we have to do, if player wants to step on a floor
    public final boolean moveAction(Player o){

    	// if someone on the floor, we can't step here
    	if(player != null){
    		return false;
    	}
    	
    	// if there nothing placed on the floor then Player can move here
    	if(placed == null) {
			setPlayer(o);
            o.getFloor().setPlayer(null);
            
            // if there is zpm on the floor, we collect it
            if(zpm != null) {
                zpm.collect();
                zpm = null;
            }
            
            return true;
        }
 
    	// we ask the placed object that we can step here or not
    	boolean canMove = placed.moveEvent(o);
 
    	// if we can move then Player move here
    	if(canMove)
    	{
            o.getFloor().setPlayer(null);
    		o.setFloor(this);
    		player = o;
    		
    		// if there is zpm on the floor, we collect it
    		if(zpm != null) {
    			zpm.collect();
                zpm = null;
    		}
    	}

    	
    	return canMove;
    };

    // Defines what we have to do, if replicator wants to step on a floor
    public final boolean moveAction(Replicator rep){
		
    	// if there nothing placed on the floor then Player can move here
		if(placed == null) {
			rep.getFloor().setRepl(null);
            rep.setFloor(this);
            repl = rep;
            
            // if replicator moved into a missile kill him
            if(missile != null) {
            	repl.kill();
            	missile.stop();
            	missile = null;
            }
            
			return true;
		}
		
		// we ask the placed object that we can step here or not
    	boolean canMove = placed.moveEvent(rep);
    	// we can step only if there are no player
        if(player != null) {
            return false;
        }
        
        // if replicator can move it moves here
    	if(canMove)
		{
			//repl is free to move;
			rep.getFloor().setRepl(null);
			rep.setFloor(this);
			repl = rep;
			
			// if replicator moved into a missile kill him
            if(missile != null) {
            	repl.kill();
            	missile.stop();
            	missile = null;
            }
		}

		return canMove;
	}

    public final boolean boxAction(Player o, Box b){
        //System.out.println("FLOOR::boxAction:\t This Floor's box action has been called.");
    	
    	if(b != null) {
    		//System.out.println("FLOOR::boxAction:\t ONeil is trying to drop down a box.");
    		if(placed == null)
        	{
        		//System.out.println("FLOOR::boxAction: ONeil successfully put down the box.");
        		placed = b;
        		return true;
        	}
        	
        	boolean canBox = placed.boxEvent(o, b);
        	
        	return canBox;
    		
    	}
    	else {
            //System.out.println("FLOOR::boxAction:\t ONeil is trying to pick up a box.");            
            if (placed == null) {
            	//System.out.println("FLOOR::boxAction:\t There is no placed object, therefore can't pick up a box.");
            	return false;
            }
            
    		boolean bool = placed.boxEvent(o, b);
            if (bool) {
                //System.out.println("FLOOR::boxAction:\t The Box isn't on the Floor anymore.");
                placed = null;
            }
    		return false;
    	}    	
    }

    // Defines what we have to do, if missile wants to fly over a floor
    public final boolean missileAction(Missile mis) {
    	// Missile hits replicator and it dies
    	if(repl != null) {
    		repl.kill();
    		return false;
    	}
    	
    	// Change the direction of the missile if it's near a portal
    	if(missileDir != null) {
    		if(mis.isTeleporting()) {
    			mis.setDirection(missileDir);
    			mis.setTeleporting(false);
    		}
    		else
    			mis.setTeleporting(true);
    	}
    	
    	if(placed == null)
    		return true;
    	return placed.missileEvent();
    }

    // Return that we have box on the floor or not
    public boolean hasBox() {
        if(placed != null) {
            if (placed.getClass().getSimpleName().equals("Box")) return true;
        }
        return false;
    }

    public final void draw(View view, int x, int y) {
		// First draw simple floor
    	view.drawFloor(x, y);
    	
    	// Secondly draw ZPM (everything else hides it)
    	if(zpm != null) {
    		zpm.draw(view, x, y);
    	}
    	
    	// Draw the placed object
    	if(placed != null) {
    		placed.draw(view, x, y);
    	}
    	
    	// Draw only replicator
    	if(repl != null) {
    		repl.draw(view, x, y);
    	}
    	
    	// Draw player
    	if(player != null) {
    		player.draw(view, x, y);
    	}
    	
    	if(missile != null) {
    		missile.draw(view, x, y);
    	}
	}
}