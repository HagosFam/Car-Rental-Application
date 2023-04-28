package com.example.CarFleet.jms;


import org.springframework.stereotype.Component;

@Component
public class JMSCarRentalListener {
  //  @JmsListener(destination = "CarRentalMessage")
    public void receiveMessage(final String message) {
        System.out.println("Message recived" + message);
    }

}
