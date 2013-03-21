package au.com.covata.rover;

interface IRover {

	/**
	 *
	 * @param instruction the <code>Instruction</code> string.
	 * @return new Position after the execution of the instruction.
	 */
	Position execute(String instruction);

	void setStartPosition(Position startPosition);

	Position getStartPosition();

	Position getCurrentPosition();

	int getSquadIndex();

	void setSquadIndex(int index);
	
	void setPlateau(Plateau plateau);
	
	Plateau getPlateau();

}
