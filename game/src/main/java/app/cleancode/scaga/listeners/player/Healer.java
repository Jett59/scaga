package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;
import app.cleancode.scaga.engine.keyboard.KeyBindings;

@AttachedTo("player")
public class Healer extends GameListener {

    @ImportGameObject
    public GameObject<?> player;

    @ImportGameProperty(owner = "player")
    public GameProperty health;

    @ImportGameProperty(owner = "player")
    public GameProperty magic;

    @Override
    public void update(State state) {
        if (state.keyState.isKeyDown(KeyBindings.forName("h"))) {
            double healAmount = Math.min(magic.getDouble() * 2, DamageDealer.ATTACK_AMOUNT);
            health.set(health.getDouble() + healAmount);
            magic.set(magic.getDouble() - healAmount / 2d);
        }
    }

    @Override
    public void startup(State state) {}

}
