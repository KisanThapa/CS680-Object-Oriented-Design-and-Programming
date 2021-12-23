package edu.umb.cs680.hw08;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class LinkTest {

    LocalDateTime localTime = LocalDateTime.now();

    // Directories
    Directory root = new Directory(null, "root", 0, localTime);
    Directory applications = new Directory(root, "applications", 0, localTime);
    Directory home = new Directory(root, "home", 0, localTime);
    Directory code = new Directory(home, "code", 0, localTime);

    // Files
    File a = new File(applications, "a", 2, localTime);
    File b = new File(home, "b", 2, localTime);
    File c = new File(code, "c", 2, localTime);
    File d = new File(code, "d", 2, localTime);

    // Links
    Link x = new Link(home, "x", 1, localTime, applications);
    Link y = new Link(code, "y", 1, localTime, a);


    private String[] linkToStringArray(Link link) {

        String[] infoList = {
                Boolean.toString(link.isDirectory()),
                link.getName(),
                Integer.toString(link.getSize()),
                link.getCreationTime().toString(),
                link.getParent().getName(),
                link.getTarget().getName()
        };

        return infoList;
    }

    @Test
    public void testLinkX() {
        String[] expected = {
                "false",
                "x",
                "1",
                localTime.toString(),
                "home",
                "applications"
        };
        assertArrayEquals(expected, linkToStringArray(x));
    }

    @Test
    public void testLinkY() {
        String[] expected = {
                "false",
                "y",
                "1",
                localTime.toString(),
                "code",
                "a"
        };
        assertArrayEquals(expected, linkToStringArray(y));
    }

    
    @Test
    public void testDirectoryOrNot() {
        assertFalse(x.isDirectory());
        assertFalse(y.isDirectory());
    }

}
