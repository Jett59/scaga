package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.bounds.Bound;
import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;

@AttachedTo("player")
public class DamageDealer extends GameListener {
    private static double ATTACK_AMOUNT = 0.002;

    @ImportGameProperty(owner = "player")
    public GameProperty health;

    @Override
    public void update(State state) {

    }

    @Override
    public void startup(State state) {

    }

    @Override
    public void onCollision(Collidable other, Bound collisionBound) {
        if (other.toString().equals("enemy")) {
            System.out.println(((GameObject<?>) other).getProperty("attacking").hashCode());
            if (((GameObject<?>) other).getProperty("attacking").getBoolean()) {
                health.set(health.getDouble() - ATTACK_AMOUNT);
            }
        }
    }

}
