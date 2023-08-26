package com.gridnine.flightapp.flightAppTset;

import com.gridnine.flightapp.exception.FlightHasNoSegmentsException;
import com.gridnine.flightapp.exception.FlightNotFoundException;
import com.gridnine.flightapp.exception.NoFlightsFoundWithTheseParametersException;
import com.gridnine.flightapp.model.Flight;
import com.gridnine.flightapp.service.FlightService;
import org.junit.jupiter.api.Assertions;
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

    public static Stream<Arguments> provideParamsForNoFlightsFoundTest1() {
        return Stream.of(
                Arguments.of(NORMAL_FLIGHTS_1, NoFlightsFoundWithTheseParametersException.class, "No flights found with these parameters!"));
    }

    public static Stream<Arguments> provideParamsForNoFlightsFoundTest2() {
        return Stream.of(
                Arguments.of(NORMAL_FLIGHTS_2, NoFlightsFoundWithTheseParametersException.class, "No flights found with these parameters!"));
    }

    public static Stream<Arguments> provideParamsForFlightsWithoutSegmentsTest() {
        return Stream.of(
                Arguments.of(WITHOUT_SEGMENTS_FLIGHTS, FlightHasNoSegmentsException.class, "Flight has no segments!"));
    }

    public static Stream<Arguments> provideParamsForWithoutFlightsTest() {
        return Stream.of(
                Arguments.of(WITHOUT_FLIGHT_FLIGHTS, FlightNotFoundException.class, "Flights not found!"));
    }

    private final FlightService out = new Flight();
    @ParameterizedTest
    @MethodSource("provideParamsForFlightsUpToCurrentTimeTest")
    public void shouldReturnFlightsUpToCurrentTime(List<Flight> flights, List<Flight>expectedFlights) {
        List<Flight> actualFlights = out.findFlightsUpToCurrentTime1(flights);
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
        List<Flight> actualFlights = out.findFlightsWithArrivalEarlierThanDeparture1(flights);
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

    @ParameterizedTest
    @MethodSource("provideParamsForNoFlightsFoundTest1")
    public void shouldReturnNoFlightFoundException1(List<Flight> flights, Class<Exception> expectedExceptionClass, String expectedExceptionMessage) {
        Assertions.assertThrows(
                expectedExceptionClass,
                () -> out.findFlightsUpToCurrentTime1(flights),
                //() -> out.findFlightsWithArrivalEarlierThanDeparture1(flights),
                expectedExceptionMessage
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForNoFlightsFoundTest2")
    public void shouldReturnNoFlightFoundException2(List<Flight> flights, Class<Exception> expectedExceptionClass, String expectedExceptionMessage) {
        Assertions.assertThrows(
                expectedExceptionClass,
                () -> out.findFlightsTimeSpentOnEarthExceedsTwoHours(flights),
                expectedExceptionMessage
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForFlightsWithoutSegmentsTest")
    public void shouldReturnFlightHasNoSegmentsException(List<Flight> flights, Class<Exception> expectedExceptionClass, String expectedExceptionMessage) {
        Assertions.assertThrows(
                expectedExceptionClass,
                () -> out.findFlightsUpToCurrentTime1(flights),
                //() -> out.findFlightsWithArrivalEarlierThanDeparture1(flights),
                //() -> out.findFlightsTimeSpentOnEarthExceedsTwoHours(flights),
                expectedExceptionMessage
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForWithoutFlightsTest")
    public void shouldReturnFlightNotFoundException(List<Flight> flights, Class<Exception> expectedExceptionClass, String expectedExceptionMessage) {
        Assertions.assertThrows(
                expectedExceptionClass,
                () -> out.findFlightsUpToCurrentTime1(flights),
                //() -> out.findFlightsWithArrivalEarlierThanDeparture1(flights),
                //() -> out.findFlightsTimeSpentOnEarthExceedsTwoHours(flights),
                expectedExceptionMessage
        );
    }
}
