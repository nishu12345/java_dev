package week7.problem_solving_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an integer array A of size N. You can pick B elements from either left or right end of the array A to get maximum sum.
    Find and return this maximum possible sum.
    NOTE: Suppose B = 4 and array A contains 10 elements then
    You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc.
    You need to return the maximum possible sum of elements you can pick.
    Input->
        [5,-2,3,1,2]
    Output->
        8
    Explanation->
        5 + -2 + 3 = 6
        5 + -2 + 2 = 5
        5 +  2 + 1 = 8
        2 +  1 + 3 = 6
        So 8 is the maximum sum possible.
*/
public class PickFromBothSide {
    private static final Logger LOGGER = LoggerFactory.getLogger(PickFromBothSide.class);

    public static void main(String[] args) {
        int maxSum = pickMaxSum(new int[]{5, -1, 3, 1, 2}, 3);
        LOGGER.info("Maximum sum from any side in given input is {}", maxSum);
    }

    public static int pickMaxSum(int[] input, int range) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < range; ++i) {
            leftSum += input[i];
        }
        int maxSum = leftSum;
        int temp = 1;
        while (temp <= range) {
            leftSum = leftSum - input[range - temp];
            rightSum = rightSum + input[input.length - temp];
            int sum = leftSum + rightSum;
            if (sum > maxSum)
                maxSum = sum;
            temp++;
        }
        return maxSum;
    }
}
