package app.cleancode.scaga.shape;

import app.cleancode.scaga.collisions.Collidable;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Rectangle2D extends Rectangle implements Collidable {
	public Rectangle2D(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

public Polygon getRegion () {
	return new Polygon(super.getX(), super.getY(), super.getX() + super.getWidth(), super.getY() + super.getHeight());
}
}
