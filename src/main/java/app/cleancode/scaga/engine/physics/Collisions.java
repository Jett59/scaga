package app.cleancode.scaga.engine.physics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.Set;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import app.cleancode.scaga.engine.events.CollisionEvent;
import app.cleancode.scaga.engine.events.StopEvent;
import javafx.geometry.Bounds;
import javafx.scene.Node;

public class Collisions extends PhysicalLaw {
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

private Set<Collidable> objects;

public Collisions() {
	objects = new HashSet<>();
}

	@Override
	public void handle(GameObject<Node> obj) {
			for (Collidable object : objects) {
				if (!object.equals(obj)) {
					Bounds objBounds = obj.getBounds();
					Bounds objectBounds = object.getBounds();
					if (objBounds.intersects(objectBounds)) {
						if (objBounds.getMinY() < objectBounds.getMinY()) {
							obj.isTouchingGround = true;
							obj.yVelocity = Math.min(obj.yVelocity, 0);
						}
						else if (objBounds.getMinY() < objectBounds.getMinY()) {
							obj.yVelocity = Math.max(obj.yVelocity, 0);
						}
						else if (objBounds.getMaxX() < objectBounds.getMaxX()) {
							obj.xVelocity = Math.min(obj.xVelocity, 0);
							obj.handleEvent(new StopEvent());
						} 
						else if (objBounds.getMinX() < objectBounds.getMaxX()) {
							obj.xVelocity = Math.max(obj.xVelocity, 0);
							obj.handleEvent(new StopEvent());
						}
						obj.handleEvent(new CollisionEvent(object));
					}
				}
			}
			objects.add(obj);
		}

}
