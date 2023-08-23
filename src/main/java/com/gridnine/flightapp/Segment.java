package com.gridnine.flightapp;

import java.time.LocalDateTime;
import java.util.Objects;

public class Segment {
    LocalDateTime arrival;
    LocalDateTime departure;

    public Segment(LocalDateTime arrival, LocalDateTime departure) {
        this.arrival = arrival;
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segment segment = (Segment) o;
        return Objects.equals(arrival, segment.arrival) && Objects.equals(departure, segment.departure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrival, departure);
    }

    @Override
    public String toString() {
        return "Segment {" +
                "arrival: " + arrival.getYear()+"-"+arrival.getMonth()+"-"+arrival.getDayOfMonth()+", "+arrival.getHour()+":"+arrival.getMinute()+
                ", departure: " + departure.getYear()+"-"+departure.getMonth()+"-"+departure.getDayOfMonth()+", "+departure.getHour()+":"+departure.getMinute()+
                '}';
    }
}
