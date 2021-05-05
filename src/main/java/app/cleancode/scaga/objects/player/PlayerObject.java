package app.cleancode.scaga.objects.player;

import app.cleancode.scaga.animation.Animation;
import app.cleancode.scaga.animation.AnimationBuilder;
import app.cleancode.scaga.characters.Character;
import app.cleancode.scaga.engine.GameObject;
import javafx.scene.Node;
import javafx.util.Duration;

public class PlayerObject extends GameObject<Character> {
private AnimationBuilder animationBuilder;

public PlayerObject() {
	animationBuilder = new AnimationBuilder ();
	mass = Math.E;
}

@Override
public String getName() {
	return "player";
}

@Override
public void init() {
	node = new Character("Samurai");
}
}
