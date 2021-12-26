package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceComparatorTest {

    static ArrayList<Car> usedCars = new ArrayList<>();

    @BeforeAll
    public static void testSetup() {

        usedCars.add(new Car("Rav 4", "Toyota", 60, 2015, 5000f));
        usedCars.add(new Car("320i", "BMW", 40, 2018, 35000f));
        usedCars.add(new Car("A3", "Audi", 30, 2021, 40000f));
        usedCars.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
        usedCars.add(new Car("Accord", "Honda", 50, 2016, 27000f));
        usedCars.add(new Car("Accent", "Hyundai", 53, 2013, 15000f));

        // Using LE for price comparator logic
        Collections.sort(usedCars, (Car car1, Car car2) -> (int) (car2.getPrice() - car1.getPrice()));

    }

    @Test
    public void priceSort() {
        ArrayList<Float> actual = new ArrayList<>();
        ArrayList<Float> expected = new ArrayList<>();

        expected.add(40000f);
        expected.add(35000f);
        expected.add(27000f);
        expected.add(25000f);
        expected.add(15000f);
        expected.add(5000f);

        for (Car c : usedCars)
            actual.add(c.getPrice());

        assertEquals(actual, expected);
    }

    @Test
    public void testFirstCar() {
        String expected = (new Car("A3", "Audi", 30, 2021, 40000f)).toString();
        String actual = usedCars.get(0).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testSecondCar() {
        String expected = (new Car("320i", "BMW", 40, 2018, 35000f)).toString();
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
        String expected = (new Car("Accent", "Hyundai", 53, 2013, 15000f)).toString();
        String actual = usedCars.get(4).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void testSixthCar() {
        String expected = (new Car("Rav 4", "Toyota", 60, 2015, 5000f)).toString();
        String actual = usedCars.get(5).toString();

        assertEquals(expected, actual);
    }

}
