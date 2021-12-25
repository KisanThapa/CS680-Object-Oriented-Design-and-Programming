package edu.umb.cs680.hw06;

public class DVDPlayer {
    private static DVDPlayer instance;

    private State state;

    private DVDPlayer() {
    }

    public static DVDPlayer getInstance() {
        if (instance == null) {
            instance = new DVDPlayer();
        }
        return instance;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void openCloseButtonPushed() {
        state.openCloseButtonPushed();
    }

    public void playButtonPushed() {
        state.playButtonPushed();
    }

    public void stopButtonPushed() {
        state.stopButtonPushed();
    }

    public void open() {
        System.out.println("DVD Drawer Opened!");
    }

    public void close() {
        System.out.println("DVD Drawer Closed!");
    }

    public void play() {
        System.out.println("DVD is Playing!");
    }

    public void stop() {
        System.out.println("DVD is Stopped!");
    }
}
