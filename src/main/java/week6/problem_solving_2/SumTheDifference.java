package week6.problem_solving_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    Given an integer array A of size N.
    You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence,
    find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.
    As the number may be large, output the number modulo 1e9 + 7 (1000000007).
    Input->
        [1,2]
    Output->
        1
    Explanation->
        All possible non-empty subsets are:
        [1]    largest-smallest = 1 - 1 = 0
        [2]    largest-smallest = 2 - 2 = 0
        [1 2]  largest-smallest = 2 - 1 = 1
        Sum of the differences = 0 + 0 + 1 = 1
        So, the resultant number is 1
*/
public class SumTheDifference {
    private static final Logger LOGGER = LoggerFactory.getLogger(SumTheDifference.class);

    public static void main(String[] args) {
        int difference = calDiff(new int[]{3, 2, 5});
        LOGGER.info("Summation of max and min elements of every sub-arrays is {}", difference);
    }

    public static int calDiff(int[] input) {
        Arrays.sort(input);
        long minSum = 0;
        long maxSum = 0;
        for (int i = 0; i < input.length; ++i) {
            int greaterElementLength = input.length - (i + 1);
            minSum = minSum + (long) (input[i] * Math.pow(2, greaterElementLength));
            int smallerElementLength = i - 0;
            maxSum = maxSum + (long) (input[i] * Math.pow(2, smallerElementLength));
        }
        return (int) ((maxSum - minSum) % 1000000007);
    }

    public static int calPower(int input){
        int output = 1;
        for(int i = 1; i <= input; ++i){
            output = output*2;
            output%=1000000007;
        }
        return output;
    }
}
