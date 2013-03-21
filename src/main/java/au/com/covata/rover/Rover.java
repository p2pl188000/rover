package au.com.covata.rover;

public class Rover extends RoverSupport implements IRover {

	private static final long serialVersionUID = -7321489306895682499L;

	private Plateau plateau = null;

	public Rover() {

	}

	public Rover(int index) {
		this.setIndex(index);
	}

	public Rover(int index, Position startPosition) {
		this.setIndex(index);
		this.setStartPosition(startPosition);
	}

	public Position execute(String instruction) {
		if (!validateInstruction(instruction)) {
			return currentPosition;
		}
		for (char instructionChar : instruction.toCharArray()) {
			execute(instructionChar);
		}
		return currentPosition;
	}

	// if the location a rover moving to is occupied by another rover, the
	// movement can not be made.
	private boolean isMoveToLocationEmpty() {
		assert (plateau != null);
		return !plateau.isLocationOccupied(getMoveToLocation());
	}

	// if the location a rover moving to is not within the plateau boundary, the
	// movement can not be made.
	private boolean isMoveToLocationWithinPlateauBoundary() {
		final int maxX = plateau.getUpperRight().getXcoordinate();
		final int maxY = plateau.getUpperRight().getYcoordinate();
		final int minX = plateau.getLowerLeft().getXcoordinate();
		final int minY = plateau.getLowerLeft().getYcoordinate();
		final int currentX = getMoveToLocation().getXcoordinate();
		final int currentY = getMoveToLocation().getYcoordinate();
		return currentX >= minX && currentX <= maxX && currentY < maxY && currentY >= minY;
	}

	/**
	 * 
	 * @param instructionChar
	 *            may be 'L', 'R', and 'M'
	 */
	private void execute(char instructionChar) {
		switch (instructionChar) {
		case 'L':
			spin(SPIN_LEFT);
			break;
		case 'R':
			spin(SPIN_RIGHT);
			break;
		case 'M':
			try {
				moveForward();
			} catch (InstructionException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	private void moveForward() throws InstructionException {
		if(!isMoveToLocationEmpty() || !isMoveToLocationWithinPlateauBoundary()) {
			throw new InstructionException("The rover will fall over the plateau, or collide with another rover");
		}
		currentPosition.setCoordiate(getMoveToLocation());
	}

	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
		this.currentPosition = startPosition;
	}

	public int getSquadIndex() {
		return getIndex();
	}

	public void setSquadIndex(int index) {
		setIndex(index);
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
}
