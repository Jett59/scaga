package app.cleancode.scaga.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.config.GameObjectConfig;
import app.cleancode.scaga.engine.events.CollisionEvent;
import app.cleancode.scaga.engine.events.Event;
import javafx.scene.Node;

public abstract class GameObject<NodeType extends Node> implements Collidable {
    public NodeType node;
    public double mass = 0;
    public double drag = 0;
    public boolean isTouchingGround = false;
    public boolean collidable;

    protected List<GameListener> attachedListeners = new ArrayList<>();

    public void attachListener(GameListener listener) {
        this.attachedListeners.add(listener);
    }

    protected Map<String, GameProperty> properties = new HashMap<>();

    public abstract String getName();

    public double xVelocity = 0;
    public double yVelocity = 0;
    public double zVelocity = 0;

    public void move(double newX, double newY) {
        node.setTranslateX(newX);
        node.setTranslateY(newY);
    }

    public double getX() {
        return node.getTranslateX();
    }

    public double getY() {
        return node.getTranslateY();
    }

    public abstract void init();

    public void handleEvent(Event evt) {
        if (evt instanceof CollisionEvent) {
            CollisionEvent collision = (CollisionEvent) evt;
            for (GameListener listener : attachedListeners) {
                listener.onCollision(collision.other);
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    @SuppressWarnings("unchecked")
    protected GameObject<NodeType> duplicate(GameObjectLoader objectLoader, GameListenerLoader listenerLoader,
            State state, List<GameObject<?>> objects) throws Exception {
        GameObject<NodeType> result = (GameObject<NodeType>) objectLoader.loadGameObject(getName());
        var gameObjects = new ArrayList<>(objects);
        gameObjects.add(0, result);
        GameObject<?>[] gameObjectArray = gameObjects.toArray(new GameObject<?>[] {});
        for (GameListener listener : attachedListeners) {
            GameListener newListener = listener.getClass().getConstructor().newInstance();
            listenerLoader.prepareListener(newListener, gameObjectArray);
            listener.startup(state);
        }
        return result;
    }

    public GameObject(GameObjectConfig config) {
        this.collidable = config.getCollidable();
        for (String propertyName : config.getProperties()) {
            properties.put(propertyName, new GameProperty());
        }
    }
}
