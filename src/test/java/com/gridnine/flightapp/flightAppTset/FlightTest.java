package com.gridnine.flightapp.flightAppTset;

import com.gridnine.flightapp.Flight;
import com.gridnine.flightapp.FlightService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static com.gridnine.flightapp.flightAppConstants.FlightsConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightTest {
    public static Stream<Arguments> provideParamsForFlightsUpToCurrentTimeTest() {
        return Stream.of(
                Arguments.of(FLIGHTS,UP_TO_CURRENT_TIME_FLIGHTS));
    }

    public static Stream<Arguments> provideParamsForFlightsWithArrivalEarlierThanDepartureTest() {
        return Stream.of(
                Arguments.of(FLIGHTS,ARRIVAL_EARLIER_THAN_DEPARTURE_FLIGHTS));
    }

    public static Stream<Arguments> provideParamsForFlightsTimeSpentOnEarthExceedsTwoHoursTest() {
        return Stream.of(
                Arguments.of(FLIGHTS,TIME_SPENT_ON_EARTH_EXCEEDS_TWO_HOURS_FLIGHTS));
    }

    private final FlightService out = new Flight();
    @ParameterizedTest
    @MethodSource("provideParamsForFlightsUpToCurrentTimeTest")
    public void shouldReturnFlightsUpToCurrentTime(List<Flight> flights, List<Flight>expectedFlights) {
        List<Flight> actualFlights = out.findFlightsUpToCurrentTime(flights);
        assertEquals(expectedFlights,actualFlights);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForFlightsUpToCurrentTimeTest")
    public void shouldReturnFlightsUpToCurrentTime2(List<Flight> flights, List<Flight>expectedFlights) {
        List<Flight> actualFlights = out.findFlightsUpToCurrentTime2(flights);
        assertEquals(expectedFlights,actualFlights);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForFlightsWithArrivalEarlierThanDepartureTest")
    public void shouldReturnFlightsWithArrivalEarlierThanDeparture(List<Flight> flights, List<Flight>expectedFlights) {
        List<Flight> actualFlights = out.findFlightsWithArrivalEarlierThanDeparture(flights);
        assertEquals(expectedFlights, actualFlights);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForFlightsWithArrivalEarlierThanDepartureTest")
    public void shouldReturnFlightsWithArrivalEarlierThanDeparture2(List<Flight> flights, List<Flight>expectedFlights) {
        List<Flight> actualFlights = out.findFlightsWithArrivalEarlierThanDeparture2(flights);
        assertEquals(expectedFlights, actualFlights);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForFlightsTimeSpentOnEarthExceedsTwoHoursTest")
    public void shouldReturnFlightsTimeSpentOnEarthExceedsTwoHours(List<Flight> flights, List<Flight>expectedFlights) {
        List<Flight> actualFlights = out.findFlightsTimeSpentOnEarthExceedsTwoHours(flights);
        assertEquals(expectedFlights,actualFlights);
    }
}
