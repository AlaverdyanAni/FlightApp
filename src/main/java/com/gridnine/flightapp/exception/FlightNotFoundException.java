package com.gridnine.flightapp.exception;

public class FlightNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Flights not found!";
    }
}
