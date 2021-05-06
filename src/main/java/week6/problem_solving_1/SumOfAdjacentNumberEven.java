package week6.problem_solving_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an array of integers A, find and return the minimum elements to be removed such that
    in the resulting array the sum of any two adjacent values is even.
    Input->
        [5, 17, 100, 11]
    Output->
        1
    Explanation->
        removal of 100 from input will satisfy the condition.
*/
public class SumOfAdjacentNumberEven {
    private static final Logger LOGGER = LoggerFactory.getLogger(SumOfAdjacentNumberEven.class);

    public static void main(String[] args) {
        int minNumToMakeEven = minNumToMakeEven(new int[]{5, 17, 100, 11});
        LOGGER.info("Minimum number to be removed so that all adjacent sum are even is {}", minNumToMakeEven);

    }

    public static int minNumToMakeEven(int[] input) {
        int oddCount = 0;
        int evenCount = 0;
        for (int num : input) {
            if (num % 2 == 0)
                ++evenCount;
            else
                ++oddCount;
        }
        if (oddCount <= evenCount)
            return oddCount;
        else return evenCount;
    }
}
