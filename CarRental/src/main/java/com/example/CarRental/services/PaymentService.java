package com.example.CarRental.services;

import com.example.CarRental.domain.dto.CustomerAdapter;
import com.example.CarRental.domain.dto.CustomerDTO;
import com.example.CarRental.domain.dto.PaymentAdapter;
import com.example.CarRental.domain.dto.PaymentDTO;
import com.example.CarRental.domain.entity.Customer;
import com.example.CarRental.domain.entity.Payment;
import com.example.CarRental.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public void payForReservation(String plateNumber) {
    }

    @Override
    public List<PaymentDTO> getAllPaymentInformation() {
        List<Payment> paymentList = paymentRepository.findAll();
        return PaymentAdapter.getPaymentDTOListFromPayment(paymentList);
    }
}
