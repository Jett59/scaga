package app.cleancode.scaga.resources;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Scanner;

import javax.imageio.ImageIO;

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
public BufferedImage getResourceAsImage (String path) {
	try (InputStream instream = getClass ().getResourceAsStream(path); BufferedInputStream bufferedStream = new BufferedInputStream(instream)) {
		return ImageIO.read(bufferedStream);
	}catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException (e);
	}
}
}
