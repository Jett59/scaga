package app.cleancode.scaga.shape.objects;

import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.config.GameObjectConfig;
import app.cleancode.scaga.engine.events.Event;
import app.cleancode.scaga.shape.Rectangle2D;

public class RectangleGameObject extends GameObject<Rectangle2D> {
private final double x, y, width, height;
private final String name;
private final boolean wantsCameraFocus;

public RectangleGameObject(GameObjectConfig config) {
	this.x = config.getX();
	this.y = config.getY();
	this.width = config.getWidth();
	this.height = config.getHeight();
	this.wantsCameraFocus = config.getWantsCameraFocus();
	this.name = config.getName();
}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean wantsCameraFocus() {
		return wantsCameraFocus;
	}

	@Override
	public void init() {
		node = new Rectangle2D(x, y, width, height);
		node.setId(name);
	}

	@Override
	public void handleEvent(Event evt) {
		
	}

}
