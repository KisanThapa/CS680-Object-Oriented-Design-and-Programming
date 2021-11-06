package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTest {

    private String[] carToStringArray(Car c) {
        String[] carArray = {c.getMake(), c.getModel(), Integer.toString(c.getYear())};
        return carArray;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = { "Toyota", "RAV4", "2018" };
        Car actual = new Car("Toyota", "RAV4", 2018);
        assertArrayEquals(expected, carToStringArray(actual));
    }

    @Test
    public void verifyNotNull() {
        Car car = new Car("Honda", "Hornet", 2022);
        assertNotNull(car);
    }
    
    @Test
    public void verifyNotEqualCarWithMakeModelYear() {
        String[] expected = { "Audi", "A3", "2015" };
        Car actual = new Car("Maruti", "800", 2012);
        assertNotEquals(expected, carToStringArray(actual));
    }
}
