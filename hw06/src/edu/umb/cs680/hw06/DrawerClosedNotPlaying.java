package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State {

    private static DrawerClosedNotPlaying instance;
    private DVDPlayer player = DVDPlayer.getInstance();

    private DrawerClosedNotPlaying() {
    }

    public static DrawerClosedNotPlaying getInstance() {
        if (instance == null) {
            instance = new DrawerClosedNotPlaying();
        }
        return instance;
    }

    @Override
    public void openCloseButtonPushed() {
        player.open();
        player.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed() {
        player.play();
        player.changeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {
        // Do Nothing
    }

}
