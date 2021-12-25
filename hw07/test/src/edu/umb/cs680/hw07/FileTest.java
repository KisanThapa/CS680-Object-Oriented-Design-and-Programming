package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class FileTest {
    static LocalDateTime localTime = LocalDateTime.now();

    Directory root = new Directory(null, "root", 0, localTime);
    Directory applications = new Directory(root, "applications", 0, localTime);
    Directory home = new Directory(root, "home", 0, localTime);
    Directory code = new Directory(home, "code", 0, localTime);


    File a = new File(applications, "a", 1, localTime);
    File b = new File(home, "b", 1, localTime);
    File c = new File(code, "c", 1, localTime);
    File d = new File(code, "d", 1, localTime);

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
    public void verifyFileEqualityA() {
        String[] expected = { "false", "a", "1", localTime.toString(), "applications" };
        assertArrayEquals(expected, fileToStringArray(a));
    }

    @Test
    public void verifyFileEqualityB() {
        String[] expected = { "false", "b", "1", localTime.toString(), "home" };
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