package com.gridnine.flightapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FlightAppApplication {

    public static void main(String[] args) {SpringApplication.run(FlightAppApplication.class, args);

        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println(flights);

        List<Flight> flightsUpToCurrentTime = flights.stream().iterator().next().findFlightsUpToCurrentTime(flights);
        System.out.println(flightsUpToCurrentTime);

        List<Flight> flightsWithArrivalEarlierThanDeparture = flights.stream().iterator().next().findFlightsWithArrivalEarlierThanDeparture(flights);
        System.out.println(flightsWithArrivalEarlierThanDeparture);

        List<Flight> timeSpentOnEarthExceedsTwoHours = flights.stream().iterator().next().findFlightsTimeSpentOnEarthExceedsTwoHours(flights);
        System.out.println(timeSpentOnEarthExceedsTwoHours);

    }

}
