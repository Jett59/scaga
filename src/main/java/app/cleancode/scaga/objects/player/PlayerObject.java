package app.cleancode.scaga.objects.player;

import app.cleancode.scaga.animation.Animation;
import app.cleancode.scaga.animation.AnimationBuilder;
import app.cleancode.scaga.characters.Character;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.events.CollisionEvent;
import app.cleancode.scaga.engine.events.Event;
import javafx.scene.Node;
import javafx.util.Duration;

public class PlayerObject extends GameObject<Character> {
public PlayerObject() {
	mass = 1;
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
		System.out.println("collision!");
		if (collision.other.getName().equals("ground")) {
			isTouchingGround = true;
			yVelocity = 0;
		}
	}
	}
}
}
