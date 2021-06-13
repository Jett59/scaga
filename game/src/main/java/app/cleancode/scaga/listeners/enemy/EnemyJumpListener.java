package app.cleancode.scaga.listeners.enemy;

import app.cleancode.scaga.collisions.Collidable;
import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;

@AttachedTo("enemy")
public class EnemyJumpListener extends GameListener {
    private static final double SPEED = 0.7;

    @ImportGameObject
    public GameObject<?> enemy;

    @Override
    public void update(State state) {

    }

    @Override
    public void startup(State state) {

    }

    @Override
    public void onCollision(Collidable other) {
        if (enemy.isTouchingGround && !other.toString().equals("ground") && !other.toString().equals("player")) {
            enemy.yVelocity = SPEED * -1;
        }
    }

}
