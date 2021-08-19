package app.cleancode.scaga.listeners.enemy;

import app.cleancode.scaga.bounds.Bound;
import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;

@AttachedTo("enemy")
public class DamageDealer extends GameListener {
    private static final double DAMAGE_AMOUNT = 0.003;

    @ImportGameObject
    public GameObject<?> enemy;

    @ImportGameObject
    public GameObject<?> player;

    @ImportGameProperty(owner = "enemy")
    public GameProperty health;

    @ImportGameProperty(owner = "player")
    public GameProperty attacking;

    @Override
    public void update(State state) {

    }

    @Override
    public void startup(State state) {

    }

    @Override
    public void onCollision(Collidable other, Bound collisionBound) {
        if (other.toString().equals("player")) {
            if (attacking.getBoolean()) {
                health.set(health.getDouble() - DAMAGE_AMOUNT);
            }
        }
    }

}
