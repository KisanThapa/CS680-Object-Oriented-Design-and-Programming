package edu.umb.cs680.hw11;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return (int) (car2.getPrice() - car1.getPrice());
    }
}
