package com.example.CarFleet.services;

import com.example.CarFleet.domain.Adapters.CarAdapter;
import com.example.CarFleet.domain.dto.CarDTO;
import com.example.CarFleet.domain.entity.Car;
import com.example.CarFleet.jms.JMSSender;
import com.example.CarFleet.logging.Logger;
import com.example.CarFleet.repositories.CarFleetRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CarFleetService implements ICarFleetService {
    @Autowired
    private CarFleetRepository carFleetRepository;
    @Autowired
    private JMSSender jmsSender;

    @Autowired
    private Logger logger;

    public CarDTO createCar(CarDTO carDTO) {
        Car car = CarAdapter.changeFromCarDTOToCar(carDTO);
        carFleetRepository.save(car);
        logger.log("Car added successfully with plate number ");
        jmsSender.sendMessage("Message will be send with this one, just beautiful");
        return CarAdapter.changeFromCarToCarDTO(car);
    }

    public void removeCar(String plateNumber) {
        carFleetRepository.deleteById(plateNumber);
    }

    public CarDTO updateCar(String plateNumber, String type, String brand, double price, boolean reserved) {
        Car car = new Car(plateNumber, type, brand, price, reserved);


        return CarAdapter.changeFromCarToCarDTO(car);
    }

    public List<CarDTO> searchCarByPrice(double price) {
        List<Car> cars = carFleetRepository.findByPrice(price);
        return CarAdapter.getCarDTOListFromCarList(cars);
    }

    public List<CarDTO> searchCarByType(String type) {
        List<Car> cars = carFleetRepository.findByType(type);
        return CarAdapter.getCarDTOListFromCarList(cars);
    }

    public List<CarDTO> searchCarByBrand(String brand) {
        List<Car> cars = carFleetRepository.findByBrand(brand);
        return CarAdapter.getCarDTOListFromCarList(cars);
    }

    public List<CarDTO> getAllCars() {
     List<Car> cars =  carFleetRepository.findAll();
     return CarAdapter.getCarDTOListFromCarList(cars);
    }

}
