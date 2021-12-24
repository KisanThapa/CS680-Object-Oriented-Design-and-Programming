package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;
import org.junit.jupiter.api.Test;

class ApfsDirectoryTest {

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
        String[] expected = {
                "true",
                "home",
                "0",
                localTime.toString(),
                "3",
                "8",
                "root",
                "owner1",
                localTime.toString()
        };
        assertArrayEquals(expected, dirToStringArray(home));
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
                "root",
                "owner1",
                localTime.toString()
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
                "home",
                "owner1",
                localTime.toString()
        };
        assertArrayEquals(expected, dirToStringArray(code));
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
