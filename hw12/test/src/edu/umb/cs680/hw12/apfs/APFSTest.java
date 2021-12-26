package edu.umb.cs680.hw12.apfs;

import edu.umb.cs680.hw12.apfs.APFS;
import edu.umb.cs680.hw12.apfs.ApfsDirectory;
import edu.umb.cs680.hw12.apfs.ApfsFile;
import edu.umb.cs680.hw12.apfs.ApfsLink;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class APFSTest {

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

    @Test
    public void testSingletonAPFS(){
       APFS apfs1 = APFS.getAPFS();
       APFS apfs2 = APFS.getAPFS();

       assertEquals(apfs1, apfs2);
    }

    @Test
    public void capacityTest(){
        int actual = apfs.getCapacity();
        assertEquals(1200, actual);
    }
}
