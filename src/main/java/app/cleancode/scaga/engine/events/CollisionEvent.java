package app.cleancode.scaga.engine.events;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameObject;

public class CollisionEvent implements Event {
public final GameObject<? extends Collidable> other;

public CollisionEvent(GameObject <? extends Collidable> other) {
	this.other = other;
}

	@Override
	public Type getType() {
		return Event.Type.COLLISION;
	}

}
