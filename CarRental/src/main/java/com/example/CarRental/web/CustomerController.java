package com.example.CarRental.web;

import com.example.CarRental.domain.dto.CustomerDTO;
import com.example.CarRental.domain.entity.Car;
import com.example.CarRental.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    // searching car
    // this controller is set to print car based on its platenumber
    @GetMapping("/car/{plateNumber}")
    public Car searchCar(@PathVariable("plateNumber") String plateNumber) {
        Car car = customerService.searchCars(plateNumber);
        return car;
    }

    // Creating customers
    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerDTO1 = customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(customerDTO1, HttpStatus.OK);
    }

    // get one customer
    @GetMapping("/customer/{customerNumber}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable String customerNumber) {
        CustomerDTO customer = customerService.getOneCustomer(customerNumber);
        return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
    }

    // get all customers
    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
      List<CustomerDTO> customers =   customerService.getAllCustomerInformation();
      return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // delete customer
    @DeleteMapping("/customer/{customerNumber}")
    public boolean deleteCustomer(@PathVariable String customerNumber) {
        boolean remove = customerService.removeCustomer(customerNumber);
        if (remove)
            return true;
        else
            return false;
    }

    // update customer
    @PutMapping("/customer/{customerNumber}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("customerNumber") String customerNumber, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO customerD = customerService.updateCustomer(customerNumber,  customerDTO);
        if(customerD!=null)
            return new ResponseEntity<CustomerDTO>(customerD, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}