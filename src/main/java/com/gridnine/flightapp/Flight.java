package com.gridnine.flightapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flight implements  FlightInterface {
    private List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(segments, flight.segments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segments);
    }

    @Override
    public String toString() {
        return "Flight " +
                segments + "\n";
    }

    @Override
    public List<Flight> findFlightsUpToCurrentTime(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream().iterator().next().getArrival().isBefore(LocalDateTime.now())).toList();
    }
        //List<Flight> findFlights = new ArrayList<>();
        //for (Flight flight:flights){
        //    for (int i = 0; i <flight.getSegments().size()-1 ; i++) {
        //        if (flight.getSegments().get(i).getArrival().isBefore(LocalDateTime.now())) {
        //           findFlights.add(flight);}}}
        //  return findFlights;}

    @Override
    public List<Flight> findFlightsWithArrivalEarlierThanDeparture(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().iterator().next().getDeparture().isBefore(flight.getSegments().iterator().next().getArrival())).toList();
    }
        //List<Flight> findFlights = new ArrayList<>();
        // for (Flight flight : flights) {
        //    for (int i = 0; i < flight.getSegments().size()-1; i++) {
        //        if (flight.getSegments().get(i).getDeparture().isBefore(flight.getSegments().get(i).getArrival())) {
        //            findFlights.add(flight);
        //        }}}
        //return findFlights;}

    @Override
    public List<Flight> findFlightsTimeSpentOnEarthExceedsTwoHours(List<Flight> flights) {
        List<Flight> findFlights = new ArrayList<>();
        for (Flight flight : flights) {
            for (int i = 0; i < flight.getSegments().size()-1; i++) {
                if (flight.getSegments().get(i + 1).getArrival().getHour() - flight.getSegments().get(i).getDeparture().getHour() > 2) {
                    findFlights.add(flight);
                }
            }
        }
        return findFlights;
    }
}



