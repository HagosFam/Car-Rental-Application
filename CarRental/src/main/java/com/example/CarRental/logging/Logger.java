package com.example.CarRental.logging;

import org.springframework.stereotype.Component;

@Component
public class Logger implements ILogger{
    public void log(String logMessage) {
        java.util.logging.Logger.getLogger("Car Rental Logging").info(logMessage);
    }
}
