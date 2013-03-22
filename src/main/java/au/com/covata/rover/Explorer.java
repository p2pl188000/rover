package au.com.covata.rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Explorer {
	
	private static final String file = "au/com/covata/rover/input.txt";

	private final Plateau plateau = new Plateau();

	private int currentRoverIndex;
	
	private IRover currentRover;

	private static Explorer explorer = new Explorer();

	private Explorer() {
		currentRoverIndex = 0;
	}

	public static Explorer getInstnace() {
		return explorer;
	}

	public void explore() throws IOException, InstructionException {
		System.out.println("Reading input ...");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(file)));
		String line = null;
		int count = 1;
		System.out.println("Output is: ");
		while ((line = reader.readLine()) != null) {
			if (count == 1) { // first line used to set plateau lower-left and upper-right coordinates.
				setPlateauCoordniate(line);
				count++;
				continue;
			}
			if (count % 2 == 0) { // after setting plateau, every even number of line is used to set start position of a rover.
				try {
					currentRover = createRover(line);
				} catch (Exception e) {
					currentRover = null;
					e.printStackTrace();
				}
			} else {  // odd number line is instruction
					if (currentRover != null) {
						System.out.println(currentRover.execute(line));
					}
			}
			count++;
		}
	}

	private void setPlateauCoordniate(String line) {
		String delims = "[ ]+";
		String[] tokens = line.split(delims);
		plateau.setUpperRight(new Coordinate(Integer.valueOf(tokens[0]),
				Integer.valueOf(tokens[1])));
		plateau.setLowerLeft(new Coordinate(0, 0));
	}

	private IRover createRover(String inputLine) throws Exception {
		String[] tokens = inputLine.split("[ ]+");
		Orientation orientation = Orientation.valueOfShort(tokens[2]);
		if (null == orientation) {
			throw new Exception("No orientation found in the input for rover");
		}
		IRover rover = new Rover(currentRoverIndex, new Position(orientation, new Coordinate(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]))));
		plateau.addRover(rover);
		currentRoverIndex++;
		return rover;
	}
}
