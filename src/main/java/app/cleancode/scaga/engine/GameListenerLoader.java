package app.cleancode.scaga.engine;

import java.lang.reflect.Field;

import app.cleancode.scaga.engine.annotations.ImportGameObject;
import javafx.scene.Node;

public class GameListenerLoader {
public void prepareListener (GameListener listener, GameObject<Node> [] objects) {
	try {
		Class<? extends GameListener> claz = listener.getClass();
		for (Field field : claz.getDeclaredFields()) {
			if (field.isAnnotationPresent(ImportGameObject.class)) {
				field.setAccessible(true);
				String objectName = getObjectName (field);
				for (GameObject<Node> object : objects) {
					if (object.getName().equalsIgnoreCase(objectName)) {
						field.set(listener, object);
						break;
					}
				}
			}
		}
	}catch (Exception e) {
		throw new RuntimeException (e);
	}
}
private String getObjectName (Field field) throws Exception {
	String annotationParam = field.getDeclaredAnnotation(ImportGameObject.class).objectName();
	return annotationParam.isEmpty() ? field.getName() : annotationParam;
}
}
