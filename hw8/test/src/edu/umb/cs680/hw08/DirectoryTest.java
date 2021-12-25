package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class DirectoryTest {

    static LocalDateTime localTime = LocalDateTime.now();

    // Directories
    Directory root = new Directory(null, "root", 0, localTime);
    Directory applications = new Directory(root, "applications", 0, localTime);
    Directory home = new Directory(root, "home", 0, localTime);
    Directory code = new Directory(home, "code", 0, localTime);

    // Files
    File a = new File(applications, "a", 2, localTime);
    File b = new File(home, "b", 2, localTime);
    File c = new File(code, "c", 2, localTime);
    File d = new File(code, "d", 2, localTime);

    // Links
    Link x = new Link(home, "x", 1, localTime, applications);
    Link y = new Link(code, "y", 1, localTime, a);

    private String[] dirToStringArray(Directory dir) {
        Optional<Directory> optionalDirectory = Optional.ofNullable(dir.getParent());
        String[] infoList = {
                Boolean.toString(dir.isDirectory()),
                dir.getName(),
                Integer.toString(dir.getSize()),
                dir.getCreationTime().toString(),
                Integer.toString(dir.countChildren()),
                Integer.toString(dir.getTotalSize()),
                optionalDirectory.isPresent() ? dir.getParent().getName() : null
        };
        return infoList;
    }

    @Test
    public void testHomeDirectory() {
        String[] expected = {
                "true",
                "home",
                "0",
                localTime.toString(),
                "3",
                "8",
                "root"
        };
        assertArrayEquals(expected, dirToStringArray(home));
    }

    @Test
    public void testRootDirectory() {
        String[] expected = {
                "true",
                "root",
                "0",
                localTime.toString(),
                "2",
                "10",
                null
        };
        assertArrayEquals(expected, dirToStringArray(root));
    }

    @Test
    public void testApplicationsDirectory() {
        String[] expected = {
                "true",
                "applications",
                "0",
                localTime.toString(),
                "1",
                "2",
                "root"
        };
        assertArrayEquals(expected, dirToStringArray(applications));
    }

    @Test
    public void testCodeDirectory() {
        String[] expected = {
                "true",
                "code",
                "0",
                localTime.toString(),
                "3",
                "5",
                "home"
        };
        assertArrayEquals(expected, dirToStringArray(code));
    }

    @Test
    public void testDirectoryCountInRootDirectory() {
        assertEquals(2, root.getSubDirectories().size());
    }
    
    @Test
    public void testDirectoryCountInHomeDirectory() {
        assertEquals(1, home.getSubDirectories().size());
    }
    

    @Test
    public void directoryFileTest() {
        assertTrue(applications.isDirectory());
        assertFalse(a.isDirectory());
        assertTrue(root.isDirectory());
        assertTrue(home.isDirectory());
        assertTrue(code.isDirectory());
        assertFalse(b.isDirectory());
    }

    @Test
    public void subFilesAndFolderNumberTest() {
        assertEquals(2, root.countChildren());
        assertEquals(3, code.countChildren());
        assertEquals(1, applications.countChildren());
        assertEquals(3, home.countChildren());
    }
}
