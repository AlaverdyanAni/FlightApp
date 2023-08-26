package com.gridnine.flightapp.service;

import com.gridnine.flightapp.model.Flight;

import java.util.List;

public interface FlightService {

//вылет до текущего момента времени
List<Flight> findFlightsUpToCurrentTime1(List<Flight> flights);
List<Flight> findFlightsUpToCurrentTime2(List<Flight> flights);

//имеются сегменты с датой прилёта раньше даты вылета
List<Flight> findFlightsWithArrivalEarlierThanDeparture1(List<Flight> flights);
List<Flight> findFlightsWithArrivalEarlierThanDeparture2(List<Flight> flights);


//общее время, проведённое на земле превышает два часа
List<Flight> findFlightsTimeSpentOnEarthExceedsTwoHours(List<Flight> flights);

}
