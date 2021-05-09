package app.cleancode.scaga.engine.physics;

import java.util.HashSet;
import java.util.Set;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.collisions.PolygonCollider;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.events.CollisionEvent;
import javafx.scene.Node;
import javafx.scene.shape.Polygon;

public class Collisions {
	private Set<Collidable> objects;

public Collisions() {
	objects = new HashSet<>();
}

	public boolean check(GameObject<Node> obj) {
			for (Collidable object : objects) {
				if (!object.equals(obj)) {
					Polygon objRegion = obj.getRegion();
					Polygon objectRegion = object.getRegion();
					if (PolygonCollider.intersects(objRegion, objectRegion)) {
						obj.handleEvent(new CollisionEvent(object));
												return true;
					}
				}
			}
			return false;
		}

	public void registerObject (Collidable c) {
		objects.add(c);
	}

}
