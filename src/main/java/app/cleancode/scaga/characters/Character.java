package app.cleancode.scaga.characters;

import java.util.HashMap;
import java.util.Map;

import app.cleancode.scaga.animation.Animation;

public class Character {
private final Map<String, Animation> animations;

public Character(String characterName) {
	animations = new HashMap<>();
}

public static enum State {
	ATTACKING ("Attack"),
	DIEING ("Die"),
	IDLE ("Idle"),
	JUMPING ("Jump"),
	RUNNING ("Run");
	private String id;
	
	private State(String id) {
		this.id = id;
	}
	
	public String getId () {
		return id;
	}
}
}
