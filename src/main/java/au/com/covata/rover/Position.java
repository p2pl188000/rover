package au.com.covata.rover;

import java.io.Serializable;

public class Position implements Cloneable, Serializable {
	private static final long serialVersionUID = -2048527375605794512L;

	private Orientation orientation;

	private Coordinate coordiate;
	
	@Override
	public Position clone() {
		Position position;
		try {
			position = (Position)super.clone();
			position.setOrientation(this.orientation);
			position.setCoordiate(this.coordiate.clone());
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
		return position;
	}

	public Position() {

	}

	public Position(Orientation orientation, Coordinate coordinate)	{
		this.orientation = orientation;
		this.coordiate = coordinate;
	}

	public Coordinate getCoordiate() {
		return coordiate;
	}

	public void setCoordiate(Coordinate coordiate) {
		this.coordiate = coordiate;
	}
	
	public String toString() {
		return Integer.valueOf(this.coordiate.getXcoordinate()).toString() + " " 
				+ Integer.valueOf(this.coordiate.getYcoordinate()).toString() + " " 
				+ this.orientation.getShortString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordiate == null) ? 0 : coordiate.hashCode());
		result = prime * result
				+ ((orientation == null) ? 0 : orientation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (coordiate == null) {
			if (other.coordiate != null)
				return false;
		} else if (!coordiate.equals(other.coordiate))
			return false;
		if (orientation != other.orientation)
			return false;
		return true;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
}
