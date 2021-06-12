package app.cleancode.scaga.engine.physics;

import java.util.HashSet;
import java.util.Set;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.events.CollisionEvent;
import app.cleancode.scaga.shape.polygon.Polygon2D;
import app.cleancode.scaga.shape.polygon.PolygonCollider;
import javafx.scene.shape.Shape;

public class Collisions {
    private Set<Collidable> objects;

    public Collisions() {
        objects = new HashSet<>();
    }

    public Shape check(GameObject<?> obj) {
        for (Collidable object : objects) {
            if (!object.equals(obj)) {
                Polygon2D objRegion = obj.getRegion();
                Polygon2D objectRegion = object.getRegion();
                Shape intersection = PolygonCollider.intersect(objRegion, objectRegion);
                if (!intersection.getBoundsInLocal().isEmpty()) {
                    obj.handleEvent(new CollisionEvent(object));
                    if (object instanceof GameObject<?>) {
                        ((GameObject<?>) object).handleEvent(new CollisionEvent(obj));
                    }
                    return intersection;
                }
            }
        }
        return new javafx.scene.shape.Polygon();
    }

    public void registerObject(Collidable c) {
        objects.add(c);
    }

}
