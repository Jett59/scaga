package app.cleancode.scaga.listeners.enemy;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;

@AttachedTo("enemy")
public class EnemyMovementListener extends GameListener {
    private static final double SPEED = 0.1;

    @ImportGameObject
    public GameObject<?> enemy;

    @ImportGameObject
    public GameObject<?> player;

    @Override
    public void update(State state) {
        var playerBounds = player.getRegion().getTransformedBound();
        var barrelBounds = enemy.getRegion().getTransformedBound();
        if (playerBounds.getCenterX() < barrelBounds.getCenterX()) {
            enemy.xVelocity = SPEED * -1;
        } else if (playerBounds.getCenterX() > barrelBounds.getCenterX()) {
            enemy.xVelocity = SPEED;
        }
    }

    @Override
    public void startup(State state) {

    }

}
