package edu.umb.cs680.hw09;

import edu.umb.cs680.hw09.apfs.APFS;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class APFSTest {

    @Test
    public void testSingletonAPFS(){
       APFS apfs1 = APFS.getAPFS();
       APFS apfs2 = APFS.getAPFS();

       assertEquals(apfs1, apfs2);
    }
}
