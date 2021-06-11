package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;
import app.cleancode.scaga.engine.events.ProgressUpdateEvent;

@AttachedTo("player")
public class PlayerHealthListener extends GameListener {

@ImportGameProperty(owner="player")
public GameProperty health;

@ImportGameObject
public GameObject<?> healthBar;

	@Override
	public void update(State state) {
		healthBar.handleEvent(new ProgressUpdateEvent(health.getDouble()));
	}

	@Override
	public void startup(State state) {
		health.set(0.5d);
	}

}
