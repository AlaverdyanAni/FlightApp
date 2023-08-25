package com.gridnine.flightapp;

import java.util.List;

public interface FlightService {

//вылет до текущего момента времени
List<Flight> findFlightsUpToCurrentTime(List<Flight> flights);
List<Flight> findFlightsUpToCurrentTime2(List<Flight> flights);

//имеются сегменты с датой прилёта раньше даты вылета
List<Flight> findFlightsWithArrivalEarlierThanDeparture(List<Flight> flights);
List<Flight> findFlightsWithArrivalEarlierThanDeparture2(List<Flight> flights);


//общее время, проведённое на земле превышает два часа
List<Flight> findFlightsTimeSpentOnEarthExceedsTwoHours(List<Flight> flights);

}
