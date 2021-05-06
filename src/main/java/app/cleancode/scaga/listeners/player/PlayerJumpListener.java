package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.keyboard.KeyBindings;
import app.cleancode.scaga.objects.player.PlayerObject;

public class PlayerJumpListener extends GameListener {
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

	@Override
	public String[] getGameObjects() {
		return new String [] {
				"player"
		};
	}

}
