package au.com.covata.rover;

import java.io.Serializable;

public class Coordinate implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 5661546760994471859L;

	private int xCoordinate;

	private int yCoordinate;

	public Coordinate() {
		
	}
	
	@Override
	public Coordinate clone() {
		Coordinate cloned = null;
		try {
			cloned = (Coordinate)super.clone();
			cloned.setXcoordinate(xCoordinate);
			cloned.setYcoordinate(yCoordinate);
		} catch (CloneNotSupportedException e) {
			throw new AssertionError(e);
		}
		return cloned;
	}
	
	public Coordinate(int x, int y) {
		this.xCoordinate = x;
		this.yCoordinate = y;
	}

	public int getXcoordinate() {
		return xCoordinate;
	}

	public void setXcoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getYcoordinate() {
		return yCoordinate;
	}

	public void setYcoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	public void incrementX() {
		xCoordinate++;
	}
	
	public void incrementY() {
		yCoordinate++;
	}
	
	public void decrementX() {
		xCoordinate--;
	}
	
	public void decrementY() {
		yCoordinate--;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xCoordinate;
		result = prime * result + yCoordinate;
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
		Coordinate other = (Coordinate) obj;
		if (xCoordinate != other.xCoordinate)
			return false;
		if (yCoordinate != other.yCoordinate)
			return false;
		return true;
	}
}
