package app.cleancode.scaga.progress;

import app.cleancode.scaga.shape.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;

public class ProgressBar extends Group {
private final Rectangle2D outer;
private final Rectangle2D inner;
private double progress;

public ProgressBar(double x, double y, double width, double height, double initialProgress, String baseId) {
	this.progress = initialProgress;
	this.outer = new Rectangle2D(x, y, width, height);
	this.inner = new Rectangle2D(x, y, width * progress, height);
	outer.setId(baseId + "_outer");
	inner.setId(baseId + "_inner");
	getChildren ().addAll(outer, inner);
}

public void setProgress (double value) {
	this.progress = value;
}
public double getProgress () {
	return progress;
}
public Polygon getRegion () {
	return outer.getRegion();
}
}
