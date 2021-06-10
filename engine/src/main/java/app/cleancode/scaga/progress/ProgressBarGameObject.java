package app.cleancode.scaga.progress;

import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.config.GameObjectConfig;
import javafx.scene.shape.Polygon;

public class ProgressBarGameObject extends GameObject<ProgressBar> {
private final String name;
private final double x, y, width, height;

	public ProgressBarGameObject(GameObjectConfig config) {
		super(config);
		this.name = config.getName();
		this.x = config.getX();
		this.y = config.getY();
		this.width = config.getWidth();
		this.height = config.getHeight();
		
		super.mass = config.getMass();
		super.drag = config.getDrag();
	}

	@Override
	public Polygon getRegion() {
		return node.getRegion();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void init() {
		node = new ProgressBar(x, y, width, height, 1, name);
	}

}
