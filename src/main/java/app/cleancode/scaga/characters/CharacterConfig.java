package app.cleancode.scaga.characters;

import app.cleancode.scaga.animation.AnimationConfig;

public class CharacterConfig {
private AnimationConfig [] animations;

public AnimationConfig [] getAnimations() {
	return animations;
}

public void setAnimations(AnimationConfig [] animations) {
	this.animations = animations;
}
}
