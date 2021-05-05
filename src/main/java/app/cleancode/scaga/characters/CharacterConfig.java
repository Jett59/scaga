package app.cleancode.scaga.characters;

import app.cleancode.scaga.animation.AnimationConfig;

public class CharacterConfig {
public final String name;
private AnimationConfig [] animations;

public CharacterConfig(String name) {
	this.name = name;
}

public AnimationConfig [] getAnimations() {
	return animations;
}

public void setAnimations(AnimationConfig [] animations) {
	this.animations = animations;
}
}
