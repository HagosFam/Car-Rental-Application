package com.example.CarRental.domain.dto;

import com.example.CarRental.domain.entity.Reservation;

import javax.persistence.OneToMany;
import java.util.List;

public class CustomerDTO {
    private String customerNumber;
    private String name;
    private String email;
    List<Reservation> reservationList;

public CustomerDTO() {

}
    public CustomerDTO( String customerNumber, String name, String email, List<Reservation> reservationList) {
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
