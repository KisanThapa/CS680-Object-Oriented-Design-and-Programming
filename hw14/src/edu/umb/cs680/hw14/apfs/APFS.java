package edu.umb.cs680.hw14.apfs;

import edu.umb.cs680.hw14.filesystem.FSElement;
import edu.umb.cs680.hw14.filesystem.FileSystem;

import java.time.LocalDateTime;

public class APFS extends FileSystem {

    private static APFS instance;
    private final LocalDateTime localDateTime = LocalDateTime.now();

    private APFS() {
    }

    public static APFS getAPFS() {
        if (instance == null)
            instance = new APFS();
        return instance;
    }

    @Override
    public FSElement createDefaultRoot() {
        return new ApfsDirectory(null, "root", 1200, localDateTime, "owner1", localDateTime);
    }

}
