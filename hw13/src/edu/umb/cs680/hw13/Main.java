package edu.umb.cs680.hw13;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> usedCars = new ArrayList<>();

        usedCars.add(new Car("Rav 4", "Toyota", 60, 2015, 5000f));
        usedCars.add(new Car("320i", "BMW", 40, 2018, 35000f));
        usedCars.add(new Car("A3", "Audi", 30, 2021, 40000f));
        usedCars.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
        usedCars.add(new Car("Accord", "Honda", 50, 2016, 27000f));
        usedCars.add(new Car("Accent", "Hyundai", 53, 2013, 15000f));


        usedCars.get(0).setCars(usedCars);
        usedCars.get(0).dominationCount();
        usedCars.get(1).setCars(usedCars);
        usedCars.get(1).dominationCount();
        usedCars.get(2).setCars(usedCars);
        usedCars.get(2).dominationCount();

        System.out.println(usedCars.get(0).getDominationCount());
        System.out.println(usedCars.get(1).getDominationCount());
        System.out.println(usedCars.get(2).getDominationCount());
        
    }
}
