package app.cleancode.scaga.engine.physics;

import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import javafx.scene.Node;

public class Drag extends PhysicalLaw {

	@Override
	public void handle(GameObject<Node> obj) {
		if (obj.isTouchingGround) {
			if (obj.xVelocity < 0) {
				obj.xVelocity = Math.min(0, obj.xVelocity + obj.drag);
			}else if (obj.xVelocity > 0) {
				obj.xVelocity = Math.max(0, obj.xVelocity - obj.drag);
			}
		}
	}

}
