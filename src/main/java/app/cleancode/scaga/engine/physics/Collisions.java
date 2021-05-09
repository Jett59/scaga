package app.cleancode.scaga.engine.physics;

import java.util.HashSet;
import java.util.Set;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import app.cleancode.scaga.engine.events.CollisionEvent;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;

public class Collisions extends PhysicalLaw {
	private Set<Collidable> objects;

public Collisions() {
	objects = new HashSet<>();
}

	@Override
	public void handle(GameObject<Node> obj) {
			for (Collidable object : objects) {
				if (!object.equals(obj)) {
					Polygon objRegion = obj.getRegion();
					Polygon objectRegion = object.getRegion();
					if (objRegion.intersects(objectRegion.getBoundsInParent())) {
						// todo: detect which directions the shape can not go in
						System.out.printf("collision: %s collided with %s\n", obj.getName(), object.toString());
								obj.yVelocity = 0;
												obj.handleEvent(new CollisionEvent(object));
					}
				}
			}
			objects.add(obj);
		}

}
