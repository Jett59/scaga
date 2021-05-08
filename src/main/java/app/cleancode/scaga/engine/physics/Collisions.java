package app.cleancode.scaga.engine.physics;

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
							obj.move(obj.getX(), obj.getY() + obj.yVelocity * -1);
							obj.yVelocity = Math.min(obj.yVelocity, 0);
						}
						else if (objBounds.getMinY() < objectBounds.getMinY()) {
							obj.move(obj.getX(), obj.getY() + obj.yVelocity * -1);
							obj.yVelocity = Math.max(obj.yVelocity, 0);
						}
						else if (objBounds.getMaxX() < objectBounds.getMaxX()) {
							obj.move(obj.getX() + obj.xVelocity * -1, obj.getY());
							obj.xVelocity = Math.min(obj.xVelocity, 0);
						} 
						else if (objBounds.getMinX() < objectBounds.getMaxX()) {
							obj.move(obj.getX() + obj.xVelocity * -1, obj.getY());
							obj.xVelocity = Math.max(obj.xVelocity, 0);
						}
						obj.handleEvent(new CollisionEvent(object));
						obj.handleEvent(new StopEvent());
					}
				}
			}
			objects.add(obj);
		}

}
