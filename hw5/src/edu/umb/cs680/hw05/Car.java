package edu.umb.cs680.hw05;

public class Car {

	private String make, model;
	private int mileage, year;
	private float price;

	public Car(String make, String model, int year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getModel() {
		return this.model;
	}

	public String getMake() {
		return this.make;
	}

	public int getYear() {
		return this.year;
	}

	public int getMileage() {
		return this.mileage;
	}

	public float getPrice() {
		return this.price;
	}
}