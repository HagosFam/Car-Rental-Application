package com.example.CarRental.domain.dto;

import com.example.CarRental.domain.entity.Customer;

import java.time.LocalDateTime;

public class ReservationDTO {
    private String licensePlate;
    protected LocalDateTime startDate;
    private LocalDateTime returnDate;
    private Customer customer;

    public ReservationDTO() {

    }

    public ReservationDTO(String licensePlate, LocalDateTime startDate, LocalDateTime returnDate, Customer customer) {
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
