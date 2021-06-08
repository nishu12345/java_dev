package week9.problem_solving_7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an array of integers A of size N.
    Value of a subarray is defined as BITWISE OR of all elements in it.
    Return the sum of Value of all sub-arrays of A % 109 + 7.
    Input->
        [1,2,3,4,5]
    Output->
        71
    Explanation->
        Value([1]) = 1
        Value([1, 2]) = 3
        Value([1, 2, 3]) = 3
        Value([1, 2, 3, 4]) = 7
        Value([1, 2, 3, 4, 5]) = 7
        Value([2]) = 2
        Value([2, 3]) = 3
        Value([2, 3, 4]) = 7
        Value([2, 3, 4, 5]) = 7
        Value([3]) = 3
        Value([3, 4]) = 7
        Value([3, 4, 5]) = 7
        Value([4]) = 4
        Value([4, 5]) = 5
        Value([5]) = 5
        Sum of all these values = 71
*/
public class SubArrayOr {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubArrayOr.class);

    public static void main(String[] args) {
        int subArrayXor = calSubArrayOr(new int[]{1, 2, 3, 4, 5});
        LOGGER.info("OR sum of all the sub-array in given input is {}", subArrayXor);

    }

    public static int calSubArrayOr(int[] input) {
        int output = 0;
        for (int i = 0; i < input.length; ++i) {
            int or = 0;
            for (int j = i; j < input.length; ++j) {
                or = or | input[j];
                output += or;
            }
        }
        return output;
    }
}
