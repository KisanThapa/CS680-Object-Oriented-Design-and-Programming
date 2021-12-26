package edu.umb.cs680.hw14.comparator;

import edu.umb.cs680.hw14.apfs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseAlphabeticalComparatorTest {

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
        String[] expected = {"x", "code", "b"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = apfsEleToString(
                rootDir.findDirectoryByName("home").getChildren(
                        (ApfsElement apfsEle1, ApfsElement apfsEle2) -> -apfsEle1.getName().compareToIgnoreCase(apfsEle2.getName())
                ));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void filesInCodeDirectoryComparatorTest() {
        String[] expected = {"d", "c"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = filesToString(
                rootDir.findDirectoryByName("home").findDirectoryByName("code")
                        .getFiles((ApfsElement apfsEle1, ApfsElement apfsEle2) -> -apfsEle1.getName().compareToIgnoreCase(apfsEle2.getName())));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void filesInApplicationDirectoryComparatorTest() {
        String[] expected = {"a"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = filesToString(
                rootDir.findDirectoryByName("applications").getFiles((ApfsElement apfsEle1, ApfsElement apfsEle2) -> -apfsEle1.getName().compareToIgnoreCase(apfsEle2.getName())));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void childrenInCodeDirectoryComparatorTest() {
        String[] expected = {"y", "d", "c"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = apfsEleToString(
                rootDir.findDirectoryByName("home").findDirectoryByName("code")
                        .getChildren((ApfsElement apfsEle1, ApfsElement apfsEle2) -> -apfsEle1.getName().compareToIgnoreCase(apfsEle2.getName())));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void directoriesInRootDirectoryComparatorTest() {
        String[] expected = {"home", "applications"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = dirsToString(
                rootDir.getSubDirectories((ApfsElement apfsEle1, ApfsElement apfsEle2) -> -apfsEle1.getName().compareToIgnoreCase(apfsEle2.getName())));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void directoriesInHomeDirectoryComparatorTest() {
        String[] expected = {"code"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = dirsToString(
                rootDir.findDirectoryByName("home").getSubDirectories((ApfsElement apfsEle1, ApfsElement apfsEle2) -> -apfsEle1.getName().compareToIgnoreCase(apfsEle2.getName())));

        assertArrayEquals(expected, actual);
    }

}