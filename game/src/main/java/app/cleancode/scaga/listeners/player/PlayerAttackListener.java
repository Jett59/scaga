package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;
import app.cleancode.scaga.engine.events.AttackEvent;
import app.cleancode.scaga.engine.events.StopEvent;
import app.cleancode.scaga.engine.keyboard.KeyBindings;

@AttachedTo("player")
public class PlayerAttackListener extends GameListener {

    @ImportGameObject
    public GameObject<?> player;

    @ImportGameProperty(owner = "player")
    public GameProperty attacking;

    @Override
    public void update(State state) {
        if (state.keyState.isKeyDown(KeyBindings.forName("q")) && player.xVelocity == 0) {
            attacking.set(true);
            player.handleEvent(new AttackEvent());
        } else if (attacking.getBoolean()) {
            player.handleEvent(new StopEvent());
            attacking.set(false);
        }
    }

    @Override
    public void startup(State state) {
        attacking.set(false);
    }

}
