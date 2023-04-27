package com.example.CarRental.domain.entity;


import java.math.BigDecimal;

public class Car {
    private String plateNumber;
    private String type;
    private String brand;
    private BigDecimal price;
    private boolean reserved;

    public Car() {
    }

    public Car(String plateNumber, String type, String brand, BigDecimal price, boolean reserved) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.reserved = reserved;
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

    public BigDecimal getPrice() {
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

    public void setPrice(BigDecimal price) {
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
                '}';
    }
}