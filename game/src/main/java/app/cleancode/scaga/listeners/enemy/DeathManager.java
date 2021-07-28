package app.cleancode.scaga.listeners.enemy;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;

@AttachedTo("enemy")
public class DeathManager extends GameListener {

    public GameProperty health;

    @ImportGameObject
    public GameObject<?> enemy;

    @ImportGameProperty(owner = "player")
    public GameProperty magic;

    @Override
    public void update(State state) {
        if (health.getDouble() <= 0) {
            state.destroyGameObject(enemy);
            magic.set(Math.min(magic.getDouble() + 0.25d, 1d));
        }
    }

    @Override
    public void startup(State state) {
        health = enemy.getProperty("health");
        health.set((double) 1);
    }

}
