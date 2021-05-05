package app.cleancode.scaga.characters;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.cleancode.scaga.animation.Animation;
import app.cleancode.scaga.resources.ResourceReader;

public class Character {
private final Map<String, Animation> animations;
private final ResourceReader resourceReader;
private final ObjectMapper objectMapper;
private CharacterConfig config;

public Character(String characterName) {
	animations = new HashMap<>();
	resourceReader = new ResourceReader();
	objectMapper = new ObjectMapper();
	
	
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
