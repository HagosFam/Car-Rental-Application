package com.example.CarRental.web;

import com.example.CarRental.domain.dto.CustomerDTO;
import com.example.CarRental.domain.dto.PaymentDTO;
import com.example.CarRental.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentDTO>> getAllCustomers() {
        List<PaymentDTO> customers =   paymentService.getAllPaymentInformation();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
