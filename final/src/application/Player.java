package application;

/**
 * 
 */
public class Player implements IDrawable {

    /**
     * 
     */
    private Direction dir = Direction.Right;
    private Box box;
    private Floor floor;
    private PlayerType type;
    private boolean alive = true;

    Player(PlayerType t) {
        type = t;
    }

    public PlayerType getType() {
        return type;
    }

    /**
     *
     * @param f
     * @param dir
     */
    public Player(Floor f, Direction dir) {
        floor = f;
        this.dir = dir;
    }

    /**
     * 
     */
    public void move(Direction dir) {
        //System.out.println("ONEILL::move:\t A movement has been triggered.");
    	
        if(this.dir != dir){
        	this.dir = dir;
        } else {
	        LevelEntity entity = floor.getNeighbour(dir);
	    	boolean b = entity.moveAction(this);
	        if(b){
	        	floor = (Floor) entity;
	        	//System.out.println("ONEILL::move:\t Player has moved.");
	        }
        }
    }

    /**
     * 
     */
    public void boxing() {
    	//System.out.println("ONEILL::boxing");
    	LevelEntity entity = floor.getNeighbour(dir);
        boolean b = entity.boxAction(this, box);
        if(b){
        	box = null;
        }
    }

    /**
     * @param b
     */
    public void setBox( Box b ) {
    	//System.out.println("ONEILL::setBox");
        box = b;
    }

    /**
     * 
     */
    public void kill() {
    	//System.out.println("ONEILL::kill:\t Game Over");
        floor.setPlayer(null);
        alive = false;
    }
    
    public boolean isAlive() {
    	return alive;
    }
    
    public Floor getFloor() {
    	//System.out.println("ONEILL::getFloor");
        return floor;
    }
    
    public void setFloor(Floor f) {
    	//System.out.println("ONEILL::setFloor");
    	floor = f;
    }

    /**
     * 
     */
    public void shoot(MissileColor c, Level level) {
    	// Only shoot in a valid direction
    	if(dir == null)
    		return;
    	Missile m = new Missile(c, dir, level);
        m.setTile(floor);
        m.move();
        //m.move();
    }

    public void setDir(Direction arg) {
        dir = arg;
    }

    public Direction getDir() {
        return dir;
    }

    public boolean hasBox() {
        return box != null;
    }
    
    public void draw(View view, int x, int y) {
    	if(type.equals(PlayerType.ONeill))
    		view.drawONeill(x, y);
    	else
    		view.drawJaffa(x, y);
    	if(box != null)
    		view.drawBox(x, y, 1);
    }
    public Direction getDirection(){
    	return this.dir;
    }

}