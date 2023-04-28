package com.example.CarRental.web;

import com.example.CarRental.domain.dto.CustomerDTO;
import com.example.CarRental.domain.dto.PaymentDTO;
import com.example.CarRental.domain.dto.ReservationDTO;
import com.example.CarRental.domain.entity.Customer;
import com.example.CarRental.domain.entity.Reservation;
import com.example.CarRental.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/reservations")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PutMapping("/reservations/reserve/{plateNumber}")
    public ResponseEntity<String> updateCarReservationStatus(@PathVariable String plateNumber, @RequestBody CustomerDTO customerDTO) {
        reservationService.reserveCar(plateNumber, customerDTO);
        return ResponseEntity.ok("Car Reservation status changed to RESERVED");
    }

    @PostMapping("/reservations/pick/{plateNumber}")
    public ResponseEntity<String> updateCarPickStatusStatus(@PathVariable String plateNumber) {
        reservationService.pickUpCar(plateNumber);
        return ResponseEntity.ok("Car Pick Status changed to PICKED");
    }

    @PostMapping("/reservations/return/{plateNumber}")
    public ResponseEntity<String> returnCar(@PathVariable String plateNumber, @RequestBody CustomerDTO customerDTO) {
        reservationService.returnCar(plateNumber, customerDTO);
        return ResponseEntity.ok("Car returned successfully!");
    }



}
