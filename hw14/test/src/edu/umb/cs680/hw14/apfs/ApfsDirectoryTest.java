package edu.umb.cs680.hw14.apfs;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsDirectoryTest {

    static LocalDateTime localTime = LocalDateTime.now();
    static APFS apfs;
    static ApfsDirectory root;

    @BeforeAll
    public static void setupTest() {
        apfs = APFS.getAPFS();

        // Root Directories
        root = (ApfsDirectory) apfs.initFileSystem("root", 1200);

        // Directories
        ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime, "owner1", localTime);
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime, "owner1", localTime);
        ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime, "owner1", localTime);

        // Files
        ApfsFile a = new ApfsFile(applications, "a", 2, localTime, "owner1", localTime);
        ApfsFile b = new ApfsFile(home, "b", 2, localTime, "owner1", localTime);
        ApfsFile c = new ApfsFile(code, "c", 2, localTime, "owner1", localTime);
        ApfsFile d = new ApfsFile(code, "d", 2, localTime, "owner1", localTime);

        // Links
        ApfsLink x = new ApfsLink(home, "x", 1, localTime, applications, "owner1", localTime);
        ApfsLink y = new ApfsLink(code, "y", 1, localTime, a, "owner1", localTime);

    }


    private String[] dirToStringArray(ApfsDirectory dir) {
       ApfsDirectory directory = dir.getParent();
        return new String[]{
                Boolean.toString(dir.isDirectory()),
                dir.getName(),
                Integer.toString(dir.getSize()),
                dir.getCreationTime().toString(),
                Integer.toString(dir.countChildren()),
                Integer.toString(dir.getTotalSize()),
                nullTest(directory),
                dir.getOwnerName(),
                dir.getLastModifiedTime().toString()
        };
    }
    private String nullTest(ApfsDirectory dir){
        if (dir.getName() == null) return  null;
        else return dir.getName();
    }

    @Test
    public void testHomeDirectory() {
        String[] expected = {"true", "home", "0", localTime.toString(), "3", "8", "root", "owner1", localTime.toString()};
        ApfsDirectory actual = root.findDirectoryByName("home");

        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void testApplicationsDirectory() {
        String[] expected = {"true", "applications", "0", localTime.toString(), "1", "2", "root", "owner1", localTime.toString()};
        ApfsDirectory actual = root.findDirectoryByName("applications");

        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void testCodeDirectory() {
        String[] expected = {"true", "code", "0", localTime.toString(), "3", "5", "home", "owner1", localTime.toString()};
        ApfsDirectory actual = root.findDirectoryByName("home").findDirectoryByName("code");

        assertArrayEquals(expected, dirToStringArray(actual));
    }

    @Test
    public void testDirectoryCountInRootDirectory() {
        assertEquals(2, root.getSubDirectories().size());
    }

    @Test
    public void testDirectoryCountInHomeDirectory() {
        assertEquals(1, root.findDirectoryByName("home").getSubDirectories().size());
    }

    @Test
    public void directoryFileTest() {
        assertTrue(root.findDirectoryByName("applications").isDirectory());
        assertFalse(root.findFileByName("a").isDirectory());
        assertTrue(root.isDirectory());
        assertTrue(root.findDirectoryByName("home").isDirectory());
        assertTrue(root.findDirectoryByName("home").findDirectoryByName("code").isDirectory());
        assertFalse(root.findFileByName("b").isDirectory());
    }
}
