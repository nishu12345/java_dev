package week6.problem_solving_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
/*
    There is a shop whose assistant told you that there are A puzzles in the shop and you want to buy B of them.
    They might differ in difficulty and size. The first jigsaw puzzle consists of A1 pieces,
    the second one consists of A2 pieces and so on.
    You decided that the difference between the numbers of pieces in bought puzzles must be as small as possible.
    Let x be the number of pieces in the largest puzzle that the you buy and y be the number of pieces in the smallest such puzzle.
    You want to choose such B puzzles that x-y is as minimum as possible. Find the least possible value of x-y.
    Input->
        [10, 12, 10, 7, 5, 22]
        b = 4
    Output->
        5
    Explanation->
        Selected puzzles are 10, 10, 12, 7: (Max-Min) = (12-7) = 5.
*/
public class MinimumDifferencePuzzle {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinimumDifferencePuzzle.class);

    public static void main(String[] args) {
        int minDiff = calMinDiff(new int[]{10, 12, 10, 7, 5, 22}, 4);
        LOGGER.info("Minimum Difference between maximum and minimum element in sub-arrays is {}", minDiff);
    }

    public static int calMinDiff(int[] input, int b) {
        Arrays.sort(input);
        if (input.length < b)
            return input[input.length - 1] - input[0];
        int output = Integer.MAX_VALUE;
        for (int i = 0; i <= input.length - b; ++i) {
            int endIndex = i + (b - 1);
            int difference = input[endIndex] - input[i];
            if (difference < output)
                output = difference;
        }
        return output;
    }
}
