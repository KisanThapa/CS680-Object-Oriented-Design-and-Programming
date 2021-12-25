package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DrawerClosedNotPlayingTest {

    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void verifyOpenCloseButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedNotPlaying closedNotPlaying = DrawerClosedNotPlaying.getInstance();

        closedNotPlaying.openCloseButtonPushed();

        assertEquals("DVD Drawer Opened!", outStream.toString().trim());
        assertEquals(player.getState(), DrawerOpen.getInstance());
    }

    @Test
    public void verifyPlayButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedNotPlaying closedNotPlaying = DrawerClosedNotPlaying.getInstance();

        closedNotPlaying.playButtonPushed();

        assertEquals("DVD is Playing!", outStream.toString().trim());
        assertEquals(player.getState(), DrawerClosedPlaying.getInstance());

    }

    @Test
    public void verifyStopButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedNotPlaying closedNotPlaying = DrawerClosedNotPlaying.getInstance();

        closedNotPlaying.stopButtonPushed();

        assertEquals("", outStream.toString().trim());
        assertEquals(player.getState(), DrawerClosedPlaying.getInstance());
    }
}
