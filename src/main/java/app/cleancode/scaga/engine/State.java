package app.cleancode.scaga.engine;

import app.cleancode.scaga.engine.keyboard.KeyState;
import app.cleancode.scaga.engine.scene.Scene;

public class State {
public final KeyState keyState;
private final Scene scene;

public State(KeyState keyState, Scene scene) {
	this.keyState = keyState;
	this.scene = scene;
}
}
