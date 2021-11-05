package edu.umb.cs680.hw02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void add5And7() {
		Calculator calculator = new Calculator();

		float expected = 12f;
		float actual = calculator.add(5, 7);

		assertEquals(expected, actual, 0.1f);

	}

	@Test
	public void minus12And4() {
		Calculator calculator = new Calculator();
		float expected = 8f;
		float actual = calculator.minus(12, 4);

		assertEquals(expected, actual, 0.1f);
	}

	@Test
	public void multiply2By3() {
		Calculator calculator = new Calculator();
		float expected = 6f;
		float actual = calculator.multipy(2, 3);

		assertEquals(expected, actual, 0.1f);
	}

	@Test
	public void divide16By8() {
		Calculator calculator = new Calculator();
		float expected = 2f;
		float actual = calculator.divide(16, 8);

		assertEquals(expected, actual, 0.1f);
	}

	@Test
	public void divide4By0() {
		Calculator calculator = new Calculator();

		try {
			calculator.divide(4, 0);
			fail("Division by zero");
		} catch (IllegalArgumentException ex) {
			assertEquals("division by zero", ex.getMessage());
		}
	}
}
