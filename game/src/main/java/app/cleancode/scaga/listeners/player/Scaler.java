package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.keyboard.KeyBindings;

@AttachedTo("player")
public class Scaler extends GameListener {

    @ImportGameObject
    public GameObject<?> player;

    @Override
    public void update(State state) {
        if (state.keyState.isKeyDown(KeyBindings.forName("s"))) {
            player.setScale(Math.max(player.getScale() - 0.001, 0.5));
        }
        if (state.keyState.isKeyDown(KeyBindings.forName("d"))) {
            player.setScale(Math.min(player.getScale() + 0.001, 2));
        }
    }

    @Override
    public void startup(State state) {

    }

}
