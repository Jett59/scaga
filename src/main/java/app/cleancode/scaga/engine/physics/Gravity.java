package app.cleancode.scaga.engine.physics;

import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import javafx.scene.Node;

public class Gravity extends PhysicalLaw {
public static double GRAVITY = 1;

	@Override
	public void handle(GameObject<Node> obj) {
		if(!obj.isTouchingGround) {
		double acceleration = obj.mass*GRAVITY;
		obj.yVelocity+=acceleration;
		}
	}

}
