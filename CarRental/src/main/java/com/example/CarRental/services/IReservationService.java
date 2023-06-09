package com.example.CarRental.services;

import com.example.CarRental.domain.dto.CustomerDTO;
import com.example.CarRental.domain.dto.PaymentDTO;
import com.example.CarRental.domain.dto.ReservationDTO;

public interface IReservationService {
    // reserve a car
    public void reserveCar(String plateNumber, CustomerDTO customerDTO);
    // send message when car is reserved
    // anytime the car is reserved, the availabiliy of the car is decremented


    public void pickUpCar(String plateNumber);
    // pick up car
    // pick status becomes picked


    public void returnCar(String plateNumber, CustomerDTO customerDTO);
    // return car
    // pays when the car is returned
    // the pay method is called from reservation service

}
