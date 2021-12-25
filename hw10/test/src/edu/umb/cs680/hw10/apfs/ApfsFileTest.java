package edu.umb.cs680.hw10.apfs;

import edu.umb.cs680.hw10.apfs.APFS;
import edu.umb.cs680.hw10.apfs.ApfsDirectory;
import edu.umb.cs680.hw10.apfs.ApfsFile;
import edu.umb.cs680.hw10.apfs.ApfsLink;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ApfsFileTest {
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

    private String[] fileToStringArray(ApfsFile f) {
        return new String[]{
                Boolean.toString(f.isDirectory()),
                f.getName(),
                Integer.toString(f.getSize()),
                f.getCreationTime().toString(),
                f.getParent().getName(),
                f.getOwnerName(),
                f.getLastModifiedTime().toString()
        };
    }

    @Test
    public void testFileA() {
        String[] expected = {"false", "a", "2", localTime.toString(), "applications", "owner1", localTime.toString()};
        ApfsFile actual = root.findDirectoryByName("applications").findFileByName("a");

        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void testFileB() {
        String[] expected = {"false", "b", "2", localTime.toString(), "home", "owner1", localTime.toString()};
        ApfsFile actual = root.findDirectoryByName("home").findFileByName("b");

        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void testFileC() {
        String[] expected = {"false", "c", "2", localTime.toString(), "code", "owner1", localTime.toString()};
        ApfsFile actual = root.findDirectoryByName("home").findDirectoryByName("code").findFileByName("c");

        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void testFileD() {
        String[] expected = {"false", "d", "2", localTime.toString(), "code", "owner1", localTime.toString()};
        ApfsFile actual = root.findDirectoryByName("home").findDirectoryByName("code").findFileByName("d");

        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void testCAndDIsInSameDirectory() {
        assertSame(root.findDirectoryByName("home").findDirectoryByName("code").findFileByName("c").getParent().getName(), root.findDirectoryByName("home").findDirectoryByName("code").findFileByName("d").getParent().getName());
    }

    @Test
    public void testyAndCIsInSameDirectory() {
        assertSame(root.findDirectoryByName("home").findDirectoryByName("code").findLinkByName("y").getParent().getName(), root.findDirectoryByName("home").findDirectoryByName("code").findFileByName("c").getParent().getName());
    }

    @Test
    public void testFileCountInCodeDirectory() {
        assertEquals(2, root.findDirectoryByName("home").findDirectoryByName("code").getFiles().size());
    }

    @Test
    public void testFileCountInHomeDirectory() {
        assertEquals(1, root.findDirectoryByName("home").getFiles().size());
    }

    @Test
    public void testFileCountInApplicationDirectory() {
        assertEquals(1, root.findDirectoryByName("applications").getFiles().size());
    }

    @Test
    public void verifyIfFiles() {
        assertFalse(root.findDirectoryByName("applications").findFileByName("a").isDirectory());
        assertFalse(root.findDirectoryByName("home").findFileByName("b").isDirectory());
        assertFalse(root.findDirectoryByName("home").findDirectoryByName("code").findFileByName("c").isDirectory());
        assertFalse(root.findDirectoryByName("home").findDirectoryByName("code").findFileByName("d").isDirectory());
    }
}