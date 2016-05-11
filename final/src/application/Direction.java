package application;

public enum Direction {
	Right, Left, Top, Bottom;
	
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
