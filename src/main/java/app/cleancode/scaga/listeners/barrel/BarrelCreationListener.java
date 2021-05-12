package app.cleancode.scaga.listeners.barrel;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.keyboard.KeyBindings;

public class BarrelCreationListener extends GameListener {

	@ImportGameObject
	public GameObject<?> barrel;

	private long lastBarrel = -1;

	@Override
	public void update(State state) {
		if (state.keyState.isKeyDown(KeyBindings.CREATE_BARREL)) {
			long now = System.nanoTime();
			if (now >= lastBarrel + 1000000000) {
			state.createGameObject(barrel, Math.random(), 0);
			lastBarrel = now;
			}
		}
	}

	@Override
	public void startup(State state) {
		
	}

}