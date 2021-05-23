package app.cleancode.scaga.listeners.enemy;

import java.awt.Dimension;
import java.awt.Toolkit;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;

@AttachedTo("enemy")
public class EnemyDestructionListener extends GameListener {
private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	@ImportGameObject
	public GameObject<?> enemy;

	@Override
	public void update(State state) {
		if (enemy.getRegion().getBoundsInParent().getMinY() > screenSize.height) {
			state.destroyGameObject(enemy);
		}
	}

	@Override
	public void startup(State state) {
		
	}

}
