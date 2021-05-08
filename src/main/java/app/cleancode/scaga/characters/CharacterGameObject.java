package app.cleancode.scaga.characters;

import app.cleancode.scaga.characters.Character.State;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.config.GameObjectConfig;
import app.cleancode.scaga.engine.events.Event;
import app.cleancode.scaga.engine.events.MovementEvent;
import javafx.geometry.Bounds;

public class CharacterGameObject extends GameObject<Character> {
private final String name;
private final String characterName;
private final double x, y;

public CharacterGameObject(GameObjectConfig config) {
	this.name = config.getName();
	this.characterName = config.getCharacterName();
	this.x = config.getX();
	this.y = config.getY();
	
	super.mass = config.getMass();
	super.drag = config.getDrag();
}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void init() {
		node = new Character(characterName);
		move (x, y);
	}

	@Override
	public void handleEvent(Event evt) {
		switch (evt.getType()) {
		case MOVE: {
			MovementEvent movement = (MovementEvent)evt;
			node.setDirection(movement.direction);
			node.changeState(State.RUNNING);
			break;
		}
		case STOP: {
			node.changeState(State.IDLE);
			break;
		}
		default:
			break;
		}
	}

	@Override
	public Bounds getBounds() {
		return node.getBounds();
	}

}
