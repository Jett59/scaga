package app.cleancode.scaga.resources;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ResourceReader {
public String getResourceAsString (String name) {
	try (InputStream inStream = getClass ().getResourceAsStream(name); BufferedInputStream bufferedStream = new BufferedInputStream(inStream); Scanner scanner = new Scanner (bufferedStream)) {
	String result = "";
	while (scanner.hasNextLine()) {
		result += scanner.nextLine();
	}
	return result;
	}catch (Exception e) {
		e.printStackTrace ();
		return null;
	}
}
}
