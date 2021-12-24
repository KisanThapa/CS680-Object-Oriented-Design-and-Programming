package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import edu.umb.cs680.hw09.apfs.APFS;
import edu.umb.cs680.hw09.apfs.ApfsDirectory;
import org.junit.jupiter.api.Test;

class FileSystemTest {

    static LocalDateTime localTime = LocalDateTime.now();

    private String[] directoryToStringArray(ApfsDirectory directory) {

        return new String[]{
                null,
                directory.getName(),
                Integer.toString(directory.getSize()),
                directory.getCreationTime().toString()
        };
    }

    @Test
    public void checkRootDirectory() {
        ApfsDirectory root = new ApfsDirectory(null, "root", 0, localTime, "owner1", localTime);
        String[] expected = { null, "root", "0", localTime.toString() };
        APFS.getAPFS().addRootDir(root);

        ApfsDirectory actual = (ApfsDirectory) APFS.getAPFS().getRootDir().get(0);
        assertArrayEquals(expected, directoryToStringArray(actual));
    }
}
