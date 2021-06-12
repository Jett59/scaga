package app.cleancode.scaga.engine.physics;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import app.cleancode.scaga.engine.GameObject;
import app.cleancode.scaga.engine.PhysicalLaw;
import app.cleancode.scaga.engine.events.StopEvent;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.shape.Shape;

public class Movement extends PhysicalLaw {
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private final Map<GameObject<? extends Node>, Long> lastMovementTimes;
    private Collisions collider;

    public Movement() {
        lastMovementTimes = new HashMap<>();
        collider = new Collisions();
    }

    @Override
    public void handle(GameObject<?> obj) {
        if (obj.xVelocity != 0 || obj.yVelocity != 0) {
            if (lastMovementTimes.containsKey(obj)) {
                long lastMovementTime = lastMovementTimes.get(obj);
                long currentTime = System.nanoTime();
                long delta = currentTime - lastMovementTime;
                double xMoveAmount = delta / 1000000000d * obj.xVelocity * screenSize.width;
                double yMoveAmount = delta / 1000000000d * obj.yVelocity * screenSize.height;
                double origX = obj.getX(), origY = obj.getY();
                obj.move(origX + xMoveAmount, origY + yMoveAmount);
                if (obj.collidable) {
                    Shape intersection = collider.check(obj);
                    Bounds intersectionBounds = intersection.getBoundsInLocal();
                    for (int i = 0; i < 4
                            && !(intersectionBounds = (intersection = collider.check(obj)).getBoundsInLocal())
                                    .isEmpty(); i++) {
                        if (intersectionBounds.getWidth() > intersectionBounds.getHeight()) {
                            if (yMoveAmount < 0) {
                                yMoveAmount += intersectionBounds.getHeight();
                            } else if (yMoveAmount > 0) {
                                yMoveAmount -= intersectionBounds.getHeight();
                                obj.isTouchingGround = true;
                            } else {
                                if (intersection.getBoundsInParent().getCenterY() < obj.getRegion()
                                        .getTransformedBound().getCenterY()) {
                                    yMoveAmount = intersectionBounds.getHeight() * -1;
                                    obj.isTouchingGround = true;
                                } else {
                                    yMoveAmount = intersectionBounds.getHeight();
                                }
                            }
                            obj.yVelocity = 0;
                        } else {
                            if (xMoveAmount < 0) {
                                xMoveAmount += intersectionBounds.getWidth();
                            } else if (xMoveAmount > 0) {
                                xMoveAmount -= intersectionBounds.getWidth();
                            } else {
                                if (intersection.getBoundsInParent().getCenterX() < obj.getRegion()
                                        .getTransformedBound().getCenterX()) {
                                    xMoveAmount = intersectionBounds.getWidth() * -1;
                                } else {
                                    xMoveAmount = intersectionBounds.getWidth();
                                }
                            }
                            obj.xVelocity = 0;
                            obj.handleEvent(new StopEvent());
                        }
                        obj.move(origX + xMoveAmount, origY + yMoveAmount);
                    }
                    if (!collider.check(obj).getBoundsInLocal().isEmpty()) {
                        obj.move(origX, origY);
                    }
                }
            }
        }
        lastMovementTimes.put(obj, System.nanoTime());
        if (obj.collidable) {
            collider.registerObject(obj);
        }
    }

}
