package week6.problem_solving_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    You are given an array A having N integers. You have to divide / split the array into 2 subsequence partitions such that:
        Both the partitions are non-empty.
        Each integer A[i] in the array belongs to exactly one of the two partitions.
    Absolute difference between the maximum of first partition and the minimum of second partition is minimum possible.
    If B and C represent the two partitions, then size(B) >= 1, size(C) >= 1 and |max(B) - min(C)| is minimum possible.
    You have to find such a spliting and tell the minimum value of |max(B) - max(C)|.
    Input->
        [2, 1, 3, 2, 4, 3]
    Output->
        0
    Explanation->
      B = [2, 1]
      C = [3, 2, 4, 3]
      max(B) = 2, min(C) = 2
      abs(max(B) - min(C)) = abs(2 - 2) = abs(0) = 0
*/
public class OptimalPartitioning {
    private static final Logger LOGGER = LoggerFactory.getLogger(OptimalPartitioning.class);

    public static void main(String[] args) {
        int minDiff = minDiff(new int[]{3, 1, 2, 6, 4});
        LOGGER.info("Minimum Difference between max and min elements after partitioning is {}", minDiff);
    }

    public static int minDiff(int[] input) {
        Arrays.sort(input);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < input.length - 1; ++i) {
            int diff = input[i + 1] - input[i];
            if (diff < minDiff)
                minDiff = diff;
        }
        return Math.abs(minDiff);
    }
}
