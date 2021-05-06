package app.cleancode.scaga.engine;

public abstract class GameListener {
	public abstract void update(State state);
	public abstract void startup(State state);
}
