package week3.introduction_to_hashing;


import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers A consisting of only 0 and 1.
    Find the maximum length of a contiguous subarray with equal number of 0 and 1.
    Input-> [1, 0, 1, 0, 1]
    Output-> 4
    Explanation:
        Subarray from index 0 to index 3 : [1, 0, 1, 0]
        Subarray from index 1 to index 4 : [0, 1, 0, 1]
        Both the subarray have equal number of ones and equal number of zeroes.

*/
public class ContiguousArray {
    public static void main(String[] args) {
        int largestContiguousSubArrayLength = largestContiguousSubArray(new int[]{1, 0, 1, 0, 1});
        System.out.println("Length of largest Contiguous subarray with equal number or 0 and 1 = " + largestContiguousSubArrayLength);
    }

    public static int largestContiguousSubArray(int[] input) {
        int output = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumAndIndexes = new HashMap<>();
        prefixSumAndIndexes.put(0, -1);//At start the prefix_sum = 0 and before start indexes = -1
        for (int i = 0; i < input.length; ++i) {
            if (input[i] == 0)
                prefixSum += -1;
            else prefixSum += 1;
            if (prefixSumAndIndexes.containsKey(prefixSum)) {
                int length = i - prefixSumAndIndexes.get(prefixSum);
                if (length > output)
                    output = length;
            } else prefixSumAndIndexes.put(prefixSum, i);
        }
        return output;
    }
}
