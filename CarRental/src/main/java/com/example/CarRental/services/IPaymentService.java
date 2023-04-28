package com.example.CarRental.services;

import com.example.CarRental.domain.dto.PaymentDTO;

import java.util.List;

public interface IPaymentService {
    public void payForReservation(String plateNumber);
    public List<PaymentDTO> getAllPaymentInformation();

}
