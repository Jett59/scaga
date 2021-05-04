package app.cleancode.scaga.objects.player;

import app.cleancode.scaga.animation.Animation;
import app.cleancode.scaga.animation.AnimationBuilder;
import app.cleancode.scaga.engine.GameObject;
import javafx.scene.Node;
import javafx.util.Duration;

public class PlayerObject extends GameObject<Node> {
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
	Animation idle = animationBuilder.buildAnimation("Samurai", "Idle", 8, Duration.seconds (1), 250, true);
	idle.play ();
	node = idle.getView();
}
}
