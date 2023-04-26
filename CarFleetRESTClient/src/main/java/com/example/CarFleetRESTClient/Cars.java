package com.example.CarFleetRESTClient;

import java.util.Collection;

public class Cars {
    private Collection<Car> cars;

    public Cars() {

    }
    public Cars(Collection<Car> cars) {
        this.cars = cars;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
