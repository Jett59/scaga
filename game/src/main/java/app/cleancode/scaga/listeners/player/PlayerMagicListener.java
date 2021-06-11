package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;
import app.cleancode.scaga.engine.events.ProgressUpdateEvent;

@AttachedTo("player")
public class PlayerMagicListener extends GameListener {

    @ImportGameObject
    public GameObject<?> magicBar;

    @ImportGameProperty(owner = "player")
    public GameProperty magic;

    @Override
    public void update(State state) {
        magicBar.handleEvent(new ProgressUpdateEvent(magic.getDouble()));
    }

    @Override
    public void startup(State state) {
        magic.set(1d);
    }

}
