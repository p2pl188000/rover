package au.com.covata.rover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RoverLauncher {
	
	public static void main(String[] args) throws IOException {
		readInputFile();
	}
	
	public  static void readInputFile() throws IOException {
		System.out.println("Read input file ...");
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("au/com/covata/rover/input.txt");
		BufferedReader reader =  new BufferedReader(new InputStreamReader(input));
		String line;
		while((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}
}
