package com.nishant;

import java.util.Collections;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Message";
    public static void main(String[] args) {
        System.out.println(getDurationString(65L, 45L));
        System.out.println(getDurationString(3945L));
        System.out.println(getDurationString(-41L));
        System.out.println(getDurationString(65L,9L));

    }

    private static String getDurationString(long minutes, long seconds) {
        if (minutes >= 0 && (seconds >= 0 && seconds <= 59)) {
            long hours = minutes / 60;
            long remainingMinutes = minutes % 60;
            String hourString = String.valueOf(hours);
            String minuteString = String.valueOf(remainingMinutes);
            String secondString = String.valueOf(seconds);
            if (hours <= 9) {
                hourString = "0" + hourString;
            }
            if(remainingMinutes <= 9){
                minuteString = "0" + remainingMinutes;
            }
            if(seconds <= 9){
                secondString = "0" + seconds;
            }
            String duration = hourString + "h " + minuteString + "m " + secondString + "s";
            return duration;
        }
        return INVALID_VALUE_MESSAGE;
    }

    private static String getDurationString(long seconds) {
        if (seconds >= 0) {
            long minutes = seconds / 60;
            long remainingSeconds = seconds % 60;
            String duration = getDurationString(minutes, remainingSeconds);
            return duration;
        }
        return INVALID_VALUE_MESSAGE;
    }
}
