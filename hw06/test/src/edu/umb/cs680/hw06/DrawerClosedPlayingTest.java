package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DrawerClosedPlayingTest {
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void verifyOpenCloseButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedPlaying closedPlaying = DrawerClosedPlaying.getInstance();

        closedPlaying.openCloseButtonPushed();

        assertEquals("DVD is Stopped!\nDVD Drawer Opened!", outStream.toString().trim());
        assertEquals(player.getState(), DrawerOpen.getInstance());
    }

    @Test
    public void verifyPlayButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedPlaying closedPlaying = DrawerClosedPlaying.getInstance();

        closedPlaying.playButtonPushed();

        assertEquals("", outStream.toString().trim());
        assertEquals(player.getState(), DrawerOpen.getInstance());

    }

    @Test
    public void verifyStopButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedPlaying closedPlaying = DrawerClosedPlaying.getInstance();

        closedPlaying.stopButtonPushed();

        assertEquals("DVD is Stopped!", outStream.toString().trim());
        assertEquals(player.getState(), DrawerClosedNotPlaying.getInstance());
    }
}
