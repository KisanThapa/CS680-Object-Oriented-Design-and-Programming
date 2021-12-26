package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {

    public ParetoComparator(ArrayList<Car> cars) {
        for (Car c : cars)
            c.setCars(cars);
    }

    @Override
    public int compare(Car car1, Car car2) {
        return car2.getDominationCount() - car1.getDominationCount();
    }
}
