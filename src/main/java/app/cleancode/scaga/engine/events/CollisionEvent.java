package app.cleancode.scaga.engine.events;

import app.cleancode.scaga.collisions.Collidable;

public class CollisionEvent implements Event {
	public final Collidable other;

public CollisionEvent(Collidable other) {
	this.other = other;
}

	@Override
	public Type getType() {
		return Event.Type.COLLISION;
	}

}
