package com.example.CarFleet.logging;

import org.springframework.stereotype.Service;

@Service
public class Logger implements  ILogger{
    public void log(String log) {
        java.util.logging.Logger.getLogger("CarFleetLogging").info(log);
    }
}
