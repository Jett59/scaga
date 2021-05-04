package app.cleancode.scaga;

import app.cleancode.scaga.engine.GameListener;
import app.cleancode.scaga.engine.GameLoop;
import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import app.cleancode.scaga.engine.physics.Gravity;
import app.cleancode.scaga.engine.physics.Movement;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameStart extends Application {
	private static GameListener[] gameListeners = new GameListener[] {
			
	};
	@SuppressWarnings("unchecked")
	private static GameObject<Node> [] gameObjects = new GameObject[] {
			
	};
	private static PhysicalLaw[] laws = new PhysicalLaw[] {
			new Movement(),
			new Gravity()
	};
public static void begin(String[] args) {
	launch(args);
}
private Pane nodes = new Pane();
 private Pane gamePane = new Pane();
@SuppressWarnings("exports")
@Override
public void start(Stage primaryStage) throws Exception {
	Scene scene = new Scene(gamePane);
	scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
	nodes.getChildren().add(new Text("Loading"));
	primaryStage.setTitle("Game");
	primaryStage.setFullScreen(true);
	primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
	primaryStage.setScene(new Scene(nodes));
	primaryStage.show();
	for(GameObject<Node> gameObject : gameObjects) {
		gameObject.addNode = this::addNode;
		addNode(gameObject.node);
	}
	for(GameListener listener : gameListeners) {
		for(String gameObjectName : listener.getGameObjects()) {
			for(GameObject<Node> gameObject : gameObjects) {
				if(gameObject.getName().equalsIgnoreCase(gameObjectName)) {
					try {
						var gameObjectField = listener.getClass().getDeclaredField(gameObjectName);
						gameObjectField.set(listener, gameObject);
						break;
					}catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
		listener.startup();
	}
	scene.setFill(Color.BLACK);
	primaryStage.setScene(scene);
	primaryStage.setFullScreen(true);
	GameLoop loop = new GameLoop(this::tick);
	loop.start();
}
public void tick() {
	for(GameListener gameListener : gameListeners) {
		gameListener.update();
	}
	for(PhysicalLaw law : laws) {
		for(GameObject<Node> gameObject : gameObjects) {
			law.handle(gameObject);
		}
	}
}
@SuppressWarnings("exports")
public void addNode(Node node) {
	gamePane.getChildren().add(node);
}
}
