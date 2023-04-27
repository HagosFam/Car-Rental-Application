package com.example.CarRental.services;

import com.example.CarRental.domain.dto.CustomerDTO;
import com.example.CarRental.domain.dto.ReservationDTO;
import org.springframework.http.ResponseEntity;

public interface IReservationService {
    // reserve a car
    public ResponseEntity<ReservationDTO> reserveCar(String customerNumber, ReservationDTO reservationDTO);
    // send message when car is reserved
    // anytime the car is reserved, the availabiliy of the car is decremented


    public void pickUpCar(String plateNumber);
    // pick up car
    // pick status becomes picked


    public void returnCar(String plateNumber);
    // return car
    // pays when the car is returned
    // the pay method is called from reservation service

}
