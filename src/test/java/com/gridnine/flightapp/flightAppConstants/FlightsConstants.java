package com.gridnine.flightapp.flightAppConstants;

import com.gridnine.flightapp.Flight;
import com.gridnine.flightapp.Segment;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightsConstants {

    //Flight that has departed before the current time multi segment flight - Рейс, который вылетает до текущего момента времени
    static final Segment segment1 = new Segment(LocalDateTime.now().minusHours(6),LocalDateTime.now().minusHours(3));
    static final Flight flight1 = new Flight(Arrays.asList(segment1));

    //Another multi segment flight that has departed before the current time - Еще один многосегментный рейс, который вылетает до текущего момента времени
    static final Segment segment2 = new Segment(LocalDateTime.now().minusHours(18),LocalDateTime.now().minusHours(14));
    static final Segment segment3 = new Segment(LocalDateTime.now().minusHours(12),LocalDateTime.now().minusHours(7));
    static final Flight flight2 = new Flight(Arrays.asList(segment2, segment3));

    //A flight that departs before it arrives - Рейс, который вылетает до прибытия
    static final Segment segment4 = new Segment(LocalDateTime.now().plusDays(2),LocalDateTime.now().plusDays(2).minusHours(6));
    static final Flight flight3 = new Flight(Arrays.asList(segment4));

    //Another flight that departs before it arrives - Еще один многосегментный рейс, который вылетает до прибытия
    static final Segment segment5 = new Segment(LocalDateTime.now().plusDays(6),LocalDateTime.now().plusDays(6).minusHours(4));
    static final Segment segment6 = new Segment(LocalDateTime.now().plusDays(6).minusHours(3),LocalDateTime.now().plusDays(6).plusHours(3));
    static final Flight flight4 = new Flight(Arrays.asList(segment5, segment6));

    //A flight with more than two hours ground time - Рейс продолжительностью более двух часов наземного времени
    static final Segment segment7 = new Segment(LocalDateTime.now().plusDays(3),LocalDateTime.now().plusDays(3).plusHours(2));
    static final Segment segment8 = new Segment(LocalDateTime.now().plusDays(3).plusHours(7),LocalDateTime.now().plusDays(3).plusHours(10));
    static final Flight flight5 = new Flight(Arrays.asList(segment7, segment8));

    //Another flight with more than two hours ground time - Еще один рейс с наземным временем более двух часов.
    static final Segment segment9 = new Segment(LocalDateTime.now().plusDays(2),LocalDateTime.now().plusDays(2).plusHours(5));
    static final Segment segment10 = new Segment(LocalDateTime.now().plusDays(4),LocalDateTime.now().plusDays(4).plusHours(2));
    static final Flight flight6 = new Flight(Arrays.asList(segment9, segment10));


    public  static final List<Flight> FLIGHTS = Arrays.asList(flight1, flight2, flight3, flight4, flight5, flight6);
    public static final List <Flight> UP_TO_CURRENT_TIME_FLIGHTS = Arrays.asList(flight1,flight2);
    public static final List <Flight> ARRIVAL_EARLIER_THAN_DEPARTURE_FLIGHTS = List.of(flight3, flight4);
    public static final List <Flight> TIME_SPENT_ON_EARTH_EXCEEDS_TWO_HOURS_FLIGHTS = List.of(flight5, flight6);
}
