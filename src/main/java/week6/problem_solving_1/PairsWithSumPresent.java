package week6.problem_solving_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array A of N distinct and positive elements, the task is to find number of unordered pairs
    whose sum already exists in given array.
    Input->
        [3, 4, 2, 6, 7]
    Output->
        2
    Explanation->
        The pairs following the conditions are :
        (2,4) = 6,
        (3,4) = 7
*/
public class PairsWithSumPresent {
    private static final Logger LOGGER = LoggerFactory.getLogger(PairsWithSumPresent.class);

    public static void main(String[] args) {
        int countPairSum = countPairSum(new int[]{3, 4, 2, 6, 7});
        LOGGER.info("Total Pairs count whose sum is available in the input is {}", countPairSum);
    }

    public static int countPairSum(int[] input) {
        int count = 0;
        Map<Integer, Boolean> hashed = new HashMap<>();
        for (int num : input) {
            if (!hashed.containsKey(num))
                hashed.put(num, true);
        }
        for (int i = 0; i < input.length; ++i) {
            for (int j = i + 1; j < input.length; ++j) {
                int sum = input[i] + input[j];
                if (hashed.containsKey(sum))
                    ++count;
            }
        }
        return count;
    }
}
