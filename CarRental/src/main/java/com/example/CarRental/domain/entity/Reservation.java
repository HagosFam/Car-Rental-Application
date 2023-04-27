package com.example.CarRental.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private long id;
    private String licensePlate;
    private LocalDateTime startDate;
    private LocalDateTime returnDate;
    @ManyToOne
    private Customer customer;

    public Reservation() {

    }

    public Reservation(String licensePlate, LocalDateTime startDate, LocalDateTime returnDate, Customer customer) {
        this.licensePlate = licensePlate;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.customer = customer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
