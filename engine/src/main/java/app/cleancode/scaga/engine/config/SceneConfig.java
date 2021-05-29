package app.cleancode.scaga.engine.config;

public class SceneConfig {
private String [] listeners;
private String[] foreground;
private String [] canvas;

public String [] getListeners() {
	return listeners;
}
public void setListeners(String [] listeners) {
	this.listeners = listeners;
}
public String[] getForeground() {
	return foreground;
}
public void setForeground(String[] foreground) {
	this.foreground = foreground;
}
public String [] getCanvas() {
	return canvas;
}
public void setCanvas(String [] canvas) {
	this.canvas = canvas;
}

}
