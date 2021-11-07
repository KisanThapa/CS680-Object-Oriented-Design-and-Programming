package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DVDPlayerTest {
    
    @Test
    public void verifyDVDClosedNotPlaying() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedNotPlaying.getInstance());
        assertEquals(player.getState(), DrawerClosedNotPlaying.getInstance());
    }

    @Test
    public void verifyDVDClosedPlaying() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedNotPlaying.getInstance());
        player.playButtonPushed();
        assertEquals(player.getState(), DrawerClosedPlaying.getInstance());
    }
}
