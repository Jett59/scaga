package app.cleancode.scaga.engine.camera;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.cleancode.scaga.engine.GameObject;
import javafx.scene.Camera;
import javafx.scene.Node;

public class CameraManager {
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

private final Camera camera;

public CameraManager(Camera camera) {
	this.camera = camera;
}

public void update (GameObject<? extends Node> focus) {
	camera.setTranslateX((focus.getX() - focus.xVelocity) - screenSize.width / 2d);
}

}
