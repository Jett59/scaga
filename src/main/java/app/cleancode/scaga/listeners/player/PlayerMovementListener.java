package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.events.MovementEvent;
import app.cleancode.scaga.engine.keyboard.KeyBindings;
import app.cleancode.scaga.objects.player.PlayerObject;

public class PlayerMovementListener extends GameListener {
	@ImportGameObject
public PlayerObject player;

	@Override
	public void update(State state) {
		if (player.isTouchingGround) {
			if (state.keyState.isKeyDown(KeyBindings.MOVE_LEFT)) {
				player.xVelocity = PlayerObject.SPEED * -1;
				player.handleEvent(new MovementEvent(-1, 0));
				}else if (state.keyState.isKeyDown(KeyBindings.MOVE_RIGHT)) {
					player.xVelocity = PlayerObject.SPEED;
					player.handleEvent(new MovementEvent(1, 0));
					}
		}
		}

	@Override
	public void startup(State state) {
		
	}

}
