package app.cleancode.scaga.engine;

public class GameProperty {
private Object value;
@SuppressWarnings("unchecked")
public <T> T get () {
	return (T) value;
}
public void set (Object value) {
	this.value = value;
}
}
