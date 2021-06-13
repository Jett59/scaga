package app.cleancode.scaga.characters;

import app.cleancode.scaga.characters.state.State;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.config.GameObjectConfig;
import app.cleancode.scaga.engine.events.Event;
import app.cleancode.scaga.engine.events.MovementEvent;
import app.cleancode.scaga.shape.polygon.Polygon2D;

public class CharacterGameObject extends GameObject<Character> {
    private final String name;
    private final String characterName;
    private final double x, y;

    private final GameProperty stateProperty;

    public CharacterGameObject(GameObjectConfig config) {
        super(config);
        this.name = config.getName();
        this.characterName = config.getCharacterName();
        this.x = config.getX();
        this.y = config.getY();

        super.mass = config.getMass();
        super.drag = config.getDrag();

        stateProperty = new GameProperty();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void init() {
        node = new Character(characterName);
        move(x, y);
        properties.put("state", stateProperty);
        stateProperty.set(node.getState());
    }

    @Override
    public void handleEvent(Event evt) {
        super.handleEvent(evt);
        switch (evt.getType()) {
        case MOVE: {
            MovementEvent movement = (MovementEvent) evt;
            node.setDirection(movement.direction);
            node.changeState(State.RUNNING);
            stateProperty.set(node.getState());
            break;
        }
        case STOP: {
            node.changeState(State.IDLE);
            stateProperty.set(node.getState());
            break;
        }
        default:
            break;
        }
    }

    public Polygon2D getRegion() {
        return node.getRegion();
    }

}
