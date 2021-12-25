package edu.umb.cs680.hw10.apfs;

import edu.umb.cs680.hw10.apfs.APFS;
import edu.umb.cs680.hw10.apfs.ApfsDirectory;
import edu.umb.cs680.hw10.apfs.ApfsFile;
import edu.umb.cs680.hw10.apfs.ApfsLink;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ApfsLinkTest {

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
        String[] expected = {"false", "x", "1", localTime.toString(), "home", "applications", "owner1", localTime.toString()};
        ApfsLink actual = root.findLinkByName("x");

        assertArrayEquals(expected, linkToStringArray(actual));
    }

    @Test
    public void testLinkY() {
        String[] expected = {"false", "y", "1", localTime.toString(), "code", "a", "owner1", localTime.toString()};
        ApfsLink actual = root.findLinkByName("y");

        assertArrayEquals(expected, linkToStringArray(actual));
    }

    @Test
    public void testDirectoryOrNot() {
        assertFalse(root.findLinkByName("x").isDirectory());
        assertFalse(root.findLinkByName("y").isDirectory());
    }

}
