package app.cleancode.scaga.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import app.cleancode.scaga.bounds.ImageToBounds;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.config.GameObjectConfig;
import app.cleancode.scaga.engine.events.Event;
import app.cleancode.scaga.resources.ResourceReader;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SpriteGameObject extends GameObject<ImageView> {
	private static final String PATH_FORMAT = "/sprites/%s.png";

private final String spriteName;
private final String name;
private final double x, y;
private double width, height;

private final ResourceReader resourceReader;

private BoundingBox bounds;

	public SpriteGameObject(GameObjectConfig config) {
		this.spriteName = config.getSpriteName();
		this.name = config.getName();
		
		this.x = config.getX();
		this.y = config.getY();
		
		this.width = config.getWidth();
		this.height = config.getHeight();
		
		super.mass = config.getMass();
		super.drag = config.getDrag();
		
		this.resourceReader = new ResourceReader();
	}

	@Override
	public Bounds getBounds() {
		double xOffset = 0, yOffset = 0;
		Node tmp = node;
		do {
			xOffset += tmp.getTranslateX();
			yOffset += tmp.getTranslateY();
		}while ((tmp = tmp.getParent()) != null);
		return new BoundingBox(bounds.getMinX() + xOffset, bounds.getMinY() + yOffset, bounds.getWidth(), bounds.getHeight());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void init() {
		if (width != 0 && height != 0) {
			System.err.println("error occured while trying to build sprite for "+name);
			throw new IllegalArgumentException("only one of either width and height can be specified");
		}
		BufferedImage bufferedImage = resourceReader.getResourceAsImage(String.format(PATH_FORMAT, spriteName));
		double scale;
		if (width != 0) {
			scale = width / bufferedImage.getWidth();
			height = bufferedImage.getHeight() * scale;
		}else {
			scale = height / bufferedImage.getHeight();
			width = bufferedImage.getWidth() * scale;
		}
		BufferedImage scaledImage = new BufferedImage((int)width, (int)height, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics graphics = scaledImage.getGraphics();
		graphics.drawImage(bufferedImage, 0, 0, scaledImage.getWidth(), scaledImage.getHeight(), null);
		graphics.dispose();
		Image img = SwingFXUtils.toFXImage(scaledImage, null);
		bounds = ImageToBounds.getBounds(img);
		node = new ImageView(img);
		move(x, y);
	}

	@Override
	public void handleEvent(Event evt) {
		
	}

}
