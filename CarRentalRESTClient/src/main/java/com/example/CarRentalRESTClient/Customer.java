package com.example.CarRentalRESTClient;

import java.util.List;


public class Customer {

    private String customerNumber;
    private String name;
    private String email;


    private List<Reservation> reservationList;


    private List<Payment> paymentList;

    public Customer() {

    }

    public Customer(String customerNumber, String name, String email, List<Reservation> reservationList, List<Payment> paymentList) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.email = email;
        this.reservationList = reservationList;
        this.paymentList = paymentList;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber='" + customerNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", reservationList=" + reservationList +
                ", paymentList=" + paymentList +
                '}';
    }
}
