package app.cleancode.scaga.engine.physics;

import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import javafx.scene.Node;

public class Movement extends PhysicalLaw {

	@Override
	public void handle(GameObject<Node> obj) {
		if(obj.xVelocity != 0 || obj.yVelocity != 0) {
			obj.move(obj.getX() + obj.xVelocity, obj.getY() + obj.yVelocity);
		}
		}

}
