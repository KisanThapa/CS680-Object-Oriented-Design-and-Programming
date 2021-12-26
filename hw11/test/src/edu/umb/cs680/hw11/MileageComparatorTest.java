package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MileageComparatorTest {

    static ArrayList<Car> usedCars = new ArrayList<>();

    @BeforeAll
    public static void testSetup() {

        usedCars.add(new Car("Rav 4", "Toyota", 60, 2015, 5000f));
        usedCars.add(new Car("320i", "BMW", 40, 2018, 35000f));
        usedCars.add(new Car("A3", "Audi", 30, 2021, 40000f));
        usedCars.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
        usedCars.add(new Car("Accord", "Honda", 50, 2016, 27000f));
        usedCars.add(new Car("Accent", "Hyundai", 53, 2013, 15000f));


        // Applying mileage comparator
        Collections.sort(usedCars, new MileageComparator());

    }

    @Test
    public void mileageSort() {
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        expected.add(60);
        expected.add(53);
        expected.add(50);
        expected.add(45);
        expected.add(40);
        expected.add(30);

        for (Car c : usedCars)
            actual.add(c.getMileage());

        assertEquals(actual, expected);
    }

    @Test
    public void testFirstCar() {
        String expected = (new Car("Rav 4", "Toyota", 60, 2015, 5000f)).toString();
        String actual = usedCars.get(0).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testSecondCar() {
        String expected = (new Car("Accent", "Hyundai", 53, 2013, 15000f)).toString();
        String actual = usedCars.get(1).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testThirdCar() {
        String expected = (new Car("Accord", "Honda", 50, 2016, 27000f)).toString();
        String actual = usedCars.get(2).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testFourthCar() {
        String expected = (new Car("Acadia", "GMC", 45, 2017, 25000f)).toString();
        String actual = usedCars.get(3).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testFifthCar() {
        String expected = (new Car("320i", "BMW", 40, 2018, 35000f)).toString();
        String actual = usedCars.get(4).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testSixthCar() {
        String expected = (new Car("A3", "Audi", 30, 2021, 40000f)).toString();
        String actual = usedCars.get(5).toString();

        assertEquals(expected, actual);
    }

}
