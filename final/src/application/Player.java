package application;

// Class represents a player
public class Player implements IDrawable {

    // the Players parametes, direction, holded box, floor, type, alive, or not
    private Direction dir = Direction.Right;
    private Box box;
    private Floor floor;
    private PlayerType type;
    private boolean alive = true;

    // Creates a type of player
    Player(PlayerType t) {
        type = t;
    }
    
    //  Creates a player on a floor, with a direction
    public Player(Floor f, Direction dir) {
        floor = f;
        this.dir = dir;
    }

    // Returns with the type of the player
    public PlayerType getType() {
        return type;
    }

   
    // Move the player in the parameters direction
    public void move(Direction dir) {
       
        // If the Player is looking in the parameters direction, move in that direction, otherwise turn player to that direction
    	if(this.dir != dir){
        	this.dir = dir;
        } else {
	        LevelEntity entity = floor.getNeighbour(dir);
	    	boolean b = entity.moveAction(this);
	        if(b){
	        	floor = (Floor) entity;
	        }
        }
    }

    // Try to pick up, or drop a box
    public void boxing() {
    	LevelEntity entity = floor.getNeighbour(dir);
        if(entity.boxAction(this, box)){
        	box = null;
        }
    }

    // Pick up a box
    public void setBox( Box b ) {
    	box = b;
    }

    // Eliminate the player
    public void kill() {
    	floor.setPlayer(null);
        alive = false;
    }
    
    // Return the state of Player's life
    public boolean isAlive() {
    	return alive;
    }
    
    // Return the Player's floor
    public Floor getFloor() {
    	return floor;
    }
    
    // Set the player's floor
    public void setFloor(Floor f) {
    	floor = f;
    }

    // Shoot a missile with the players direction
    public void shoot(MissileColor c, Level level) {
    	// only shoot in a valid direction
    	if(dir == null)
    		return;
    	Missile m = new Missile(c, dir, level);
        m.setTile(floor);
        m.move();
    }

    // Set the players direction
    public void setDir(Direction arg) {
        dir = arg;
    }

    // Get the players direction
    public Direction getDirection(){
    	return this.dir;
    }

    // Return weather player has box, or not
    public boolean hasBox() {
        return box != null;
    }

    // Draw a box object to the x, y coordinate
	public void draw(View view, int x, int y) {
    	if(type.equals(PlayerType.ONeill))
    		view.drawONeill(x, y);
    	else
    		view.drawJaffa(x, y);
    	if(box != null)
    		view.drawBox(x, y, 1);
    }

}