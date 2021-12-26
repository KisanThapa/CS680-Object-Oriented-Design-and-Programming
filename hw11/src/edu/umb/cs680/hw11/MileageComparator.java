package edu.umb.cs680.hw11;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car2.getMileage() - car1.getMileage();
    }
}
