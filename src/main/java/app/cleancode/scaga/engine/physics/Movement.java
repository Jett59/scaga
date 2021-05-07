package app.cleancode.scaga.engine.physics;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import javafx.scene.Node;

public class Movement extends PhysicalLaw {
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	@Override
	public void handle(GameObject<Node> obj) {
		if(obj.xVelocity != 0 || obj.yVelocity != 0) {
			obj.move(obj.getX() + (obj.xVelocity * screenSize.width), obj.getY() + (obj.yVelocity * screenSize.height));
		}
		}

}
