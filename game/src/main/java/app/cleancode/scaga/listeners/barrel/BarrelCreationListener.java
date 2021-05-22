package app.cleancode.scaga.listeners.barrel;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.keyboard.KeyBindings;

public class BarrelCreationListener extends GameListener {
private boolean keyState;

	@ImportGameObject
	public GameObject<?> barrel;

	@Override
	public void update(State state) {
		if (state.keyState.isKeyDown(KeyBindings.CREATE_BARREL)) {
			if (!keyState) {
			state.createGameObject(barrel, Math.random(), -5);
			keyState = true;
			}
		}else {
			keyState = false;
		}
	}

	@Override
	public void startup(State state) {
		
	}

}
