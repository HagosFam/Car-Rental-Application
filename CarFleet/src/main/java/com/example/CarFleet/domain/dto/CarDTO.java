package com.example.CarFleet.domain.dto;

import org.springframework.beans.factory.annotation.Value;

public class CarDTO {
    private String plateNumber;
    private String type;
    private String brand;
    private double price;
    private boolean reserved;
    @Value("inStore")
    private String pickStatus;

    public CarDTO() {

    }
    public CarDTO(String plateNumber, String type, String brand, double price, int quantity, boolean reserved,String pickStatus) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.reserved = reserved;
        this.pickStatus = pickStatus;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getPickStatus() {
        return pickStatus;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setPickStatus(String pickStatus) {
        this.pickStatus = pickStatus;
    }
}