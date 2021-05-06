package week6.problem_solving_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
    A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
    Input->
        [10,15,20,25]
    Output->
        1
*/
public class ArithmeticProgression {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArithmeticProgression.class);

    public static void main(String[] args) {
        int isArithmeticProgression = isArithmeticProgression(new int[]{10, 15, 20, 25});
        LOGGER.info("Is given input array an AP? {}", isArithmeticProgression);
    }

    public static int isArithmeticProgression(int[] input) {
        if (input.length < 3)
            return 1;
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;
        Map<Integer, Boolean> hashed = new HashMap<>();
        for (int num : input) {
            if (num < min) {
                second_min = min;
                min = num;
            }
            if (num != min && num < second_min)
                second_min = num;
            if (hashed.containsKey(num))
                return 0;
            else hashed.put(num, true);

        }
        int d = second_min - min;

        for (int i = 2; i < input.length; ++i) {
            int term = min + (i * d);
            if (!hashed.containsKey(term))
                return 0;
        }
        return 1;
    }
}
