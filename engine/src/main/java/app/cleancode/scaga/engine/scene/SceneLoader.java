package app.cleancode.scaga.engine.scene;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameListenerLoader;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameObjectLoader;
import app.cleancode.scaga.engine.config.SceneConfig;
import app.cleancode.scaga.resources.ResourceReader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class SceneLoader {
	private final ResourceReader resourceReader;
	private final ObjectMapper jsonParser;

	public SceneLoader() {
		this.resourceReader = new ResourceReader();
		this.jsonParser = new ObjectMapper();
	}

@SuppressWarnings("unchecked")
public Scene getScene (String configPath) {
	try {
		SceneConfig config = jsonParser.readValue(resourceReader.getResourceAsString(configPath), SceneConfig.class);
		GameObjectLoader gameObjectLoader = new GameObjectLoader();
		GameListenerLoader gameListenerLoader = new GameListenerLoader();
		
		Pane gamePane = new Pane();
		List<GameObject<? extends Node>> objects = new ArrayList<>();
		List<GameListener> listeners = new ArrayList<>();
		for (String object : config.getObjects()) {
			GameObject<? extends Node> gameObject = gameObjectLoader.loadGameObject(object);
			gameObject.init();
			objects.add(gameObject);
			gamePane.getChildren().add(gameObject.node);
		}
		GameObject<? extends Node> [] gameObjectArray = objects.toArray(new GameObject [] {});
		for (String listener : config.getListeners()) {
			GameListener gameListener = (GameListener) Class.forName(listener).getConstructor().newInstance();
			gameListenerLoader.prepareListener(gameListener, gameObjectArray);
			listeners.add(gameListener);
		}
		return new Scene(objects, listeners, gamePane);
	}catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException ("Error initializing scene", e);
	}
}
}