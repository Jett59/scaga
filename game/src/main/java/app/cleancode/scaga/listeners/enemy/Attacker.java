package app.cleancode.scaga.listeners.enemy;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;

@AttachedTo("enemy")
public class Attacker extends GameListener {

    @ImportGameObject
    public GameObject<?> enemy;

    public GameProperty attacking;

    @Override
    public void update(State state) {
        if (enemy.xVelocity == 0) {
            attacking.set(true);
        } else {
            attacking.set(false);
        }
    }

    @Override
    public void startup(State state) {
        attacking = enemy.getProperty("attacking");
        attacking.set(false);
    }

}
