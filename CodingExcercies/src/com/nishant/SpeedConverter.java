package com.nishant;

public class SpeedConverter {

    public static void main(String[] args) {
        printConversion(5.6);
        printConversion(10.5);


    }

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour > 0) {
            return Math.round(kilometersPerHour / 1.609);
        }
        return -1L;
    }

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour + " km/hr = " + milesPerHour + " mi/hr");
        }
    }
}
