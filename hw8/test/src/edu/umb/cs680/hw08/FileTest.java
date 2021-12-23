package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class FileTest {
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

    
    private String[] fileToStringArray(File f) {
        String[] fileInfo = {
                Boolean.toString(f.isDirectory()),
                f.getName(),
                Integer.toString(f.getSize()),
                f.getCreationTime().toString(),
                f.getParent().getName()
        };
        return fileInfo;
    }

    @Test
    public void testFileA() {
        String[] expected = {
                "false",
                "a",
                "2",
                localTime.toString(),
                "applications"
        };

        assertArrayEquals(expected, fileToStringArray(a));
    }

    @Test
    public void testFileB() {
        String[] expected = {
                "false",
                "b",
                "2",
                localTime.toString(),
                "home"
        };
        assertArrayEquals(expected, fileToStringArray(b));
    }

    @Test
    public void verifyIfFiles() {
        assertFalse(a.isDirectory());
        assertFalse(b.isDirectory());
        assertFalse(c.isDirectory());
        assertFalse(d.isDirectory());
    }
}