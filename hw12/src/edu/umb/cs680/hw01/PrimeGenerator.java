package edu.umb.cs680.hw01;

import java.util.LinkedList;
import java.util.List;

public class PrimeGenerator {
   
    private Long from;
    private Long to;

    private LinkedList<Long> primes;
    
    public PrimeGenerator(Long from, Long to) {
        this.from = from;
        this.to = to;

        primes = new LinkedList<>();
    }

    public void generatePrimes() {

        if (from > to || from < 0 || to < 0)
            throw new IllegalArgumentException("invalid range");
        
        for (long i = from; i <= to; i++) {
            for (int j = 2; j <= i; j++) {
                if (i == 2) {
                    primes.add(2L);
                    break;   
                }
                if (i % j == 0)
                    break;
                if (j > i / 2) {
                    primes.add(i);
                    break;
                }
            }
        }
    }

    public List<Long> getPrimes() {
        return primes;
    }
}
