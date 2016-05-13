package application;

//Class represents a direction
public enum Direction {
	
	// Possible type of directions
	Right, Left, Top, Bottom;
	
	// Invert directions
	public Direction inverse() {
		switch (this)
		{
			case Right:
				return Left;
			case Left:
				return Right;
			case Top:
				return Bottom;
			case Bottom:
				return Top;
			default:
				return null;
		}
	}

	// Return with the direction from string
	public static Direction getDir(String arg) {
		switch(arg) {
			case "right":
				return Direction.Right;
			case "left":
				return Direction.Left;
			case "up":
				return Direction.Top;
			case "down":
				return Direction.Bottom;
			default:
				return null;
		}
	}

	// Return with the direction in string
	public static String getDir(Direction d) {
		switch (d) {
			case Right:
				return "right";
			case Left:
				return "left";
			case Top:
				return "upward";
			case Bottom:
				return "downward";
			default:
				return null;
		}
	}
}
