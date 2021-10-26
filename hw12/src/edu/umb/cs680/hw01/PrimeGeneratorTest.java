package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import org.junit.Test;

public class PrimeGeneratorTest {

    @Test
    public void primeFrom3To10() {
        PrimeGenerator pGenerator = new PrimeGenerator(3L, 10L);
        pGenerator.generatePrimes();
        List<Long> actual = pGenerator.getPrimes();
        List<Long> expected = List.of(3L, 5L, 7L);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void primeFrom1To10() {
        PrimeGenerator pGenerator = new PrimeGenerator(1L, 10L);
        pGenerator.generatePrimes();
        List<Long> actual = pGenerator.getPrimes();
        List<Long> expected = List.of(2L, 3L, 5L, 7L);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void primeFrom12To2() {
        try {
            PrimeGenerator pGenerator = new PrimeGenerator(12L, 2L);
            pGenerator.generatePrimes();
            pGenerator.getPrimes();
            fail("Invalid range test fail");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=12 to=2", ex.getMessage());
        }
    }

    @Test
    public void primeFrom2To2() {
        try {
            PrimeGenerator pGenerator = new PrimeGenerator(2L, 2L);
            pGenerator.generatePrimes();
            pGenerator.getPrimes();
            fail("Invalid range test fail");
        } catch (RuntimeException ex) {
            assertEquals("Wrong input values: from=2 to=2", ex.getMessage());
        }
    }
}
