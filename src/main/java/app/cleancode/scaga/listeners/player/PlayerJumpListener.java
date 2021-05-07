package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.characters.CharacterGameObject;
import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.keyboard.KeyBindings;

@AttachedTo("player")
public class PlayerJumpListener extends GameListener {
public static double SPEED = 0.1;

	@ImportGameObject
public CharacterGameObject player;

	@Override
	public void update(State state) {
		if (state.keyState.isKeyDown(KeyBindings.JUMP)) {
			if (player.isTouchingGround) {
				player.yVelocity = SPEED * -1;
			}
		}
	}

	@Override
	public void startup(State state) {
		
	}

}
