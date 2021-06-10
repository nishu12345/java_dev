package week9.problem_solving_7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms.
    Bookings contain an arrival date and a departure date.
    He wants to find out whether there are enough rooms in the hotel to satisfy the demand.
    Write a program that solves this problem in time O(N log N) .
    Input->
        arrive = [1, 3, 5]
        depart = [2, 6, 8]
        K = 1
    Output->
        false
    Explanation->
         At day = 5, there are 2 guests in the hotel. But hotel has only one room so it is not possible to take the booking
         so we will return false
*/
public class HotelBookingPossible {
    private static final Logger LOGGER = LoggerFactory.getLogger(HotelBookingPossible.class);

    public static void main(String[] args) {
        int[] arrive = {1, 3, 5};
        int[] depart = {2, 6, 8};
        Boolean isBookingPossible = isBookingPossible(arrive, depart, 1);
        LOGGER.info("Is Booking Possible with given timeline ? {}", isBookingPossible);
    }

    public static Boolean isBookingPossible(int[] arrive, int[] depart, int rooms) {
        int maxRooms = rooms;
        int arrivePointer = 0;
        int departPointer = 0;
        Arrays.sort(arrive);
        Arrays.sort(depart);
        while (arrivePointer < arrive.length && departPointer < depart.length) {
            if (arrive[arrivePointer] <= depart[departPointer]) {
                if (rooms > 0) {
                    rooms--;
                    arrivePointer++;
                } else return false;
            } else {
                if (rooms < maxRooms) {
                    rooms++;
                    departPointer++;
                }
            }
        }
        return true;
    }
}
