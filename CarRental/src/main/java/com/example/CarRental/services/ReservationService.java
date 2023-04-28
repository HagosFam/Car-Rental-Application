package com.example.CarRental.services;

import com.example.CarRental.domain.dto.*;
import com.example.CarRental.domain.entity.Car;
import com.example.CarRental.domain.entity.Customer;
import com.example.CarRental.domain.entity.Payment;
import com.example.CarRental.domain.entity.Reservation;
import com.example.CarRental.jms.JMSSender;
import com.example.CarRental.logging.Logger;
import com.example.CarRental.repositories.CustomerRepository;
import com.example.CarRental.repositories.PaymentRepository;
import com.example.CarRental.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ReservationService implements IReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    Logger logger;

    @Autowired
    JMSSender jmsSender;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PaymentRepository paymentRepository;

    private String serverUrl = "http://localhost:8070/";
    RestTemplate restTemplate = new RestTemplate();

    //@Transactional
    public Reservation saveReservation(Reservation reservation) {
        String licensePlate = reservation.getLicensePlate();
        // the car in car fleet with license plate,
        jmsSender.sendMessage(licensePlate);
        logger.log("Car Reservation Successful");
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }


    @Transactional
    public void reserveCar(String plateNumber, CustomerDTO customerDTO) {
        // two things,
           // reserve status update on car fleet
                   ReservationDTO reservationDTO = new ReservationDTO();
                   reservationDTO.setCustomer(customerRepository.findByCustomerNumber(customerDTO.getCustomerNumber()));
                   reservationDTO.setLicensePlate(plateNumber);
                   Reservation reserve = ReservationAdapter.getReservationFromReservationDTO(reservationDTO);
                   saveReservation(reserve);

        // getting the car
        ResponseEntity<Car> response = restTemplate.getForEntity(serverUrl+"car/"+plateNumber, Car.class);
        Car car = response.getBody(); // get the array of cars from the response

        // updating the car status
        car.setReserved(true);
        // Send the updated car object to the other application to be saved
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Car> requestEntity = new HttpEntity<>(car, headers);
        restTemplate.exchange(serverUrl +"carReserve/"+ plateNumber, HttpMethod.PUT, requestEntity, String.class);
    }


    public void pickUpCar(String plateNumber) {
        // pick up car
        // pick status becomes picked
        ResponseEntity<Car> response = restTemplate.getForEntity(serverUrl+"car/"+plateNumber, Car.class);
        Car car = response.getBody(); // get the array of cars from the response

        // Update only the name field of the car object
        car.setPickStatus("Picked");
        // Send the updated car object to the other application to be saved
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Car> requestEntity = new HttpEntity<>(car, headers);
        restTemplate.exchange(serverUrl +"carReserve/"+ plateNumber, HttpMethod.PUT, requestEntity, String.class);
    }


    public void returnCar(String plateNumber, CustomerDTO customerDTO) {
        // pays when the car is returned
        // the pay method is called from reservation service
        System.out.println("first round, paying for reservation");
        Payment payment = new Payment();
        payment.setPaymentType("Credit Card");
        payment.setCvv("343");
        payment.setAmountPaid(new BigDecimal(2343.3));
        payment.setCreditCardNumber("234h343");
        Customer cust = CustomerAdapter.getCustomerFromCustomerDTO(customerDTO);
        payment.setCustomer(cust);
        paymentRepository.save(payment);

        // then return car
        ResponseEntity<Car> response = restTemplate.getForEntity(serverUrl+"car/"+plateNumber, Car.class);
        Car car = response.getBody(); // get the array of cars from the response

        // set the car status returned
        car.setPickStatus("InStore");
        // Send the updated car object to the other application to be saved
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Car> requestEntity = new HttpEntity<>(car, headers);
        restTemplate.exchange(serverUrl +"carReserve/"+ plateNumber, HttpMethod.PUT, requestEntity, String.class);




    }


}
