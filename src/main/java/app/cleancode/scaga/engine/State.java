package app.cleancode.scaga.engine;

import app.cleancode.scaga.engine.keyboard.KeyState;
import app.cleancode.scaga.engine.scene.Scene;
import javafx.scene.Node;

public class State {
public final KeyState keyState;
private final Scene scene;
private final GameObjectLoader objectLoader;
private final GameListenerLoader listenerLoader;

public State(KeyState keyState, Scene scene) {
	this.keyState = keyState;
	this.scene = scene;
	this.objectLoader = new GameObjectLoader();
	this.listenerLoader = new GameListenerLoader();
}

public void createGameObject (GameObject<? extends Node> template) {
	try {
		GameObject<? extends Node> newGameObject = template.duplicate(objectLoader, listenerLoader);
		newGameObject.init();
		scene.objects.add(newGameObject);
		scene.listeners.addAll(newGameObject.attachedListeners);
		scene.gamePane.getChildren().add(newGameObject.node);
	}catch (Exception e) {
		throw new RuntimeException ("Error while creating object "+template.getName(), e);
	}
}
}
