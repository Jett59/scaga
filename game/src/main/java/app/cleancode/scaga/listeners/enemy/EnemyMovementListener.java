package app.cleancode.scaga.listeners.enemy;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;

@AttachedTo("enemy")
public class EnemyMovementListener extends GameListener {
    private static final double SPEED = 0.2;

    @ImportGameObject
    public GameObject<?> enemy;

    @ImportGameObject
    public GameObject<?> player;

    @ImportGameProperty(owner = "enemy")
    public GameProperty health;

    @Override
    public void update(State state) {
        var playerBounds = player.getRegion().getTransformedBound();
        var barrelBounds = enemy.getRegion().getTransformedBound();
        if (playerBounds.getMaxX() < barrelBounds.getCenterX()) {
            enemy.xVelocity = SPEED * -1;
        } else if (playerBounds.getMinX() > barrelBounds.getCenterX()) {
            enemy.xVelocity = SPEED;
        }
        if (health.getDouble() <= 0.5d) {
            enemy.xVelocity *= -1;
        }
    }

    @Override
    public void startup(State state) {

    }

}
