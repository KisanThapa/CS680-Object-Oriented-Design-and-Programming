package edu.umb.cs680.hw11;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> usedCars = new ArrayList<>();

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

        System.out.println(car1.getDominationCount());
        System.out.println(car2.getDominationCount());
        System.out.println(car3.getDominationCount());
        System.out.println(car4.getDominationCount());
        System.out.println(car5.getDominationCount());
        System.out.println(car6.getDominationCount());

        usedCars.sort(new PriceComparator());
        usedCars.sort(new ParetoComparator(usedCars));

        System.out.println(usedCars.toString());
    }
}
