package app.cleancode.scaga.shape.polygon;

import app.cleancode.scaga.bounds.Bound;
import javafx.geometry.Bounds;
import javafx.scene.shape.Polygon;

public class Polygon2D {
    private final Polygon internalPolygon;

    @SuppressWarnings("exports")
    public Polygon2D(Polygon polygon) {
        this.internalPolygon = polygon;
    }

    public Polygon2D(double... points) {
        internalPolygon = new Polygon(points);
    }

    public double[] getPoints() {
        return internalPolygon.getPoints().stream().mapToDouble(Double::valueOf).toArray();
    }

    public Bound getTransformedBound() {
        Bounds internalBounds = internalPolygon.getBoundsInParent();
        return new Bound(internalBounds.getMinX(), internalBounds.getMinY(),
                internalBounds.getWidth(), internalBounds.getHeight());
    }
}
