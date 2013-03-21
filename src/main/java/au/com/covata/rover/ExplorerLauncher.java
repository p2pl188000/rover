package au.com.covata.rover;

import java.io.IOException;

public class ExplorerLauncher {
	
	public static void main(String[] args) throws IOException, InstructionException {
		Explorer.getInstnace().explore();
	}
}
