package app.cleancode.scaga.listeners.player;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameProperty;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import app.cleancode.scaga.engine.annotations.ImportGameProperty;
import java.awt.Dimension;
import java.awt.Toolkit;

@AttachedTo("player")
public class DeathManager extends GameListener {
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    @ImportGameObject
    public GameObject<?> player;

    @ImportGameProperty(owner = "player")
    public GameProperty health;

    @ImportGameProperty(owner = "player")
    public GameProperty magic;

    @Override
    public void update(State state) {
        if (health.getDouble() <= 0) {
            player.move(screenSize.width / 2d, 0);
            health.set(1d);
            magic.set(1d);
        }
    }

    @Override
    public void startup(State state) {

    }

}
