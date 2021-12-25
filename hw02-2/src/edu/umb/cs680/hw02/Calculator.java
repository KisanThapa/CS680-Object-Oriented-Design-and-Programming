package edu.umb.cs680.hw02;

public class Calculator {

	public float add(float x, float y) {
		return x + y;
	}

	public float minus(float x, float y) {
		return x - y;
	}

	public float multipy(float x, float y) {
		return x * y;
	}

	public float divide(float x, float y) {
		if (y == 0)
			throw new IllegalArgumentException("division by zero");
		return x / y;
	}

	public static void main(String[] args) {

	}

}
