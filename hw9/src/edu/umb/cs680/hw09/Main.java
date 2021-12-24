package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsLink;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {

        APFS fileSystem = APFS.getAPFS();
        fileSystem.initFileSystem("apfs", 0);

        ApfsDirectory root = (ApfsDirectory) fileSystem.getRoot();

        // System.out.println(root.toString());

        ApfsLink apfsLink = new ApfsLink(null, "link1", 1, LocalDateTime.now(), root, "kisan", LocalDateTime.now());
        // System.out.println(apfsLink.toString());
    }
}
