package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import org.junit.jupiter.api.Test;

class ApfsFileTest {
    static LocalDateTime localTime = LocalDateTime.now();


    // Directories
    ApfsDirectory root = new ApfsDirectory(null, "root", 0, localTime, "owner1", localTime);
    ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, localTime,"owner1", localTime);
    ApfsDirectory home = new ApfsDirectory(root, "home", 0, localTime,"owner1", localTime);
    ApfsDirectory code = new ApfsDirectory(home, "code", 0, localTime,"owner1", localTime);

    // Files
    ApfsFile a = new ApfsFile(applications, "a", 2, localTime, "owner1", localTime);
    ApfsFile b = new ApfsFile(home, "b", 2, localTime, "owner1", localTime);
    ApfsFile c = new ApfsFile(code, "c", 2, localTime, "owner1", localTime);
    ApfsFile d = new ApfsFile(code, "d", 2, localTime, "owner1", localTime);

    // Links
    ApfsLink x = new ApfsLink(home, "x", 1, localTime, applications, "owner1", localTime);
    ApfsLink y = new ApfsLink(code, "y", 1, localTime, a, "owner1", localTime);



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
        String[] expected = {
                "false",
                "a",
                "2",
                localTime.toString(),
                "applications",
                "owner1",
                localTime.toString()
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
                "home",
                "owner1",
                localTime.toString()
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