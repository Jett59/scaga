package app.cleancode.scaga.objects.player;

import app.cleancode.scaga.characters.Character;
import app.cleancode.scaga.characters.Character.State;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.events.CollisionEvent;
import app.cleancode.scaga.engine.events.Event;
import app.cleancode.scaga.engine.events.MovementEvent;

public class PlayerObject extends GameObject<Character> {
public static final double SPEED = 5;

public PlayerObject() {
	mass = 1;
	drag = 1;
}

@Override
public String getName() {
	return "player";
}

@Override
public void init() {
	node = new Character("Samurai");
}

@Override
public void handleEvent(Event evt) {
	switch (evt.getType()) {
	case COLLISION: {
		CollisionEvent collision = (CollisionEvent)evt;
		if (collision.other.getName().equals("ground")) {
			isTouchingGround = true;
			yVelocity = 0;
		}
	}
	case MOVE: {
		MovementEvent movementEvent = (MovementEvent)evt;
		node.setDirection(movementEvent.direction);
		node.changeState(State.RUNNING);
		break;
	}
	default:
		break;
	}
}
}
