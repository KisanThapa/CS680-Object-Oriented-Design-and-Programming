package edu.umb.cs680.hw07;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class FileSystemTest {

    static LocalDateTime localTime = LocalDateTime.now();

    private String[] directoryToStringArray(Directory directory) {
        String[] info = {
                null,
                directory.getName(),
                Integer.toString(directory.getSize()),
                directory.getCreationTime().toString()
        };

        return info;
    }

    @Test
    public void checkSingletonFileSystem() {
        FileSystem fileSystem1 = FileSystem.getFileSystem();
        FileSystem fileSystem2 = FileSystem.getFileSystem();
        assertEquals(fileSystem1, fileSystem2);
    }

    @Test
    public void checkRootDirectory() {
        Directory root = new Directory(null, "root", 0, localTime);
        String[] expected = { null, "root", "0", localTime.toString() };
        FileSystem.getFileSystem().addRootDir(root);

        Directory actual = FileSystem.getFileSystem().getRootDir().get(0);
        assertArrayEquals(expected, directoryToStringArray(actual));
    }
}
