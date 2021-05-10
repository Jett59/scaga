package app.cleancode.scaga.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.events.CollisionEvent;
import app.cleancode.scaga.engine.events.Event;
import javafx.scene.Node;

public abstract class GameObject<NodeType extends Node> implements Collidable {
	public NodeType node;
	public double mass = 0;
	public double drag = 0;
	public boolean isTouchingGround = false;
public Consumer<Node> addNode;
public void addNode(Node node) {
	addNode.accept(node);
}
private List<GameListener> attachedListeners = new ArrayList<>();
public void attachListener (GameListener listener) {
	this.attachedListeners.add(listener);
}
public abstract String getName();
public double xVelocity = 0;
public double yVelocity = 0;
public double zVelocity = 0;

public void move(double newX, double newY) {
	node.setTranslateX(newX);
	node.setTranslateY(newY);
}

public double getX () {
	return node.getTranslateX();
}
public double getY () {
	return node.getTranslateY();
}

public abstract void init ();

public int hashCode () {
	return getName ().hashCode();
}
@SuppressWarnings("unchecked")
public boolean equals (Object other) {
	if (other instanceof GameObject) {
		return ((GameObject <Node>)other).getName().equals(getName());
	}
	return false;
}

public void handleEvent (Event evt) {
	if (evt instanceof CollisionEvent) {
		CollisionEvent collision = (CollisionEvent)evt;
		for (GameListener listener : attachedListeners) {
			listener.onCollision(collision.other);
		}
	}
}

@Override
public String toString() {
	return getName ();
}
}
