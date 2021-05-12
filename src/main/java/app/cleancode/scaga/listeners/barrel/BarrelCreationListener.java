package app.cleancode.scaga.listeners.barrel;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.keyboard.KeyBindings;

public class BarrelCreationListener extends GameListener {

	@ImportGameObject
	public GameObject<?> barrel;

	@Override
	public void update(State state) {
		if (state.keyState.isKeyDown(KeyBindings.CREATE_BARREL)) {
			state.createGameObject(barrel, Math.random(), 0);
		}
	}

	@Override
	public void startup(State state) {
		
	}

}
