package week8.problem_solving_4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.
    Input->
        [5,17,100,11]
    Output->
        6
    Explanation->
        |11-5| = 6 or |17-11| = 6
*/
public class MinimumAbsoluteDifference {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinimumAbsoluteDifference.class);

    public static void main(String[] args) {
        int minAbsDiff = calMinAbsDiff(new int[]{5, 17, 100, 11});
        LOGGER.info("Minimum Absolute Difference Between two elements in given input is {}", minAbsDiff);
    }

    public static int calMinAbsDiff(int[] input) {
        if (input.length == 1)
            return input[0];
        Arrays.sort(input);
        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 1; i < input.length; ++i) {
            int diff = input[i] - input[i - 1];
            if (diff < minAbsDiff)
                minAbsDiff = diff;
        }
        return Math.abs(minAbsDiff);
    }
}
