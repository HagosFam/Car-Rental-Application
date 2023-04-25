package com.example.CarFleet.jms;

import org.springframework.stereotype.Service;

@Service
public class JMSSender implements IJMSSender {
    public void sendMessage(String message) {
        System.out.println("Sending message from car fleet application" + message);
    }
}
