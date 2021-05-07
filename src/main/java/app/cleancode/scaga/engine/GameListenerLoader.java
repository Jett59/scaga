package app.cleancode.scaga.engine;

import java.lang.reflect.Field;

import app.cleancode.scaga.engine.annotations.AttachedTo;
import app.cleancode.scaga.engine.annotations.ImportGameObject;
import javafx.scene.Node;

public class GameListenerLoader {
public void prepareListener (GameListener listener, GameObject<Node> [] objects) {
	try {
		Class<? extends GameListener> claz = listener.getClass();
		if (claz.isAnnotationPresent(AttachedTo.class)) {
			String objectName = claz.getAnnotation(AttachedTo.class).value();
			for (GameObject<Node> object : objects) {
				if (object.getName().equalsIgnoreCase(objectName)) {
					object.attachListener(listener);
					break;
				}
			}
		}
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
	String annotationParam = field.getDeclaredAnnotation(ImportGameObject.class).bvalue();
	return annotationParam.isEmpty() ? field.getName() : annotationParam;
}
}
