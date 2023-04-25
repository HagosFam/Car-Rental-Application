package com.example.CarFleet.services;

import com.example.CarFleet.domain.dto.CarDTO;

import java.util.Collection;
import java.util.List;

public interface ICarFleetService {
    public CarDTO createCar(CarDTO carDTO);

    public void removeCar(String plateNumber);

    public CarDTO updateCar(String plateNumber, String type, String brand, double price);

    public List<CarDTO> searchCarByPrice(double price);
    public List<CarDTO> searchCarByBrand(String brand);
    public List<CarDTO> searchCarByType(String type);

    public Collection<CarDTO> getAllCars();

}
