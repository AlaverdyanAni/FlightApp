package com.gridnine.flightapp.exception;

public class NoFlightsFoundWithTheseParametersException extends RuntimeException {
    @Override
    public String getMessage() {
        return "No flights found with these parameters!";
    }

}
