package app.cleancode.scaga.engine.scene;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Scene {
public final GameListener [] listeners;
public final GameObject<? extends Node> [] objects;
public final Pane gamePane;

public Scene(GameObject<? extends Node> [] objects, GameListener[] listeners, Pane gamePane) {
	this.listeners = listeners;
	this.objects = objects;
	this.gamePane = gamePane;
	
}
}
