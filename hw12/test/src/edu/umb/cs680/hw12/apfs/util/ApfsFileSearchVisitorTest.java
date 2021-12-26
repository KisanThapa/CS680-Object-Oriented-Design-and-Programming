package edu.umb.cs680.hw12.apfs.util;

import edu.umb.cs680.hw12.apfs.APFS;
import edu.umb.cs680.hw12.apfs.ApfsDirectory;
import edu.umb.cs680.hw12.apfs.ApfsFile;
import edu.umb.cs680.hw12.apfs.ApfsLink;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ApfsFileSearchVisitorTest {

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
    public void testTotalFileCount() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        rootDir.accept(visitor);

        assertSame(4, visitor.getFiles().size());
    }


    @Test
    public void testFileA() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        rootDir.accept(visitor);

        String[] expected = {"false", "a", "2", localTime.toString(), "applications", "owner1", localTime.toString()};
        ApfsFile actual = visitor.getFiles().get(0);

        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void testFileB() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        rootDir.accept(visitor);

        String[] expected = {"false", "b", "2", localTime.toString(), "home", "owner1", localTime.toString()};
        ApfsFile actual = visitor.getFiles().get(3);

        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void testFileC() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        rootDir.findDirectoryByName("home").findDirectoryByName("code").accept(visitor);

        String[] expected = {"false", "c", "2", localTime.toString(), "code", "owner1", localTime.toString()};
        ApfsFile actual = visitor.getFiles().get(0);

        assertArrayEquals(expected, fileToStringArray(actual));
    }

    @Test
    public void testFileD() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        rootDir.findDirectoryByName("home").findDirectoryByName("code").accept(visitor);

        String[] expected = {"false", "d", "2", localTime.toString(), "code", "owner1", localTime.toString()};
        ApfsFile actual = visitor.getFiles().get(1);

        assertArrayEquals(expected, fileToStringArray(actual));
    }

}
