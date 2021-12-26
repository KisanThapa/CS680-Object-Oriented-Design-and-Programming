package edu.umb.cs680.hw14.comparator;

import edu.umb.cs680.hw14.apfs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TimeStampComparatorTest {

    static APFS apfs;
    static ApfsDirectory root;

    @BeforeAll
    public static void setupTest() {
        apfs = APFS.getAPFS();

        // Root Directories
        root = (ApfsDirectory) apfs.initFileSystem("root", 1200);

        // Directories
        ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, LocalDateTime.now(), "owner1", LocalDateTime.now());
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "owner1", LocalDateTime.now());
        ApfsDirectory code = new ApfsDirectory(home, "code", 0, LocalDateTime.now(), "owner1", LocalDateTime.now());

        // Files
        ApfsFile a = new ApfsFile(applications, "a", 2, LocalDateTime.now(), "owner1", LocalDateTime.now());
        ApfsFile b = new ApfsFile(home, "b", 2, LocalDateTime.now(), "owner1", LocalDateTime.now());
        ApfsFile c = new ApfsFile(code, "c", 2, LocalDateTime.now(), "owner1", LocalDateTime.now());
        ApfsFile d = new ApfsFile(code, "d", 2, LocalDateTime.now(), "owner1", LocalDateTime.now());

        // Links
        ApfsLink x = new ApfsLink(home, "x", 1, LocalDateTime.now(), applications, "owner1", LocalDateTime.now());
        ApfsLink y = new ApfsLink(code, "y", 1, LocalDateTime.now(), a, "owner1", LocalDateTime.now());

    }

    private String[] apfsEleToString(LinkedList<ApfsElement> eleList) {
        String[] info = new String[eleList.size()];

        for (int i = 0; i < eleList.size(); i++)
            info[i] = eleList.get(i).getName();

        return info;
    }

    private String[] filesToString(LinkedList<ApfsFile> files) {
        String[] info = new String[files.size()];

        for (int i = 0; i < files.size(); i++)
            info[i] = files.get(i).getName();

        return info;
    }

    private String[] dirsToString(LinkedList<ApfsDirectory> dirs) {
        String[] info = new String[dirs.size()];

        for (int i = 0; i < dirs.size(); i++)
            info[i] = dirs.get(i).getName();

        return info;
    }

    @Test
    public void childrenInHomeDirectoryComparatorTest() {
        String[] expected = {"code", "b", "x"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = apfsEleToString(rootDir.findDirectoryByName("home").getChildren(
                (ApfsElement apfsEle1, ApfsElement apfsEle2)
                        -> apfsEle1.getCreationTime().toString().compareTo(apfsEle2.getCreationTime().toString())
        ));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void filesInCodeDirectoryComparatorTest() {
        String[] expected = {"c", "d"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = filesToString(
                rootDir.findDirectoryByName("home").findDirectoryByName("code")
                        .getFiles((ApfsElement apfsEle1, ApfsElement apfsEle2)
                                -> apfsEle1.getCreationTime().toString().compareTo(apfsEle2.getCreationTime().toString())));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void filesInApplicationDirectoryComparatorTest() {
        String[] expected = {"a"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = filesToString(
                rootDir.findDirectoryByName("applications").getFiles((ApfsElement apfsEle1, ApfsElement apfsEle2)
                        -> apfsEle1.getCreationTime().toString().compareTo(apfsEle2.getCreationTime().toString())));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void childrenInCodeDirectoryComparatorTest() {
        String[] expected = {"c", "d", "y"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = apfsEleToString(
                rootDir.findDirectoryByName("home").findDirectoryByName("code")
                        .getChildren((ApfsElement apfsEle1, ApfsElement apfsEle2)
                                -> apfsEle1.getCreationTime().toString().compareTo(apfsEle2.getCreationTime().toString())));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void directoriesInRootDirectoryComparatorTest() {
        String[] expected = {"applications", "home"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = dirsToString(
                rootDir.getSubDirectories((ApfsElement apfsEle1, ApfsElement apfsEle2)
                        -> apfsEle1.getCreationTime().toString().compareTo(apfsEle2.getCreationTime().toString())));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void directoriesInHomeDirectoryComparatorTest() {
        String[] expected = {"code"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = dirsToString(
                rootDir.findDirectoryByName("home").getSubDirectories((ApfsElement apfsEle1, ApfsElement apfsEle2)
                        -> apfsEle1.getCreationTime().toString().compareTo(apfsEle2.getCreationTime().toString())));

        assertArrayEquals(expected, actual);
    }


}