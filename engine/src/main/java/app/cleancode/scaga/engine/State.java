package app.cleancode.scaga.engine;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.cleancode.scaga.engine.keyboard.KeyState;
import app.cleancode.scaga.engine.scene.Scene;
import javafx.scene.Node;

public class State {
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private boolean initialized = false;
    public final KeyState keyState;
    private final Scene scene;
    private final GameObjectLoader objectLoader;
    private final GameListenerLoader listenerLoader;

    protected State(KeyState keyState, Scene scene) {
        this.keyState = keyState;
        this.scene = scene;
        this.objectLoader = new GameObjectLoader();
        this.listenerLoader = new GameListenerLoader();
    }

    public void createGameObject(GameObject<?> template, double x, double y) {
        try {
            GameObject<? extends Node> newGameObject =
                    template.duplicate(objectLoader, listenerLoader, this, this.scene.objects);
            newGameObject.init();
            newGameObject.move(x * screenSize.width, y * screenSize.height);
            scene.objects.add(newGameObject);
            scene.listeners.addAll(newGameObject.attachedListeners);
            scene.gamePane.getChildren().add(newGameObject.node);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating object " + template.getName(), e);
        }
    }

    public void destroyGameObject(GameObject<?> object) {
        for (GameListener listener : object.attachedListeners) {
            scene.listeners.remove(listener);
        }
        scene.objects.remove(object);
    }

    public void init() {
        if (!initialized) {
            for (GameListener listener : scene.listeners) {
                listener.startup(this);
            }
        } else {
            throw new IllegalStateException("state already initialized");
        }
    }
}
