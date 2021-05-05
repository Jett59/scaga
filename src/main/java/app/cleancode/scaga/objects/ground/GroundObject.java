package app.cleancode.scaga.objects.ground;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.cleancode.scaga.engine.GameObject;
import javafx.scene.shape.Rectangle;

public class GroundObject extends GameObject<Rectangle> {
private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	@Override
	public String getName() {
		return "ground";
	}

	@Override
	public void init() {
		node = new Rectangle(-1024, screenSize.height - 150, screenSize.width + 2048, 150);
		node.getStyleClass().add("ground");
	}

}
