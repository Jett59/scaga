module app.cleancode.scaga {
	exports app.cleancode.scaga;
	exports app.cleancode.scaga.engine;
	exports app.cleancode.scaga.engine.events;
exports app.cleancode.scaga.collisions;
exports app.cleancode.scaga.engine.keyboard;
exports app.cleancode.scaga.engine.annotations;

exports app.cleancode.scaga.characters to com.fasterxml.jackson.databind;
exports app.cleancode.scaga.engine.config to com.fasterxml.jackson.databind;
exports app.cleancode.scaga.animation to com.fasterxml.jackson.databind;

requires transitive javafx.graphics;
	requires javafx.swing;
	requires com.fasterxml.jackson.databind;	
}