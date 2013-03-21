package au.com.covata.rover;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plateau implements Serializable{

	private static final long serialVersionUID = 7315411591822810685L;

	private Coordinate lowerLeft;

	private Coordinate upperRight;

	private final List<IRover> rovers = new ArrayList<IRover>();

	public Plateau() {

	}

	public void addRover(IRover rover) {
		rovers.add(rover);
		rover.setPlateau(this);
	}

	public Plateau(Coordinate lowerLeft, Coordinate upperRight)	{
		this.lowerLeft = lowerLeft;
		this.upperRight = upperRight;
	}

	public Coordinate getLowerLeft() {
		return lowerLeft;
	}

	public void setLowerLeft(Coordinate lowerLeft) {
		this.lowerLeft = lowerLeft;
	}

	public Coordinate getUpperRight() {
		return upperRight;
	}

	public void setUpperRight(Coordinate upperRight) {
		this.upperRight = upperRight;
	}

	/**
	 * Given a location in terms of <code>Coordinate</code>, find out if that location is occupied by a Rover.
	 * This is useful if another rover is moving towards this location.
	 * @param an valid coordinate on the plateau.
	 * @return true if the location is occupied, false otherwise.
	 */
	public boolean isLocationOccupied(Coordinate coordinate) {
		boolean isOccupied = false;
		for (IRover rover : rovers) {
			if(rover.getCurrentPosition() != null
					&& rover.getCurrentPosition().getCoordiate() != null) {
				if(rover.getCurrentPosition().getCoordiate().equals(coordinate)) {
					return true;
				}
			}
		}
		return isOccupied;
	}

}
