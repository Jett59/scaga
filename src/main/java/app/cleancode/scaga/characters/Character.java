package app.cleancode.scaga.characters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.cleancode.scaga.animation.Animation;
import app.cleancode.scaga.animation.AnimationBuilder;
import app.cleancode.scaga.animation.AnimationConfig;
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
	try {
		config = objectMapper.readValue(resourceReader.getResourceAsString(String.format("/config/characters/%s.json", characterName)), CharacterConfig.class);
	}catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException ("Error creating config for character "+characterName, e);
	}
	AnimationBuilder animationBuilder = new AnimationBuilder();
	for (AnimationConfig animation : config.getAnimations()) {
		animation.setReversed(false);
		Animation builtAnimation = animationBuilder.buildAnimation(animation);
		animations.put(animation.getAnimation() + ".right", builtAnimation);
		animation.setReversed(true);
		builtAnimation = animationBuilder.buildAnimation(animation);
		animations.put(animation.getAnimation() + ".left", builtAnimation);
	}
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
