package app.cleancode.scaga.engine.physics;

import java.util.HashSet;
import java.util.Set;

import app.cleancode.scaga.bounds.ImageToBounds;
import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import app.cleancode.scaga.engine.events.CollisionEvent;
import javafx.geometry.BoundingBox;
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
			for (GameObject<? extends Collidable> object : objects) {
				if (!object.equals(obj)) {
					if (((Collidable)obj.node).getBounds().intersects(object.node.getBounds())) {
						System.out.println("collision");
						obj.handleEvent(new CollisionEvent(object));
					}
				}
			}
			objects.add((GameObject <? extends Collidable>)obj);
		}
	}

}
