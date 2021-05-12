package app.cleancode.scaga.engine.keyboard;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class KeyboardManager implements EventHandler<KeyEvent> {
private final KeyState keyState;

public KeyboardManager(KeyState keyState) {
	this.keyState = keyState;
}

public void bind (Stage stage) {
	stage.addEventHandler(KeyEvent.KEY_PRESSED, this);
	stage.addEventHandler(KeyEvent.KEY_RELEASED, this);
}

@Override
public void handle(KeyEvent event) {
	if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
		keyPressed (event.getCode());
	}else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) {
		keyReleased (event.getCode());
	}
}
private void keyPressed (KeyCode code) {
	updateKeyState(code, true);
}
private void keyReleased (KeyCode code) {
	updateKeyState(code, false);
}
private void updateKeyState (KeyCode code, boolean newState) {
	switch (code) {
	case LEFT: {
		keyState.keyState.get(Key.LEFT).down = newState;
		break;
	}
	case RIGHT: {
		keyState.keyState.get(Key.RIGHT).down = newState;
		break;
	}
	case UP: {
		keyState.keyState.get(Key.UP).down = newState;
		break;
	}
	case DOWN: {
		keyState.keyState.get(Key.DOWN).down = newState;
		break;
	}
	case W: {
		keyState.keyState.get(Key.W).down = newState;
		break;
	}
	case A: {
		keyState.keyState.get(Key.A).down = newState;
		break;
	}
	case S: {
		keyState.keyState.get(Key.S).down = newState;
		break;
	}
	case D: {
		keyState.keyState.get(Key.D).down = newState;
		break;
	}
	case SPACE: {
		keyState.keyState.get(Key.SPACE).down = newState;
		break;
	}
	case B: {
		keyState.keyState.get(Key.B).down = newState;
		break;
	}
	default:
		break;
	}
}
}
