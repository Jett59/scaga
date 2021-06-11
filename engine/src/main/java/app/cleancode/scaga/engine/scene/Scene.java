package app.cleancode.scaga.engine.scene;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class Scene {
    public final List<GameListener> listeners;
    public final List<GameObject<? extends Node>> objects;
    public final Pane gamePane;

    public Scene(List<GameObject<? extends Node>> objects, List<GameListener> listeners, Pane gamePane) {
        this.listeners = new CopyOnWriteArrayList<>(listeners);
        this.objects = new CopyOnWriteArrayList<>(objects);
        this.gamePane = gamePane;

    }
}
