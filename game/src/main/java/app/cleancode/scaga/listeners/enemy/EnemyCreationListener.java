package app.cleancode.scaga.listeners.enemy;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.keyboard.KeyBindings;

public class EnemyCreationListener extends GameListener {
    private boolean keyState;

    @ImportGameObject
    public GameObject<?> enemy;

    @Override
    public void update(State state) {
        if (state.keyState.isKeyDown(KeyBindings.forName("b"))) {
            if (!keyState) {
                state.createGameObject(enemy, Math.random(), 0.1);
                keyState = true;
            }
        } else {
            keyState = false;
        }
    }

    @Override
    public void startup(State state) {

    }

}
