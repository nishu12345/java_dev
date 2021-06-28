package week10.timeAndSpacePlusArrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Find the contiguous subarray within an array, A of length N which has the largest sum.
    Input->
        [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    Output->
        6
    Explanation->
         The subarray [4,-1,2,1] has the maximum possible sum of 6.
*/
public class MaxSumContiguousArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(MaxSumContiguousArray.class);

    public static void main(String[] args) {
        int maxContiguousSum = getMaxContiguousSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        LOGGER.info("Max Contiguous Sum sub-array in given input is {}", maxContiguousSum);
    }

    public static int getMaxContiguousSum(int[] input) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : input) {
            sum += num;
            if (sum > maxSum)
                maxSum = sum;
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
