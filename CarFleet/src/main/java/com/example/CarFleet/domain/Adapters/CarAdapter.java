package com.example.CarFleet.domain.Adapters;

import com.example.CarFleet.domain.dto.CarDTO;
import com.example.CarFleet.domain.entity.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarAdapter {
    public static Car changeFromCarDTOToCar(CarDTO carDTO) {
        Car car = new Car();
        car.setPlateNumber(carDTO.getPlateNumber());
        car.setType(carDTO.getType());
        car.setBrand(carDTO.getBrand());
        car.setPrice(carDTO.getPrice());
        car.setPickStatus(carDTO.getPickStatus());
        car.setReserved(carDTO.isReserved());
        return car;
    }

    public static CarDTO changeFromCarToCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setPlateNumber(car.getPlateNumber());
        carDTO.setType(car.getType());
        carDTO.setBrand(car.getBrand());
        carDTO.setPrice(car.getPrice());
        carDTO.setPickStatus(car.getPickStatus());
        carDTO.setReserved(car.getreserved());
        return carDTO;
    }

    public static List<CarDTO> getCarDTOListFromCarList(List<Car> carList) {
        List<CarDTO> carDTOList = new ArrayList<>();
        for (Car car : carList ) {
            carDTOList.add(changeFromCarToCarDTO(car));
        }
        return carDTOList;
    }
}
