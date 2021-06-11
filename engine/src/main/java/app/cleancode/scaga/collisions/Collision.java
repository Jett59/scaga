package app.cleancode.scaga.collisions;

import javafx.scene.shape.Shape;

public class Collision {
    public final Shape intersectionRegion;
    public final Collidable other;

    public Collision(Collidable other, Shape intersectionRegion) {
        this.intersectionRegion = intersectionRegion;
        this.other = other;

    }
}
