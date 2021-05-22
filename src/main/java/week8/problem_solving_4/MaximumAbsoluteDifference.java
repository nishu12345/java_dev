package week8.problem_solving_4;

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
        int maxAbsDiff = calMaxAbsDiff(new int[]{1, 2, 3, 1});
        LOGGER.info("Max Absolute Difference between sum of differences of two elements and differences of respective position is {}", maxAbsDiff);
    }

    private static int calMaxAbsDiff(int[] input) {
        int largestSum = Integer.MIN_VALUE;
        int smallestSum = Integer.MAX_VALUE;
        int largestDiff = Integer.MIN_VALUE;
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; ++i) {
            int sum = input[i] + i;
            int diff = input[i] - i;
            if (sum > largestSum)
                largestSum = sum;
            if (sum < smallestSum)
                smallestSum = sum;
            if (diff > largestDiff)
                largestDiff = diff;
            if (diff < smallestDiff)
                smallestDiff = diff;
        }
        int sumDiff = largestSum - smallestSum;
        int diffDiff = largestDiff - smallestDiff;
        return sumDiff >= diffDiff ? sumDiff : diffDiff;
    }
}
