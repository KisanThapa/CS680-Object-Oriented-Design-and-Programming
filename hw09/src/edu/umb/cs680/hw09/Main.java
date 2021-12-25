package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import edu.umb.cs680.hw09.apfs.ApfsFile;
import edu.umb.cs680.hw09.apfs.ApfsLink;

import java.time.LocalDateTime;

import javax.sound.sampled.SourceDataLine;

public class Main {
    public static void main(String[] args) throws Exception {

        LocalDateTime localTime = LocalDateTime.now();

        // Directories
        ApfsDirectory root = new ApfsDirectory(null, "root", 0, localTime, "owner1", localTime);
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


        APFS apfs = APFS.getAPFS();
        System.out.println(root.findDirectoryByName("root"));

    }
}
