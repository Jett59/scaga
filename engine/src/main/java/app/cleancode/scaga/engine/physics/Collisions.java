package app.cleancode.scaga.engine.physics;

import java.util.HashSet;
import java.util.Set;

import app.cleancode.scaga.bounds.Bound;
import app.cleancode.scaga.colliders.PolygonCollider;
import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.events.CollisionEvent;
import app.cleancode.scaga.shape.polygon.Polygon2D;
import javafx.geometry.Bounds;
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
                    Bounds intersectionBounds = intersection.getBoundsInParent();
                    Bound collisionBound = new Bound(intersectionBounds.getMinX(), intersectionBounds.getMinY(),
                            intersectionBounds.getWidth(), intersectionBounds.getHeight());
                    obj.handleEvent(new CollisionEvent(object, collisionBound));
                    if (object instanceof GameObject<?>) {
                        ((GameObject<?>) object).handleEvent(new CollisionEvent(obj, collisionBound));
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
