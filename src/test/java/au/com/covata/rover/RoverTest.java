package au.com.covata.rover;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class RoverTest {

	
	
	@Before
	public void init() {
		
	}
	
	@Test
	public void shouldExecuteInstruction() {
		final Plateau plateau = new Plateau(new Coordinate(0,0), new Coordinate(5, 5));
		final Rover rover = createRover(0, new Position(Orientation.NORTH,new Coordinate(1, 2)));
		plateau.addRover(rover);
		final String instruction = "LMLMLMLMM";
		Position position = rover.execute(instruction);
		assertTrue(position.toString().equals("1 3 N"));
		rover.setStartPosition(new Position(Orientation.EAST, new Coordinate(3,3)));
		Position position2 = rover.execute("MMRMMRMRRM");
		assertTrue(position2.toString().equals("5 1 E"));
	}

	@Test
	public void shouldValidateInstruction() {
		final String validTestInstruction = "LMLM";
		assertTrue(createRover(0).validateInstruction(validTestInstruction));
		final String invalidTestInstruction = "LMXX";
		assertFalse(createRover(0).validateInstruction(invalidTestInstruction));
	}

	@Test
	public void shouldSpinToLeftOrRight() {
		Rover testRover = createRover(0,new Position(Orientation.NORTH, new Coordinate(10, 10)));
		testRover.spin('L');
		assertTrue(testRover.getCurrentPosition().getOrientation().equals(Orientation.WEST));
		testRover.spin('L');
		assertTrue(testRover.getCurrentPosition().getOrientation().equals(Orientation.SOUTH));
		testRover.spin('L');
		assertTrue(testRover.getCurrentPosition().getOrientation().equals(Orientation.EAST));
		testRover.spin('L');
		assertTrue(testRover.getCurrentPosition().getOrientation().equals(Orientation.NORTH));
		testRover.spin('R');
		assertTrue(testRover.getCurrentPosition().getOrientation().equals(Orientation.EAST));
		testRover.spin('R');
		assertTrue(testRover.getCurrentPosition().getOrientation().equals(Orientation.SOUTH));
		testRover.spin('R');
		assertTrue(testRover.getCurrentPosition().getOrientation().equals(Orientation.WEST));
		testRover.spin('R');
		assertTrue(testRover.getCurrentPosition().getOrientation().equals(Orientation.NORTH));
	}

	public static Rover createRover(int index) {
		return new Rover(index);
	}

	public static Rover createRover(int index, Position startPosition) {
		return new Rover(index, startPosition);
	}



}
