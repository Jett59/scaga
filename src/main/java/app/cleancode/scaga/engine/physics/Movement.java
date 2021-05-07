package app.cleancode.scaga.engine.physics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import javafx.scene.Node;

public class Movement extends PhysicalLaw {
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private final Map<GameObject<? extends Node>, Long> lastMovementTimes;

	public Movement() {
		lastMovementTimes = new HashMap<>();
	}

	@Override
	public void handle(GameObject<Node> obj) {
		if(obj.xVelocity != 0 || obj.yVelocity != 0) {
			if (lastMovementTimes.containsKey(obj)) {
				long lastMovementTime = lastMovementTimes.get(obj);
				long currentTime = System.nanoTime();
				long delta = currentTime - lastMovementTime;
				double xMoveAmount = delta / 1000000000d * obj.xVelocity;
				double yMoveAmount = delta / 1000000000d * obj.yVelocity;
				obj.move(obj.getX() + (xMoveAmount * screenSize.width), obj.getY() + (yMoveAmount * screenSize.height));
			}
		}
		lastMovementTimes.put(obj, System.nanoTime());
		}

}
