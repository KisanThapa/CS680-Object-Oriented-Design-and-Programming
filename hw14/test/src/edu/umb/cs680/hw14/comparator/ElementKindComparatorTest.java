package edu.umb.cs680.hw14.comparator;

import edu.umb.cs680.hw14.apfs.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class ElementKindComparatorTest {

    static LocalDateTime localTime = LocalDateTime.now();
    static APFS apfs;
    static ApfsDirectory root;

    @BeforeAll
    public static void setupTest() {
        apfs = APFS.getAPFS();

        // Root Directories
        root = (ApfsDirectory) apfs.initFileSystem("root", 1200);

        // Directories
        ApfsDirectory applications = new ApfsDirectory(root, "applications", 4, localTime, "owner1", localTime);
        ApfsDirectory home = new ApfsDirectory(root, "home", 4, localTime, "owner1", localTime);
        ApfsDirectory code = new ApfsDirectory(home, "code", 4, localTime, "owner1", localTime);

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
    public void childrensInHomeDiretoryComparatorTest() {
        String[] expected = {"code", "b", "x"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = apfsEleToString(
                rootDir.findDirectoryByName("home").getChildren(
                        (ApfsElement apfsEle1, ApfsElement apfsEle2) ->
                                -String.valueOf(apfsEle1.getSize()).compareTo(String.valueOf(apfsEle2.getSize()))
                ));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void filesInCodeDiretoryComparatorTest() {
        String[] expected = {"c", "d"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = filesToString(
                rootDir.findDirectoryByName("home").findDirectoryByName("code").getFiles((ApfsElement apfsEle1, ApfsElement apfsEle2) ->
                        -String.valueOf(apfsEle1.getSize()).compareTo(String.valueOf(apfsEle2.getSize()))));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void childrensInCodeDiretoryComparatorTest() {
        String[] expected = {"c", "d", "y"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = apfsEleToString(
                rootDir.findDirectoryByName("home").findDirectoryByName("code").getChildren((ApfsElement apfsEle1, ApfsElement apfsEle2) ->
                        -String.valueOf(apfsEle1.getSize()).compareTo(String.valueOf(apfsEle2.getSize()))));

        assertArrayEquals(expected, actual);
    }

    @Test
    public void directoriesInRootDiretoryComparatorTest() {
        String[] expected = {"applications", "home"};

        ApfsDirectory rootDir = (ApfsDirectory) apfs.getRoot();
        String[] actual = dirsToString(
                rootDir.getSubDirectories((ApfsElement apfsEle1, ApfsElement apfsEle2) ->
                        -String.valueOf(apfsEle1.getSize()).compareTo(String.valueOf(apfsEle2.getSize()))));

        assertArrayEquals(expected, actual);
    }

}