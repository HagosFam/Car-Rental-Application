package com.example.CarRental.domain.dto;

import com.example.CarRental.domain.entity.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationAdapter {
    public static Reservation getReservationFromReservationDTO(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setCustomer(reservationDTO.getCustomer());
        reservation.setLicensePlate(reservationDTO.getLicensePlate());
        reservation.setStartDate(reservationDTO.getStartDate());
        reservation.setReturnDate(reservationDTO.getReturnDate());
        return reservation;
    }

    public static ReservationDTO getReservationDTOFromReservation(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setCustomer(reservation.getCustomer());
        reservationDTO.setLicensePlate(reservation.getLicensePlate());
        reservationDTO.setStartDate(reservation.getStartDate());
        reservationDTO.setReturnDate(reservation.getReturnDate());
        return reservationDTO;
    }

    public static List<ReservationDTO> getReservationDTOListFromReservationList(List<Reservation> reservations) {
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        for (Reservation reser : reservations) {
            reservationDTOS.add(getReservationDTOFromReservation(reser));
        }
        return reservationDTOS;
    }
}
