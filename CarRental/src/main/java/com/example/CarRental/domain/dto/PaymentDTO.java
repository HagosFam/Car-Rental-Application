package com.example.CarRental.domain.dto;

import java.math.BigDecimal;

public class PaymentDTO {
    private String creditCardNumber;
    private String cvv;
    private BigDecimal amountPaid;
    private String paymentType;

public PaymentDTO() {

}
    public PaymentDTO(String creditCardNumber, String cvv, BigDecimal amountPaid, String paymentType) {
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
        this.amountPaid = amountPaid;
        this.paymentType = paymentType;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
