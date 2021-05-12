package app.cleancode.scaga.listeners.barrel;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;

@AttachedTo("barrel")
public class BarrelDestructionListener extends GameListener {
private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	@ImportGameObject
	public GameObject<?> barrel;

	@Override
	public void update(State state) {
		if (barrel.getRegion().getBoundsInParent().getMinY() > screenSize.height) {
			state.destroyGameObject(barrel);
		}
	}

	@Override
	public void startup(State state) {
		
	}

}
