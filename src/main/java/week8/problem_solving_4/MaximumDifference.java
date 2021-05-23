package week8.problem_solving_4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    Given an array of integers A and an integer B. Find and return the maximum value of | s1 - s2 |
    where s1 = sum of any subset of size B, s2 = sum of elements of A - sum of elements of s1
    Note |x| denotes the absolute value of x.
    Input->
        [5, 17, 100, 11]
    Output->
        123
*/
public class MaximumDifference {
    private static final Logger LOGGER = LoggerFactory.getLogger(MaximumDifference.class);

    public static void main(String[] args) {
        int maxDiff = calMaxDiff(new int[]{93, 51, 84, 81, 89, 82, 28, 78, 86, 35, 64, 38, 49, 99, 83}, 4);
        LOGGER.info("Max Sum Difference in given input is {}", maxDiff);
    }

    public static int calMaxDiff(int[] input, int range) {
        Arrays.sort(input);
        int sum = 0;
        int minSum = 0;
        int maxSum = 0;
        for (int i = 0; i < input.length; ++i) {
            sum += input[i];
            if (i < range)
                minSum += input[i];
            if (i >= input.length - range)
                maxSum += input[i];
        }
        int withMinSum = Math.abs((2 * minSum) - sum);
        int withMaxSum = Math.abs((2 * maxSum) - sum);
        return withMaxSum >= withMinSum ? withMaxSum : withMinSum;
    }
}
