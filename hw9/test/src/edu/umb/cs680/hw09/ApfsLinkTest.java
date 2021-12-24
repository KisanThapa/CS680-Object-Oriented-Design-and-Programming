package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import org.junit.jupiter.api.Test;

public class ApfsLinkTest {

    LocalDateTime localTime = LocalDateTime.now();

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


    private String[] linkToStringArray(ApfsLink link) {

        return new String[]{
                Boolean.toString(link.isDirectory()),
                link.getName(),
                Integer.toString(link.getSize()),
                link.getCreationTime().toString(),
                link.getParent().getName(),
                link.getTarget().getName(),
                link.getOwnerName(),
                link.getLastModifiedTime().toString()
        };
    }

    @Test
    public void testLinkX() {
        String[] expected = {
                "false",
                "x",
                "1",
                localTime.toString(),
                "home",
                "applications",
                "owner1",
                localTime.toString()
        };
        assertArrayEquals(expected, linkToStringArray(x));
    }

    @Test
    public void testLinkY() {
        String[] expected = {
                "false",
                "y",
                "1",
                localTime.toString(),
                "code",
                "a",
                "owner1",
                localTime.toString()
        };
        assertArrayEquals(expected, linkToStringArray(y));
    }

    
    @Test
    public void testDirectoryOrNot() {
        assertFalse(x.isDirectory());
        assertFalse(y.isDirectory());
    }

}
