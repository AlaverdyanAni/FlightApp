package com.gridnine.flightapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FlightAppApplication {

    public static void main(String[] args) {SpringApplication.run(FlightAppApplication.class, args);

        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("All flights: " + flights);

        List<Flight> flightsUpToCurrentTime = flights.stream().iterator().next().findFlightsUpToCurrentTime(flights);
        System.out.println("Flights up to the current time: " + flightsUpToCurrentTime);

        List<Flight> flightsUpToCurrentTime2 = flights.stream().iterator().next().findFlightsUpToCurrentTime2(flights);
        System.out.println("Flights up to the current time: " + flightsUpToCurrentTime2);

        List<Flight> flightsWithArrivalEarlierThanDeparture = flights.stream().iterator().next().findFlightsWithArrivalEarlierThanDeparture(flights);
        System.out.println("Flights arriving before departure: " + flightsWithArrivalEarlierThanDeparture);

        List<Flight> flightsWithArrivalEarlierThanDeparture2 = flights.stream().iterator().next().findFlightsWithArrivalEarlierThanDeparture2(flights);
        System.out.println("Flights arriving before departure: " + flightsWithArrivalEarlierThanDeparture2);

        List<Flight> timeSpentOnEarthExceedsTwoHours = flights.stream().iterator().next().findFlightsTimeSpentOnEarthExceedsTwoHours(flights);
        System.out.println("Flights, whose time spent on Earth exceeds two hours: " + timeSpentOnEarthExceedsTwoHours);

    }
}
