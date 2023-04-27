package com.example.CarRental.domain.entity;

import com.example.CarRental.domain.dto.CustomerDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private long id;
    private String creditCardNumber;
    private String cvv;
    private BigDecimal amountPaid;
    private String paymentType;
    @ManyToOne
    private Customer customer;

    public Payment() {

    }

    public Payment(String creditCardNumber, String cvv, BigDecimal amountPaid, String paymentType, Customer customer) {
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
        this.amountPaid = amountPaid;
        this.paymentType = paymentType;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
