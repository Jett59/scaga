package app.cleancode.scaga.listeners.enemy;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;

@AttachedTo("enemy")
public class Healer extends GameListener {
    private static double HEAL_AMOUNT = 0.0005d;

    @ImportGameObject
    public GameObject<?> enemy;

    @ImportGameProperty(owner = "enemy")
    public GameProperty health;
    @ImportGameProperty(owner = "enemy")
    public GameProperty attacking;

    @Override
    public void update(State state) {
        if (!attacking.getBoolean() && health.getDouble() < 0.5d) {
            health.set(health.getDouble() + HEAL_AMOUNT);
        }
    }

    @Override
    public void startup(State state) {

    }

}
