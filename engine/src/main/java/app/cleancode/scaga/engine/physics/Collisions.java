package app.cleancode.scaga.engine.physics;

import java.util.HashSet;
import java.util.Set;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.collisions.PolygonCollider;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.events.CollisionEvent;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Collisions {
	private Set<Collidable> objects;

public Collisions() {
	objects = new HashSet<>();
}

	public Shape check(GameObject<Node> obj) {
			for (Collidable object : objects) {
				if (!object.equals(obj)) {
					Polygon objRegion = obj.getRegion();
					Polygon objectRegion = object.getRegion();
					Shape intersection = PolygonCollider.intersect(objRegion, objectRegion);
					if (!intersection.getBoundsInLocal().isEmpty()) {
						obj.handleEvent(new CollisionEvent(object));
						if (object instanceof GameObject<?>) {
							((GameObject <?>)object).handleEvent(new CollisionEvent(obj));
						}
						return intersection;
					}
				}
			}
			return new Polygon();
		}

	public void registerObject (Collidable c) {
		objects.add(c);
	}

}
