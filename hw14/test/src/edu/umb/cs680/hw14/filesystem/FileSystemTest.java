package edu.umb.cs680.hw14.filesystem;

import edu.umb.cs680.hw14.apfs.APFS;
import edu.umb.cs680.hw14.apfs.ApfsDirectory;
import edu.umb.cs680.hw14.apfs.ApfsFile;
import edu.umb.cs680.hw14.apfs.ApfsLink;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

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

    private String[] directoryToStringArray(ApfsDirectory directory) {
        return new String[]{
                null,
                directory.getName(),
                Integer.toString(directory.getSize()),
                directory.getCreationTime().toString(),
                directory.getOwnerName(),
                directory.getLastModifiedTime().toString()
        };
    }

    @Test
    public void checkRootDirectory() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRootDir().get(0);
        assertEquals("root", rootDir.getName());
        assertEquals("owner1", rootDir.getOwnerName());
    }

    @Test
    public void testInitFileSystem(){
        assertEquals(1200, root.getSize());
        assertEquals("root", root.getName());
        assertNull(root.getParent());
    }
}
