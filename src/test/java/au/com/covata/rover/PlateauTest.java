package au.com.covata.rover;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlateauTest {

	private Plateau plateau = new Plateau(new Coordinate(0, 0), new Coordinate(5, 5));
	
	private static int OCCUPIED_LOCAION_X = 3;
	
	private static int OCCUPIED_LOCAION_Y = 3;
	
	@Before
	public void init() {
		Rover rover = new Rover(0, new Position(Orientation.NORTH, new Coordinate(OCCUPIED_LOCAION_X, OCCUPIED_LOCAION_Y)));
		plateau.addRover(rover);
	}
	
	@Test
	public void testIsLocationOccupied() {
		assertFalse(plateau.isLocationOccupied(new Coordinate(1, 0)));
		assertTrue(plateau.isLocationOccupied(new Coordinate(3, 3)));
	}

}
