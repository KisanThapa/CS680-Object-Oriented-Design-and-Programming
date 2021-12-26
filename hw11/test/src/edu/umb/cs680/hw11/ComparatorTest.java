package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTest {

    ArrayList<Car> usedCars = new ArrayList<>();

    @Test
    public void MileageComparator() {
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        usedCars.add(new Car("Rav 4", "Toyota", 60, 2015, 5000f));
        usedCars.add(new Car("320i", "BMW", 40, 2018, 35000f));
        usedCars.add(new Car("A3", "Audi", 30, 2021, 40000f));
        usedCars.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
        usedCars.add(new Car("Accord", "Honda", 50, 2016, 27000f));
        usedCars.add(new Car("Accent", "Hyundai", 53, 2016, 15000f));


        Collections.sort(usedCars, new MileageComparator());

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
    public void PriceComparator() {
        ArrayList<Float> actual = new ArrayList<>();
        ArrayList<Float> expected = new ArrayList<>();

        usedCars.add(new Car("Rav 4", "Toyota", 60, 2015, 5000f));
        usedCars.add(new Car("320i", "BMW", 40, 2018, 35000f));
        usedCars.add(new Car("A3", "Audi", 30, 2021, 40000f));
        usedCars.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
        usedCars.add(new Car("Accord", "Honda", 50, 2016, 27000f));
        usedCars.add(new Car("Accent", "Hyundai", 53, 2016, 15000f));

        Collections.sort(usedCars, new PriceComparator());

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
    public void YearComparator() {
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        usedCars.add(new Car("Rav 4", "Toyota", 60, 2015, 5000f));
        usedCars.add(new Car("320i", "BMW", 40, 2018, 35000f));
        usedCars.add(new Car("A3", "Audi", 30, 2021, 40000f));
        usedCars.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
        usedCars.add(new Car("Accord", "Honda", 50, 2016, 27000f));
        usedCars.add(new Car("Accent", "Hyundai", 53, 2013, 15000f));

        Collections.sort(usedCars, new YearComparator());

        expected.add(2021);
        expected.add(2018);
        expected.add(2017);
        expected.add(2016);
        expected.add(2015);
        expected.add(2013);

        for (Car c : usedCars)
            actual.add(c.getYear());

        assertEquals(actual, expected);
    }

    @Test
    public void ParetoComparator() {
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();

        Car car1 = new Car("Rav 4", "Toyota", 60, 2015, 5000f);
        Car car2 = new Car("320i", "BMW", 40, 2018, 35000f);
        Car car3 = new Car("A3", "Audi", 30, 2021, 40000f);
        Car car4 = new Car("Acadia", "GMC", 45, 2017, 25000f);
        Car car5 = new Car("Accord", "Honda", 50, 2016, 27000f);
        Car car6 = new Car("Accent", "Hyundai", 53, 2016, 15000f);

        usedCars.add(car1);
        usedCars.add(car2);
        usedCars.add(car3);
        usedCars.add(car4);
        usedCars.add(car5);
        usedCars.add(car6);

        car1.setCars(usedCars);
        car2.setCars(usedCars);
        car3.setCars(usedCars);
        car4.setCars(usedCars);
        car5.setCars(usedCars);
        car6.setCars(usedCars);

        car1.dominationCount();
        car2.dominationCount();
        car3.dominationCount();
        car4.dominationCount();
        car5.dominationCount();
        car6.dominationCount();


        Collections.sort(usedCars, new ParetoComparator(usedCars));

        expected.add(1);
        expected.add(1);
        expected.add(1);
        expected.add(1);
        expected.add(1);
        expected.add(1);

        for (Car c : usedCars) {
            actual.add(c.getDominationCount());
        }
        assertEquals(actual, expected);
    }
}
