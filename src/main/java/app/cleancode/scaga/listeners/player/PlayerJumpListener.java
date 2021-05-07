package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.keyboard.KeyBindings;
import app.cleancode.scaga.objects.player.PlayerObject;

@AttachedTo("player")
public class PlayerJumpListener extends GameListener {
	@ImportGameObject
public PlayerObject player;

	@Override
	public void update(State state) {
		if (state.keyState.isKeyDown(KeyBindings.JUMP)) {
			if (player.isTouchingGround) {
				player.yVelocity = PlayerObject.JUMP_VELOCITY * -1;
			}
		}
	}

	@Override
	public void startup(State state) {
		
	}

}
