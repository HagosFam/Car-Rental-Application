package com.example.CarRental.services;

import com.example.CarRental.domain.dto.CustomerDTO;
import com.example.CarRental.domain.entity.Car;

import java.util.List;

public interface ICustomerService {
    // searching cars
    public Car searchCars(String plateNumber);

    // add customer
    public  CustomerDTO addCustomer(CustomerDTO customerDTO);
    // remove customer
    public boolean removeCustomer(String customerNumber);
    // update customer
    public CustomerDTO updateCustomer(String customerNumber, CustomerDTO customerDTO);

    //  get all customer data including reservation, payments made, rental history
    public List<CustomerDTO> getAllCustomerInformation();
      // Use scheduling so that the application prints every 20 seconds over of all cars

    //get one customer
    public CustomerDTO getOneCustomer(String customerNumber);

    public Car getAllCars();

}
