package com.example.CarFleet.services;
import com.example.CarFleet.domain.Adapters.CarAdapter;
import com.example.CarFleet.domain.dto.CarDTO;
import com.example.CarFleet.domain.entity.Car;
import com.example.CarFleet.jms.JMSSender;
import com.example.CarFleet.logging.Logger;
import com.example.CarFleet.repositories.CarFleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

 //   To do list
 //     - 	Car fleet application. When you receive a JMS message, the availability for this car is decremented

    @Override
    public CarDTO createCar(CarDTO carDTO) {
        Car car = CarAdapter.changeFromCarDTOToCar(carDTO);
        carFleetRepository.save(car);
        logger.log("Car added successfully with plate number ");
        jmsSender.sendMessage("Car creation message");
        return CarAdapter.changeFromCarToCarDTO(car);
    }
    @Override
    public CarDTO getSingleCar(String plateNumber) {
       Car car = carFleetRepository.findByPlateNumber(plateNumber);
       return CarAdapter.changeFromCarToCarDTO(car);

    }

    @Override
    public void removeCar(String plateNumber) {
        carFleetRepository.deleteById(plateNumber);
    }

    @Override
    public CarDTO updateCar(String plateNumber, CarDTO input) {
       Car car = carFleetRepository.findByPlateNumber(plateNumber);
       if(car !=null){
           car.setReserved(input.isReserved());
           car.setPickStatus(input.getPickStatus());
           car.setPrice(input.getPrice());
           car.setType(input.getType());
           car.setBrand(input.getBrand());
       }
       else {
           return null;
       }
       // publish event here
        return CarAdapter.changeFromCarToCarDTO(car);
    }

    @Override
    public List<CarDTO> searchCarByPrice(double price) {
        List<Car> cars = carFleetRepository.findByPrice(price);
        return CarAdapter.getCarDTOListFromCarList(cars);
    }

    @Override
    public List<CarDTO> searchCarByType(String type) {
        List<Car> cars = carFleetRepository.findByType(type);
        return CarAdapter.getCarDTOListFromCarList(cars);
    }

    @Override
    public List<CarDTO> searchCarByBrand(String brand) {
        List<Car> cars = carFleetRepository.findByBrand(brand);
        return CarAdapter.getCarDTOListFromCarList(cars);
    }

    @Override
    public List<CarDTO> getAllCars() {
     List<Car> cars =  carFleetRepository.findAll();
     return CarAdapter.getCarDTOListFromCarList(cars);
    }

}
