package application;

//Class represents a floor
public final class Floor extends LevelEntity {

	// The possible objects that can be on the floor
	private Player player = null;
	private Replicator repl = null;
    private Placeable placed = null;
    private ZPM zpm = null;
	
	// Create a floor on the level, and set it's zpm
    public Floor(Level l, boolean z) {
		if(z) {
			zpm = new ZPM(l);
		}
    }

    // Set the zpm on the floor
	public void setZPM(Level lvl) {
		zpm = new ZPM(lvl);
	}

    // Returns ZPM, if there is one on the floor
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

    // Defines what happens, if player wants to step on a floor
    public final boolean moveAction(Player p){

    	// if someone on the floor, we can't step here
    	if(player != null){
    		return false;
    	}
    	
    	// if there nothing placed on the floor then the Player can move there
    	if(placed == null) {
			setPlayer(p);
            p.getFloor().setPlayer(null);
            
            // if there is zpm on the floor, the Player collects it
            if(zpm != null) {
                zpm.collect(p.getType());
                zpm = null;
            }
            
            return true;
        }
 
    	// we ask the placed object if we can step there or not
    	boolean canMove = placed.moveEvent(p);
 
    	// if it si possible, the Player moves here
    	if(canMove)
    	{
            p.getFloor().setPlayer(null);
    		p.setFloor(this);
    		player = p;
    		
    		// if there is zpm on the floor, the Player collects it
    		if(zpm != null) {
    			zpm.collect(p.getType());
                zpm = null;
    		}
    	}

    	
    	return canMove;
    }

    // Defines what happens, if the replicator wants to step on a floor
    public final boolean moveAction(Replicator rep){
		
    	// if there nothing placed on the floor then the Replicator can move here
		if(placed == null) {
			rep.getFloor().setRepl(null);
            rep.setFloor(this);
            repl = rep;
            
            // if replicator moved into a missile eliminate it
            if(missile != null) {
            	repl.kill();
            	missile.stop();
            	missile = null;
            }
            
			return true;
		}
		
		// Returns true, if the Replicator can move here
    	boolean canMove = placed.moveEvent(rep);
    	// Replicator can only move here, if there is no Player on the field
        if(player != null) {
            return false;
        }
        
        // Moves Replicator here, if it can
    	if(canMove)
		{
			// Replicator is free to move;
			rep.getFloor().setRepl(null);
			rep.setFloor(this);
			repl = rep;
			
			// If the Replicator moves into the missile, eliminate it
            if(missile != null) {
            	repl.kill();
            	missile.stop();
            	missile = null;
            }
		}

		return canMove;
	}

    // Defines what happens, if a Player wants to pick up, or drop a box
    public final boolean boxAction(Player o, Box b){
        
    	// if the Player has a box, he drops it
    	if(b != null) {
    		// if there aren't boxes placed on the floor, he places it
    		if(placed == null)
        	{
        		placed = b;
        		return true;
        	}
        	
        	boolean canBox = placed.boxEvent(o, b);
        	
        	return canBox;
    		
    	}
    	// if the Player didn't have a box, he tries to pick one up
    	else {
            if (placed == null) {
            	return false;
            }
            
    		boolean bool = placed.boxEvent(o, b);
            if (bool) {
                placed = null;
            }
    		return false;
    	}    	
    }

    // Defines what happens, if a missile wants to fly over a floor
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

    // Return weather we have a box on the floor or not
    public boolean hasBox() {
        if(placed != null) {
            if (placed.getClass().getSimpleName().equals("Box"))
            	return true;
        }
        return false;
    }

    public final void draw(View view, int x, int y) {
		// First draw simple floor
    	view.drawFloor(x, y);    	
    	
    	// Draw the placed object
    	if(placed != null) {
    		placed.draw(view, x, y);
    	}
    	
    	// Draw the replicator
    	if(repl != null) {
    		repl.draw(view, x, y);
    	}
    	
    	// Draw player
    	if(player != null) {
    		player.draw(view, x, y);
    	}
    	
    	// draw ZPM (everything else hides it)
    	if(zpm != null) {
    		zpm.draw(view, x, y);
    	}

		// draw the missile
    	if(missile != null) {
    		missile.draw(view, x, y);
    	}
	}

	@Override
	// ZPM can be placed on the floor
	public boolean canPutZPM() {
		return true;
	}
}