package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void notNullCheck() {
        Singleton s1 = Singleton.getInstance();

        assertNotNull(s1);
    }

    @Test
    public void identityTest() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        assertSame(s1, s2);
    }

    @Test
    public void hashCodeCheck() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        assertEquals(s1.hashCode(), s2.hashCode());
    }
}

