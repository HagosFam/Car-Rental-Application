package com.example.CarRental.services;

import com.example.CarRental.domain.dto.ReservationAdapter;
import com.example.CarRental.domain.dto.ReservationDTO;
import com.example.CarRental.domain.entity.Reservation;
import com.example.CarRental.jms.JMSSender;
import com.example.CarRental.logging.Logger;
import com.example.CarRental.repositories.CustomerRepository;
import com.example.CarRental.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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
    @Transactional
    public Reservation saveReservation(Reservation reservation) {
       String licensePlate =  reservation.getLicensePlate();
       // the car in car fleet with license plate, has to be reserved.
        jmsSender.sendMessage(licensePlate);
        logger.log("Car Reservation Successful");
        return reservationRepository.save(reservation);

    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

//    public Optional<ReservationDTO> getReservationById(long id) {
//        Optional<Reservation> oreservation=  reservationRepository.findById(id);
//        return Optional.of(ReservationAdapter.getReservationDTOFromReservation(oreservation));
//    }

//    public Consumer<? super ReservationDTO> deleteReservation(Optional<ReservationDTO> reservation) {
//        reservationRepository.delete(reservation);
//        return null;
//    }

    @Override
    public ResponseEntity<ReservationDTO> reserveCar(String customerNumber, ReservationDTO reservationDTO) {
        return null;
    }

    @Override
    public void pickUpCar(String plateNumber) {

        // update the pick status to 'Picked'

    }

    @Override
    public void returnCar(String plateNumber) {

    }
}
