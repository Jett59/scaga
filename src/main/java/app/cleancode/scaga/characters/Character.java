package app.cleancode.scaga.characters;

import java.util.Map;

import app.cleancode.scaga.animation.Animation;

public class Character {
private final Map<String, Animation> animations;
private final State [] possibleStates;

public Character(String characterName, int defaultCellCount, State ... possibleStates) {
	this.animations = animations;
	this.possibleStates = possibleStates;
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
