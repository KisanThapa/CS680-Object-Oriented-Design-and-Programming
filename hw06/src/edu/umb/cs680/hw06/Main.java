package edu.umb.cs680.hw06;

public class Main {
    public static void main(String[] args) {
        
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedNotPlaying.getInstance());

        player.playButtonPushed();
        player.stopButtonPushed();
        player.openCloseButtonPushed();
        player.openCloseButtonPushed();
        player.openCloseButtonPushed();
        player.playButtonPushed();
        player.playButtonPushed();

    }
}
