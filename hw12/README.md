HW 1
• Understand how this class works.
• It generates prime numbers in between two input
numbers (from and to)
– Class PrimeGenerator {
protected long from, to;
protected LinkedList<Long> primes;
public void generatePrimes(){ ... }
public LinkedList<Long> getPrimes(){ return primes }; ...
• Client code (test case)
• PrimeGenerator gen = new PrimeGenerator(1, 10); gen.generatePrimes();
Long[] expectedPrimes = {2L, 3L, 5L, 7L}; assertArrayEquals( expectedPrimes,
-
2:
PrimeGenerator
  gen.getPrimes().toArray() );

  • PlacePrimeGeneratorinthepackageedu.umb.cs680.hw01 • ImplementPrimeGeneratorTestinthepackage
edu.umb.cs680.hw01
– Write more than one test method • Test a regular case (positive test)
– UseassertArrayEquals()
• Test error cases where wrong ranges are given (negative test)
– e.g., [-10, 10], [100, 1]
– You can name test methods as you like. Make sure to give them specific (not vague) names.
• Placesourcecodefilesandbinaryfilesindifferent
directories.
– <proj dir>/src/edu/umb/cs680/hw01/PrimeGenerator.java
– <proj dir>/src/edu/umb/cs680/hw01/PrimeGeneratorTest.java – <proj dir>/bin/edu/umb/cs680/hw01/PrimeGenerator.class
– <proj dir>/bin/edu/umb/cs680/hw01/PrimeGeneratorTest.class