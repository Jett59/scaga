package app.cleancode.scaga.engine.config;

public class GameObjectConfig {
	private GameObjectType type;
private String baseClass;
private String name;
private String characterName;
private String spriteName;
private double x, y, width, height;
private double mass;
private double drag;

public String getBaseClass() {
	return baseClass;
}
public void setBaseClass(String baseClass) {
	this.baseClass = baseClass;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCharacterName() {
	return characterName;
}
public void setCharacterName(String characterName) {
	this.characterName = characterName;
}
public double getX() {
	return x;
}
public void setX(double x) {
	this.x = x;
}
public double getY() {
	return y;
}
public void setY(double y) {
	this.y = y;
}
public double getWidth() {
	return width;
}
public void setWidth(double width) {
	this.width = width;
}
public double getHeight() {
	return height;
}
public void setHeight(double height) {
	this.height = height;
}
public GameObjectType getType() {
	return type;
}
public void setType(GameObjectType type) {
	this.type = type;
}
public double getMass() {
	return mass;
}
public void setMass(double mass) {
	this.mass = mass;
}
public double getDrag() {
	return drag;
}
public void setDrag(double drag) {
	this.drag = drag;
}
public String getSpriteName() {
	return spriteName;
}
public void setSpriteName(String spriteName) {
	this.spriteName = spriteName;
}

}
