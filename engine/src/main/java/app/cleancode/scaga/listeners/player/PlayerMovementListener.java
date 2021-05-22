package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.characters.CharacterGameObject;
import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.events.MovementEvent;
import app.cleancode.scaga.engine.keyboard.KeyBindings;

@AttachedTo("player")
public class PlayerMovementListener extends GameListener {
	public static double SPEED = 0.25;

	@ImportGameObject
public CharacterGameObject player;

	@Override
	public void update(State state) {
			if (state.keyState.isKeyDown(KeyBindings.MOVE_LEFT)) {
				player.xVelocity = SPEED * -1;
				player.handleEvent(new MovementEvent(-1, 0));
				}else if (state.keyState.isKeyDown(KeyBindings.MOVE_RIGHT)) {
					player.xVelocity = SPEED;
					player.handleEvent(new MovementEvent(1, 0));
					}
		}

	@Override
	public void startup(State state) {
		
	}

}
