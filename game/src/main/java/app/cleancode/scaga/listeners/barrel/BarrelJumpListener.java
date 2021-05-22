package app.cleancode.scaga.listeners.barrel;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;

@AttachedTo("barrel")
public class BarrelJumpListener extends GameListener {
private static final double SPEED = 0.7;

@ImportGameObject
public GameObject<?> barrel;

	@Override
	public void update(State state) {
		
	}

	@Override
	public void startup(State state) {
		
	}

@Override
	public void onCollision(Collidable other) {
		if (barrel.isTouchingGround && !other.toString().equals("ground")) {
			barrel.yVelocity = SPEED * -1;
		}
	}

}
