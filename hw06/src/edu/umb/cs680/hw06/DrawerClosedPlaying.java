package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State {

    private static DrawerClosedPlaying instance;
    private DVDPlayer player = DVDPlayer.getInstance();

    private DrawerClosedPlaying() {
    }

    public static DrawerClosedPlaying getInstance() {
        if (instance == null) {
            instance = new DrawerClosedPlaying();
        }
        return instance;
    }

    @Override
    public void openCloseButtonPushed() {
        player.stop();
        player.open();
        player.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        // Do Nothing
    }

    @Override
    public void stopButtonPushed() {
        player.stop();
        player.changeState(DrawerClosedNotPlaying.getInstance());
    }
}
