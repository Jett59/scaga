package app.cleancode.scaga.engine.physics;

import java.util.HashSet;
import java.util.Set;

import app.cleancode.scaga.bounds.ImageToBounds;
import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import app.cleancode.scaga.engine.events.CollisionEvent;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;

public class Collisions extends PhysicalLaw {
private Set<GameObject<? extends Collidable>> objects;

public Collisions() {
	objects = new HashSet<>();
}

	@SuppressWarnings("unchecked")
	@Override
	public void handle(GameObject<Node> obj) {
		if (obj.node instanceof Collidable) {
			GameObject<? extends Collidable> collidableObj = (GameObject<? extends Collidable>)obj;
			for (GameObject<? extends Collidable> object : objects) {
				if (!object.equals(obj)) {
					Bounds objBounds = collidableObj.node.getBounds();
					Bounds objectBounds = object.node.getBounds();
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
					}
				}
			}
			objects.add((GameObject <? extends Collidable>)obj);
		}
	}

}
