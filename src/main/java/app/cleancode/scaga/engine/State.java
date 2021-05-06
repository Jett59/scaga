package app.cleancode.scaga.engine;

import app.cleancode.scaga.engine.keyboard.KeyState;

public class State {
public final KeyState keyState;

public State(KeyState keyState) {
	this.keyState = keyState;
}
}
