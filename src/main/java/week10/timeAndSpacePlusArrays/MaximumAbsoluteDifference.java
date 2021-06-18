package week10.timeAndSpacePlusArrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given an array of N integers, A1, A2, .... AN.
    Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
    Input->
        [1,3,-1]
    Output->
        5
    Explanation->
        f(1, 1) = f(2, 2) = f(3, 3) = 0
        f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
        f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
        f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.
*/
public class MaximumAbsoluteDifference {
    private static final Logger LOGGER = LoggerFactory.getLogger(MaximumAbsoluteDifference.class);

    public static void main(String[] args) {
        int maxAbsDifference = getMaxAbsDifference(new int[]{1, 3, -1});
        LOGGER.info("Maximum Absolute Difference in given input is {}",maxAbsDifference);
    }

    public static int getMaxAbsDifference(int[] input) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int inputLength = input.length;
        for (int i = 0; i < inputLength; ++i) {
            int sum = input[i] + i;
            int diff = input[i] - i;
            if (sum > maxSum)
                maxSum = sum;
            if (sum < minSum)
                minSum = sum;
            if (diff > maxDiff)
                maxDiff = diff;
            if (diff < minDiff)
                minDiff = diff;
        }

        int sumAbsDiff = maxSum - minSum;
        int diffAbsDiff = maxDiff - minDiff;
        return Math.max(sumAbsDiff, diffAbsDiff);
    }
}
