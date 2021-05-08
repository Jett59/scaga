package app.cleancode.scaga.engine;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {
private Runnable tick;
public GameLoop(Runnable tick) {
	this.tick = tick;
}

private long previousFrame;

@Override
public void handle(long now) {
	double frameDuration = (now - previousFrame) / 1000000000d;
	previousFrame = now;
	int fps = (int) Math.round(1d / frameDuration);
	System.out.println(fps);
	tick.run();
}
}
