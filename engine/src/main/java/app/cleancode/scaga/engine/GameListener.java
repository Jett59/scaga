package app.cleancode.scaga.engine;

import app.cleancode.scaga.collisions.Collidable;

public abstract class GameListener {
    public abstract void update(State state);

    public abstract void startup(State state);

    public void onCollision(Collidable other) {
    }
}
