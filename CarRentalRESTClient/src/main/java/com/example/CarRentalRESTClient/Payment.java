package com.example.CarRentalRESTClient;

import java.math.BigDecimal;
public class Payment {

    private long id;
    private String creditCardNumber;
    private String cvv;
    private BigDecimal amountPaid;
    private String paymentType;

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

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", cvv='" + cvv + '\'' +
                ", amountPaid=" + amountPaid +
                ", paymentType='" + paymentType + '\'' +
                ", customer=" + customer +
                '}';
    }
}
