package com.example.CarRental.services;

import com.example.CarRental.domain.dto.CustomerAdapter;
import com.example.CarRental.domain.dto.CustomerDTO;
import com.example.CarRental.domain.entity.Car;
import com.example.CarRental.domain.entity.Customer;
import com.example.CarRental.jms.JMSSender;
import com.example.CarRental.logging.Logger;
import com.example.CarRental.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    Logger logger;
    @Autowired
    JMSSender jmsSender;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    RestTemplate restTemplate = new RestTemplate();
    private String serverUrl = "http://localhost:8070/car/";

    // using value from application proporties
//    @Value("${carFleetUrl}")
//    private String serverUrl;

    //get single car
    @Override
    public Car searchCars(String plateNumber) {
        ResponseEntity<Car> response = restTemplate.getForEntity(serverUrl + plateNumber, Car.class);
        Car car = response.getBody(); // get the array of cars from the response
        return car;
    }

    @Override
    public Car getAllCars() {
        return null;
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerAdapter.getCustomerFromCustomerDTO(customerDTO);
        customerRepository.save(customer);
        logger.log("Customer created");
        jmsSender.sendMessage("Car creation message");
        return CustomerAdapter.getCustomerDTOFromCustomer(customer);
    }


    @Override
    public CustomerDTO getOneCustomer(String customerNumber) {
        Customer customer = customerRepository.findByCustomerNumber(customerNumber);
        return CustomerAdapter.getCustomerDTOFromCustomer(customer);
    }


    @Override
    public boolean removeCustomer(String customerNumber) {
        Customer customer = customerRepository.findByCustomerNumber(customerNumber);
        if (customer != null) {
            customerRepository.delete(customer);
            return true;
        } else {
            System.out.println("No customer found");
        }
        return false;
    }

    @Override
    public CustomerDTO updateCustomer(String customerNumber, CustomerDTO customerDTO) {
        Customer foundCustomer = customerRepository.findByCustomerNumber(customerNumber);
        if (foundCustomer != null) {
            foundCustomer.setName(customerDTO.getName());
            foundCustomer.setReservationList(customerDTO.getReservationList());
            foundCustomer.setPaymentList(customerDTO.getPaymentList());
            foundCustomer.setEmail(customerDTO.getEmail());
        } else {
            return null;
        }
        return CustomerAdapter.getCustomerDTOFromCustomer(foundCustomer);
    }

    @Override
    public List<CustomerDTO> getAllCustomerInformation() {
        List<Customer> customers = customerRepository.findAll();
        return CustomerAdapter.getListCustomerDTOFromCustomerList(customers);
    }

    // sending email
    // count number of cars and if it is less than 3, send an email


    public void countCarsEvent(CountCarEvent event) {
        // count cars here
        if (6 < 9) {
            System.out.println("Sending email event to fleet manager" + event);
            eventPublisher.publishEvent(new CountCarEvent("Hey Fleet manager, Number of cars is less than 3"));
        }

    }

    @Scheduled(fixedRate = 20000)
    public void printCarsStatus() {
        ResponseEntity<Car[]> response = restTemplate.getForEntity("http://localhost:8070/allCars", Car[].class);
        Car[] cars = response.getBody();
        System.out.println("Printing status of all cars");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
