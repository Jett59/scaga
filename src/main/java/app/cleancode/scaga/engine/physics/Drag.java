package app.cleancode.scaga.engine.physics;

import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import app.cleancode.scaga.engine.events.StopEvent;
import javafx.scene.Node;

public class Drag extends PhysicalLaw {

	@Override
	public void handle(GameObject<Node> obj) {
		if (obj.isTouchingGround) {
			if (obj.xVelocity < 0) {
				obj.xVelocity = Math.min(0, obj.xVelocity + obj.drag);
				if (obj.xVelocity == 0) {
					obj.handleEvent(new StopEvent());
				}
			}else if (obj.xVelocity > 0) {
				obj.xVelocity = Math.max(0, obj.xVelocity - obj.drag);
				if (obj.xVelocity == 0) {
					obj.handleEvent(new StopEvent());
				}
			}
		}
	}

}
