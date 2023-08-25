package com.gridnine.flightapp;

import java.time.LocalDateTime;
import java.util.Objects;

public class Segment {
    LocalDateTime departure;
    LocalDateTime arrival;

    public Segment(LocalDateTime departure, LocalDateTime arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return Objects.equals(departure, segment.departure) && Objects.equals(arrival, segment.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival);
    }

    @Override
    public String toString() {
        return "Segment - " +
                "Departure: " + departure.getYear()+"-"+departure.getMonth()+"-"+departure.getDayOfMonth()+", "+departure.getHour()+":"+departure.getMinute()+
                ", Arrival: " + arrival.getYear()+"-"+arrival.getMonth()+"-"+arrival.getDayOfMonth()+", "+arrival.getHour()+":"+arrival.getMinute();
    }
}
