package com.example.CarRental.domain.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;

public class Car {
    @Id
    private String plateNumber;
    private String type;
    private String brand;
    private double price;
    private boolean reserved;
    private String pickStatus;

    public void setPickStatus(String pickStatus) {
        this.pickStatus = pickStatus;
    }

    public String getPickStatus() {
        return pickStatus;
    }


    public Car() {
    }

    public Car(String plateNumber, String type, String brand, double price, boolean reserved, String pickStatus) {
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

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getreserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", reserved=" + reserved +
                ", pickStatus='" + pickStatus + '\'' +
                '}';
    }
}
