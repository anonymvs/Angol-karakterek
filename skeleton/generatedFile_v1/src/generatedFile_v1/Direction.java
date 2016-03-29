package generatedFile_v1;

public enum Direction {
	Right, Left, Top, Bottom;
	
	public Direction inverse() {
		System.out.println("DIRECTION::inverse:\t invert direction.");
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
}
