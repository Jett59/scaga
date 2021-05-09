package app.cleancode.scaga.collisions;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class PolygonCollider {
public static boolean intersects (Polygon a, Polygon b) {
	Shape intersectionShape = Shape.intersect(a, b);
	return !intersectionShape.getBoundsInLocal().isEmpty();
}
}
