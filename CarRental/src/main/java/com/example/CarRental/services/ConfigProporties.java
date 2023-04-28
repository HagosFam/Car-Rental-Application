package com.example.CarRental.services;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties(prefix = "myapp.config")
public class ConfigProporties {
    private String carFleetUrl;
    private String maxReservation;

}
