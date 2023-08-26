package com.gridnine.flightapp.model;

import com.gridnine.flightapp.exception.FlightHasNoSegmentsException;
import com.gridnine.flightapp.exception.FlightNotFoundException;
import com.gridnine.flightapp.exception.NoFlightsFoundWithTheseParametersException;
import com.gridnine.flightapp.service.FlightService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Flight implements  FlightService {
    private List<Segment> segments;

    public Flight(List<Segment> segments) {
        this.segments = segments;
    }

    public Flight() {
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
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
    public List<Flight> findFlightsUpToCurrentTime1(List<Flight> flights) {
        if (flights.isEmpty()) {
            throw new FlightNotFoundException();
        } else {
            List<Flight> findFlights = new ArrayList<>();
            for (Flight flight : flights) {
                if (flight.getSegments().isEmpty()) {
                    throw new FlightHasNoSegmentsException();
                } else {
                    for (Segment segment : flight.getSegments()) {
                        if (segment.getDeparture().isBefore(LocalDateTime.now()) && !findFlights.contains(flight)) {
                            findFlights.add(flight);
                        }
                    }
                }
            }
            if (findFlights.isEmpty()) {
                throw new NoFlightsFoundWithTheseParametersException();
            } else {
                return Collections.unmodifiableList(findFlights);
            }
        }
    }

    @Override
    public List<Flight> findFlightsUpToCurrentTime2(List<Flight> flights) {
        List<Flight> findFlights = new ArrayList<>();
        Iterator<Flight> flightIterator = flights.iterator();
        while (flightIterator.hasNext()) {
            Flight flight = flightIterator.next();
            Iterator<Segment> segmentIterator = flight.getSegments().iterator();
            while (segmentIterator.hasNext()) {
                Segment segment = segmentIterator.next();
                if (segment.getDeparture().isBefore(LocalDateTime.now()) && !findFlights.contains(flight)) {
                    findFlights.add(flight);
                }
            }
        }
        return Collections.unmodifiableList(findFlights);
    }

    @Override
    public List<Flight> findFlightsWithArrivalEarlierThanDeparture1(List<Flight> flights) {
        if (flights.isEmpty()) {
            throw new FlightNotFoundException();
        } else {
            List<Flight> findFlights = new ArrayList<>();
            for (Flight flight : flights) {
                if (flight.getSegments().isEmpty()) {
                    throw new FlightHasNoSegmentsException();
                } else {
                    for (Segment segment : flight.getSegments()) {
                        if (segment.getArrival().isBefore(segment.getDeparture()) && !findFlights.contains(flight)) {
                            findFlights.add(flight);
                        }
                    }
                }
            }
            if (findFlights.isEmpty()) {
                throw new NoFlightsFoundWithTheseParametersException();
            } else {
                return Collections.unmodifiableList(findFlights);
            }
        }
    }

    @Override
    public List<Flight> findFlightsWithArrivalEarlierThanDeparture2(List<Flight> flights) {
        List<Flight> findFlights = new ArrayList<>();
        Iterator<Flight> flightIterator = flights.iterator();
        while (flightIterator.hasNext()) {
            Flight flight = flightIterator.next();
            Iterator<Segment> segmentIterator = flight.getSegments().iterator();
            while (segmentIterator.hasNext()) {
                Segment segment = segmentIterator.next();
                if (segment.getArrival().isBefore(segment.getDeparture()) && !findFlights.contains(flight)) {
                    findFlights.add(flight);
                }
            }
        }
        return Collections.unmodifiableList(findFlights);
    }


    @Override
    public List<Flight> findFlightsTimeSpentOnEarthExceedsTwoHours(List<Flight> flights) {
        if (flights.isEmpty()) {
            throw new FlightNotFoundException();
        } else {
            List<Flight> findFlights = new ArrayList<>();
            for (Flight flight : flights) {
                if (flight.getSegments().isEmpty()) {
                    throw new FlightHasNoSegmentsException();
                } else {
                    for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                        if (flight.getSegments().get(i).getArrival().until(flight.getSegments().get(i + 1).getDeparture(), ChronoUnit.HOURS) > 2.01) {
                            findFlights.add(flight);
                        }
                    }
                }
            }
            if (findFlights.isEmpty()) {
                throw new NoFlightsFoundWithTheseParametersException();
            } else {
                return Collections.unmodifiableList(findFlights);
            }
        }
    }
}


