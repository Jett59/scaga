package app.cleancode.scaga.engine;

import java.util.function.Consumer;

import javafx.scene.Node;

public abstract class GameObject<NodeType extends Node> {
	public NodeType node;
	public double mass = 0;
	public boolean isTouchingGround = false;
public Consumer<Node> addNode;
public void addNode(Node node) {
	addNode.accept(node);
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
}
