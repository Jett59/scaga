package app.cleancode.scaga.animation;

import javafx.util.Duration;

public class AnimationConfig {
private String character, animation;
private int frames;
private Duration duration;
private int height;
private boolean reversed;

public String getCharacter() {
	return character;
}
public void setCharacter(String character) {
	this.character = character;
}
public String getAnimation() {
	return animation;
}
public void setAnimation(String animation) {
	this.animation = animation;
}
public int getFrames() {
	return frames;
}
public void setFrames(int frames) {
	this.frames = frames;
}
public Duration getDuration() {
	return duration;
}
public void setDuration(Duration duration) {
	this.duration = duration;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public boolean getReversed() {
	return reversed;
}
public void setReversed(boolean reversed) {
	this.reversed = reversed;
}
}
