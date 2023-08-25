package com.gridnine.flightapp;

import java.time.LocalDateTime;


public class SegmentGenerator {

    public static LocalDateTime createRandomDateTime() {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = 2023;
        int hour = createRandomIntBetween(0,23);
        int minutes = createRandomIntBetween(0,60);
        return LocalDateTime.of(year, month, day,hour,minutes);
    }
    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}
