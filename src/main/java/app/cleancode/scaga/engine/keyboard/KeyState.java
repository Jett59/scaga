package app.cleancode.scaga.engine.keyboard;

import java.util.HashMap;
import java.util.Map;

public class KeyState {
final Map<Key, KeyStatus> keyState;

public KeyState() {
	this.keyState = new HashMap<>();
}
}
