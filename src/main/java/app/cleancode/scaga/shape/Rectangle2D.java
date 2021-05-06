package app.cleancode.scaga.shape;

import app.cleancode.scaga.collisions.Collidable;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;

public class Rectangle2D extends Rectangle implements Collidable {
	public Rectangle2D(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
@Override
public Bounds getBounds() {
	return super.getBoundsInParent();
}
}
