package com.example.CarRentalRESTClient;

import java.time.LocalDateTime;


public class Reservation {
    private long id;
    private String licensePlate;
    private LocalDateTime startDate;
    private LocalDateTime returnDate;

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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", startDate=" + startDate +
                ", returnDate=" + returnDate +
                ", customer=" + customer +
                '}';
    }
}
