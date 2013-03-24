package au.com.covata.rover;

public enum Orientation {

	NORTH("N"), SOUTH("S"), WEST("W"), EAST("E");

	private String shortString;
	
	private Orientation(String shortString) {
		this.shortString = shortString;
	}
	
	public static Orientation leftOf(Orientation orientation) {
		Orientation toLeft = null;
		switch (orientation) {
			case EAST:
				toLeft = Orientation.NORTH;
				break;
			case NORTH:
				toLeft = Orientation.WEST;
				break;
			case SOUTH:
				toLeft = Orientation.EAST;
				break;
			case WEST:
				toLeft = Orientation.SOUTH;
				break;
			}
		return toLeft;
	}

	public static Orientation rightOf(Orientation orientation) {
		Orientation toRight = null;
		switch (orientation) {
			case EAST:
				toRight = Orientation.SOUTH;
				break;
			case NORTH:
				toRight = Orientation.EAST;
				break;
			case SOUTH:
				toRight = Orientation.WEST;
				break;
			case WEST:
				toRight = Orientation.NORTH;
				break;
			}
		return toRight;
	}
	
	public static Orientation valueOfShort(String shortString) {
		if (shortString.equals("N")) {
			return Orientation.NORTH;
		} else if (shortString.equals("S")) {
			return Orientation.SOUTH;
		} else if (shortString.equals("W")) {
			return Orientation.WEST;
		} else if (shortString.equals("E")) {
			return Orientation.EAST;
		}
		return null;
	}

	public String getShortString() {
		return shortString;
	}

	public void setShortString(String shortString) {
		this.shortString = shortString;
	}
}
