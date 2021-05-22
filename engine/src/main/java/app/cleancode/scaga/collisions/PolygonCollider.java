package app.cleancode.scaga.collisions;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class PolygonCollider {
public static Shape intersect (Polygon a, Polygon b) {
	return Shape.intersect(a, b);
}
}
