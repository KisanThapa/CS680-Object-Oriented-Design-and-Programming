package edu.umb.cs680.hw14.apfs.util;

import edu.umb.cs680.hw14.apfs.APFS;
import edu.umb.cs680.hw14.apfs.ApfsDirectory;
import edu.umb.cs680.hw14.apfs.ApfsFile;
import edu.umb.cs680.hw14.apfs.ApfsLink;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertSame;

public class ApfsCountingVisitorTest {

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
    public void testDirectoryCountInRoot() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        rootDir.accept(visitor);

        assertSame(4, visitor.getDirNum());
    }

    @Test
    public void testFilesCountInRoot() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        rootDir.accept(visitor);

        assertSame(4, visitor.getFileNum());
    }

    @Test
    public void testLinksCountInRoot() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        rootDir.accept(visitor);

        assertSame(2, visitor.getLinkNum());
    }

    // Checking for "home" directories as well
    @Test
    public void testDirectoryCountInHome() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        rootDir.findDirectoryByName("home").accept(visitor);

        assertSame(2, visitor.getDirNum());
    }

    @Test
    public void testFilesCountInHome() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        rootDir.findDirectoryByName("home").accept(visitor);

        assertSame(3, visitor.getFileNum());
    }

    @Test
    public void testLinksCountInHome() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        rootDir.findDirectoryByName("home").accept(visitor);

        assertSame(2, visitor.getLinkNum());
    }

    // Checking for "code" directories as well
    @Test
    public void testDirectoryCountInCode() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        rootDir.findDirectoryByName("home").findDirectoryByName("code").accept(visitor);

        assertSame(1, visitor.getDirNum());
    }

    @Test
    public void testFilesCountInCode() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        rootDir.findDirectoryByName("home").findDirectoryByName("code").accept(visitor);

        assertSame(2, visitor.getFileNum());
    }

    @Test
    public void testLinksCountInCode() {
        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        rootDir.findDirectoryByName("home").findDirectoryByName("code").accept(visitor);

        assertSame(1, visitor.getLinkNum());
    }

}
