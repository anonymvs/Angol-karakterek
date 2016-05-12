package application;

/**
 * 
 */
public final class Floor extends LevelEntity {

	private Player player = null;
	private Replicator repl = null;
    private Placeable placed = null;
    private ZPM zpm = null;
	
	public Floor(Level l, boolean z) {
		if(z) {
			zpm = new ZPM(l);
		}
    }
	
	public void setZPM(Level lvl) {
		zpm = new ZPM(lvl);
	}
	
	public ZPM getZPM() {
		return zpm;
	}

    /**
     * @param o - an instance of Player, that we use to set the Floor's reference
     */
    public void setPlayer(Player o) {
		if(placed != null) {
			placed.moveEvent(o);
		}
    	player = o;
    	if(zpm != null)
    		zpm.collect();
    }

	public void setRepl(Replicator rep) {
		if(placed != null) {
			placed.moveEvent(rep);
		}
		repl = rep;
	}

    /**
     * @param p - an instance of Placeable class, which can be put on the Floor
     */
    public void setPlaced(Placeable p) {
        placed = p;
    }

    /**
     * @return
     */
    public Placeable getPlaceable() {
        return placed;
    }

    /**
     * @param o - an instance of Player
     * @return
     */
    public final boolean moveAction(Player o){

    	if(player != null){
    		return false;
    	}
    	
    	// If there nothing placed on the floor then Player can move here
    	if(placed == null) {
			setPlayer(o);
            o.getFloor().setPlayer(null);
            if(zpm != null) {
                zpm.collect();
                zpm = null;
            }
            return true;
        }
    	boolean canMove = placed.moveEvent(o);
    	
    	if(canMove)
    	{
            o.getFloor().setPlayer(null);
    		o.setFloor(this);
    		player = o;
    		if(zpm != null) {
    			zpm.collect();
                zpm = null;
    		}
    	}

    	
    	return canMove;
    };

	public final boolean moveAction(Replicator rep){
		//System.out.println("FLOOR::moveAction:\t This Floor's move action has been called.");
		// If there nothing placed on the floor then Player can move here
		if(placed == null) {
			//System.out.println("FLOOR::moveAction:\t Yes, there is no object on this Floor.");
			rep.getFloor().setRepl(null);
            rep.setFloor(this);
            repl = rep;
            
            // If replicator moved into a missile kill him
            if(missile != null) {
            	repl.kill();
            	missile.stop();
            	missile = null;
            }
            
			return true;
		}
		//System.out.println("FLOOR::moveAction:\t Something is on this Floor, better check that out.");
		boolean canMove = placed.moveEvent(rep);
        if(player != null) {
            return false;
        }

		if(canMove)
		{
			//Repl is free to move;
			rep.getFloor().setRepl(null);
			rep.setFloor(this);
			repl = rep;
			
			// If replicator moved into a missile kill him
            if(missile != null) {
            	repl.kill();
            	missile.stop();
            	missile = null;
            }
		}

		return canMove;
	}

    /**
     * @param o - an instance of Player
     * @param b - an instance of a Box
     * @return
     */
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

    /**
     * @param mis - an instance of a Missile
     * @return
     */
    public final boolean missileAction(Missile mis) {
    	// Missile hits replicator and it dies
    	if(repl != null) {
    		repl.kill();
    		return false;
    	}
    	
    	return true;
    }

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