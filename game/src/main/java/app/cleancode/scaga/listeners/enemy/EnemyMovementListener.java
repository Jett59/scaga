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
        var enemyBounds = enemy.getRegion().getTransformedBound();
        if (playerBounds.getMaxX() < enemyBounds.getCenterX()) {
            enemy.xVelocity = SPEED * -1;
        } else if (playerBounds.getMinX() > enemyBounds.getCenterX()) {
            enemy.xVelocity = SPEED;
        }
        if (health.getDouble() <= 0.5d) {
            enemy.xVelocity *= -1;
            if (enemy.xVelocity == 0) {
                double deltaX = enemyBounds.getCenterX() - playerBounds.getCenterX();
                enemy.xVelocity = Math.copySign(SPEED, deltaX);
            }
            if (enemy.xVelocity == 0) {
                enemy.xVelocity = SPEED;
            }
        }
    }

    @Override
    public void startup(State state) {

    }

}
