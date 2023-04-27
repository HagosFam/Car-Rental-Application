package com.example.CarRental.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JMSSender implements IJMSSender {
   // @Autowired
   // jms
    public void sendMessage(String message) {
        System.out.println("Sending message from car fleet application" + message);
    }
}
