package com.example.CarRental.services;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class EventListender {
    @EventListener
    public void onEvent(CountCarEvent event) {
        System.out.println("Emailing to fleet manager " + event);
    }
}
