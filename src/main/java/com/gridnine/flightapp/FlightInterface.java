package com.gridnine.flightapp;

import java.util.List;

public interface FlightInterface {

//вылет до текущего момента времени
List<Flight> findFlightsUpToCurrentTime(List<Flight> flights);

//имеются сегменты с датой прилёта раньше даты вылета
List<Flight> findFlightsWithArrivalEarlierThanDeparture(List<Flight> flights);


//общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)
List<Flight> findFlightsTimeSpentOnEarthExceedsTwoHours(List<Flight> flights);

}
