package week6.problem_solving_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/*
    Given an array of integers A consisting of only 0 and 1.
    Find the maximum length of a contiguous subarray with equal number of 0 and 1.
    Input->
        [1, 0, 1, 0, 1]
    Output->
        4
     Explanation->
        Subarray from index 0 to index 3 : [1, 0, 1, 0]
        Subarray from index 1 to index 4 : [0, 1, 0, 1]
        Both the subarrays have equal number of ones and equal number of zeroes.
*/
public class ContiguousArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContiguousArray.class);

    public static void main(String[] args) {
        int longestEqualOneAndZero = longestEqualOneAndZero(new int[]{1, 0, 1, 1, 1, 0, 0});
        LOGGER.info("Longest sub-array with equal 0's and 1's in given input is {}", longestEqualOneAndZero);
    }

    public static int longestEqualOneAndZero(int[] input) {
        int longestLength = 0;
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, -1);
        int sum = 0;
        for (int i = 0; i < input.length; ++i) {
            if (input[i] == 0)
                sum += -1;
            else sum += 1;
            if (prefixSum.containsKey(sum)) {
                Integer previousIndex = prefixSum.get(sum);
                int length = i - previousIndex;
                if (length > longestLength)
                    longestLength = length;
            } else
                prefixSum.put(sum, i);
        }
        return longestLength;
    }
}
