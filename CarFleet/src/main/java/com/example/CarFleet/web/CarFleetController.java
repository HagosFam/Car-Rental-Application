package com.example.CarFleet.web;

import com.example.CarFleet.domain.dto.CarDTO;
import com.example.CarFleet.domain.entity.Car;
import com.example.CarFleet.services.CarFleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CarFleetController {
    @Autowired
    CarFleetService carFleetService;

    List<CarDTO> carsList;

    // creating car
    @PostMapping("/cars")
    public ResponseEntity<?> createCar(@RequestBody CarDTO carDTO) {
        CarDTO carDTO1 = carFleetService.createCar(carDTO);
        return new ResponseEntity<>(carDTO1, HttpStatus.OK);
    }

    // deleting a car
    @DeleteMapping("/cars/{plateNumber}")
    public ResponseEntity<?> removeCar(@PathVariable String plateNumber) {
        carFleetService.removeCar(plateNumber);
        return new ResponseEntity<>("Car deleted successfully", HttpStatus.OK);
    }

    // getting all cars
    @GetMapping("/cars")
    public List<CarDTO> getAllCars() {
       return carFleetService.getAllCars();
    }

    // searching by brand
    @GetMapping("/cars/{brand}")
    public List<CarDTO> getOneBrand(@PathVariable String brand) {
        carsList= carFleetService.searchCarByBrand(brand);
        return carsList;
    }

    @GetMapping("/cars/count/{brand}")
    public Integer getOneBrandCount(@PathVariable String brand) {
        carsList= carFleetService.searchCarByBrand(brand);
        return carsList.size();
    }

}
