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
    public void primeFromMinus10To5() {
        PrimeGenerator pGenerator = new PrimeGenerator(-10L, 5L);
        try {
            pGenerator.generatePrimes();
            pGenerator.getPrimes();
            fail("invalid range for prime numbers");
        } catch (IllegalArgumentException ex) {
            assertEquals("invalid range", ex.getMessage());
        }
    }
    
    @Test
    public void primeFrom12To2() {
        PrimeGenerator pGenerator = new PrimeGenerator(12L, 2L);
        try {
            pGenerator.generatePrimes();
            pGenerator.getPrimes();
            fail("invalid range for prime numbers");
        } catch (IllegalArgumentException ex) {
            assertEquals("invalid range", ex.getMessage());
        }
    }
    
    @Test
    public void primeFrom2To2() {
        PrimeGenerator pGenerator = new PrimeGenerator(2L, 2L);
        pGenerator.generatePrimes();
        List<Long> actual = pGenerator.getPrimes();
        List<Long> expected = List.of(2L);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void primeFrom0To0() {
        PrimeGenerator pGenerator = new PrimeGenerator(0L, 0L);
        pGenerator.generatePrimes();
        List<Long> actual = pGenerator.getPrimes();
        List<Long> expected = List.of();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}
