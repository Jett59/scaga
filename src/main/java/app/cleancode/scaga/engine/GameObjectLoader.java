package app.cleancode.scaga.engine;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.cleancode.scaga.characters.CharacterGameObject;
import app.cleancode.scaga.engine.config.GameObjectConfig;
import app.cleancode.scaga.resources.ResourceReader;
import javafx.scene.Node;

public class GameObjectLoader {
	private static final String GAME_OBJECT_PATH_FORMAT = "/objects/%s.json";
private final ObjectMapper mapper;
private final ResourceReader resourceReader;

public GameObjectLoader() {
	mapper = new ObjectMapper();
	resourceReader = new ResourceReader();
}

public GameObject<? extends Node> loadGameObject (String name) {
	GameObject<? extends Node> result;
	String path = String.format(GAME_OBJECT_PATH_FORMAT, name);
	try {
		String json = resourceReader.getResourceAsString(path);
		GameObjectConfig config = mapper.readValue(json, GameObjectConfig.class);
		switch (config.getType()) {
		case CHARACTER: {
			result = new CharacterGameObject(config);
			break;
		}
		default:
			throw new IllegalStateException("game object type " + config.getType().name() + "is not known");
		}
	}catch (Exception e) {
		throw new RuntimeException (e);
	}
	return result;
}
}
