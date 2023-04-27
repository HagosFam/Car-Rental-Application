package com.example.CarRental.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String customerNumber;
    private String name;
    private String email;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Reservation> reservationList;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Payment> paymentList;

    public Customer() {

    }

    public Customer(String customerNumber, String name, String email, List<Reservation> reservationList) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.email = email;
        this.reservationList = reservationList;
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
}
