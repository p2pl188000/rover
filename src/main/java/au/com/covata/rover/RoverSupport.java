package au.com.covata.rover;

abstract class RoverSupport extends AbstractRobotic {

	private static final long serialVersionUID = 9096498196947527083L;

	private Integer index;

	protected Position startPosition = null;

	protected Position currentPosition = null;

	public static final char SPIN_LEFT = 'L';

	public static final char SPIN_RIGHT = 'R';

	public static final char MOVE_FORWARD = 'M';

	@Override
	public boolean validateInstruction(final String instruction) {
		boolean isInstructionValid = super.validateInstruction(instruction);
		if(Boolean.FALSE.equals(isInstructionValid)) {
			return isInstructionValid;
		}
		for(char ch: instruction.toCharArray()) {
			if(ch != SPIN_LEFT
					&& ch != SPIN_RIGHT
					&& ch != MOVE_FORWARD) {
				isInstructionValid = false;
				break;
			}
		}
		return isInstructionValid;
	}

	protected void spin(char rightOrLeft) {
		if(rightOrLeft == SPIN_LEFT) {
			currentPosition.setOrientation(Orientation.leftOf(currentPosition.getOrientation()));
		} else if (rightOrLeft == SPIN_RIGHT) {
			currentPosition.setOrientation(Orientation.rightOf(currentPosition.getOrientation()));
		}
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Position getStartPosition() {
		return startPosition;
	}

	public Position getCurrentPosition() {
		return this.currentPosition;
	}
	
	protected Coordinate getMoveToLocation() {
		Coordinate moveTo = new Coordinate();
		moveTo.setXcoordinate(currentPosition.getCoordiate().getXcoordinate());
		moveTo.setYcoordinate(currentPosition.getCoordiate().getYcoordinate());
		switch(currentPosition.getOrientation()) {
		case EAST:
			moveTo.incrementX();
			break;
		case NORTH:
			moveTo.incrementY();
			break;
		case SOUTH:
			moveTo.decrementY();
			break;
		case WEST:
			moveTo.decrementX();
			break;
		default:
			break;
		
		}
		return moveTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
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
		RoverSupport other = (RoverSupport) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		return true;
	}

}
