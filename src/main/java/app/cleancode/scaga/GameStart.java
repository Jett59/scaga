package app.cleancode.scaga;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameListenerLoader;
import app.cleancode.scaga.engine.GameLoop;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.GameObjectLoader;
import app.cleancode.scaga.engine.PhysicalLaw;
import app.cleancode.scaga.engine.State;
import app.cleancode.scaga.engine.camera.CameraManager;
import app.cleancode.scaga.engine.keyboard.KeyState;
import app.cleancode.scaga.engine.keyboard.KeyboardManager;
import app.cleancode.scaga.engine.physics.Collisions;
import app.cleancode.scaga.engine.physics.Drag;
import app.cleancode.scaga.engine.physics.Gravity;
import app.cleancode.scaga.engine.physics.Movement;
import app.cleancode.scaga.listeners.player.PlayerJumpListener;
import app.cleancode.scaga.listeners.player.PlayerMovementListener;
import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameStart extends Application {
	private static GameListener[] gameListeners = new GameListener[] {
			new PlayerMovementListener(),
			new PlayerJumpListener()
	};
	private static String [] gameObjectNames = new String [] {
			"player",
			"ground"
	};
	private static PhysicalLaw[] laws = new PhysicalLaw[] {
			new Movement(),
			new Collisions(),
			new Gravity(),
			new Drag()
	};
public static void begin(String[] args) {
	launch(args);
}
private Pane nodes = new Pane();
 private Pane gamePane = new Pane();
 private GameObject<? extends Node> cameraFocus;
 private CameraManager cameraManager;
 private KeyState keyState;
 
 private State state;
 
 private GameObject<? extends Node> [] gameObjects;
 
@SuppressWarnings({ "exports", "unchecked" })
@Override
public void start(Stage primaryStage) throws Exception {
	gameObjects = new GameObject [gameObjectNames.length];
	Scene scene = new Scene(gamePane);
	scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
	nodes.getChildren().add(new Text("Loading"));
	primaryStage.setTitle("Game");
	primaryStage.setFullScreen(true);
	primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
	primaryStage.setScene(new Scene(nodes));
	primaryStage.show();
	Camera camera = new PerspectiveCamera();
	cameraManager = new CameraManager(camera);
	keyState = new KeyState();
	state = new State(keyState);
	new KeyboardManager(keyState).bind(primaryStage);
	
	GameObjectLoader gameObjectLoader = new GameObjectLoader();
	for(int i = 0; i < gameObjectNames.length; i++) {
		String gameObjectName = gameObjectNames [i];
		GameObject <? extends Node> gameObject = gameObjectLoader.loadGameObject(gameObjectName);
		gameObjects [i] = gameObject;
		gameObject.addNode = this::addNode;
		gameObject.init ();
		addNode(gameObject.node);
		if (gameObject.wantsCameraFocus()) {
			cameraFocus = gameObject;
		}
	}
	GameListenerLoader listenerLoader = new GameListenerLoader();
	for(GameListener listener : gameListeners) {
		listenerLoader.prepareListener(listener, gameObjects);
		listener.startup(state);
	}
	scene.setFill(Color.BLUE);
	scene.setCamera(camera);
	primaryStage.setScene(scene);
	primaryStage.setFullScreen(true);
	GameLoop loop = new GameLoop(this::tick);
	loop.start();
}
@SuppressWarnings("unchecked")
public void tick() {
	for(GameListener gameListener : gameListeners) {
		gameListener.update(state);
	}
	for (GameObject<? extends Node> object : gameObjects) {
		object.isTouchingGround = false;
	}
	for(PhysicalLaw law : laws) {
		for(GameObject<? extends Node> gameObject : gameObjects) {
			law.handle((GameObject<Node>) gameObject);
		}
	}
	if (cameraFocus != null) {
		cameraManager.update(cameraFocus);
	}
}
@SuppressWarnings("exports")
public void addNode(Node node) {
	gamePane.getChildren().add(node);
}
}
