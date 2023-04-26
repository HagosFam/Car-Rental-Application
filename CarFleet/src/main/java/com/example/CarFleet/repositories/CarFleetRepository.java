package com.example.CarFleet.repositories;

import com.example.CarFleet.domain.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarFleetRepository extends MongoRepository<Car, String> {
    public List<Car> findByType(String type);
    public List<Car> findByBrand(String brand);
    public List<Car> findByPrice(double price);

}
