package com.example.CarRental.domain.dto;

import com.example.CarRental.domain.entity.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentAdapter {
    public static Payment getPaymentFromPaymentDTO(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setPaymentType(paymentDTO.getPaymentType());
        payment.setCvv(paymentDTO.getCvv());
        payment.setAmountPaid(paymentDTO.getAmountPaid());
        payment.setCreditCardNumber(paymentDTO.getCreditCardNumber());
        payment.setCustomer(paymentDTO.getCustomer());
        return payment;
    }

    public static PaymentDTO getPaymentDTOFromPayment(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setAmountPaid(payment.getAmountPaid());
        paymentDTO.setPaymentType(payment.getPaymentType());
        paymentDTO.setCvv(payment.getCvv());
        paymentDTO.setCreditCardNumber(payment.getCreditCardNumber());
        paymentDTO.setCustomer(payment.getCustomer());
        return paymentDTO;
    }

    public static List<PaymentDTO> getPaymentDTOListFromPayment(List<Payment> paymentList) {
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        for (Payment pay : paymentList) {
            paymentDTOS.add(getPaymentDTOFromPayment(pay));
        }
        return paymentDTOS;
    }


}
