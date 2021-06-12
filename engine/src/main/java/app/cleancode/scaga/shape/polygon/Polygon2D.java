package app.cleancode.scaga.shape.polygon;

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
}
