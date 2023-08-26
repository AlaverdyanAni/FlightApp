package com.gridnine.flightapp.exception;

public class FlightHasNoSegmentsException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Flight has no segments!";
    }
}
