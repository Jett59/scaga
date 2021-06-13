package app.cleancode.scaga.characters.state;

public enum State {
    ATTACKING("Attack"), DIEING("Die"), IDLE("Idle"), JUMPING("Jump"), RUNNING("Run");

    private String id;

    private State(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
