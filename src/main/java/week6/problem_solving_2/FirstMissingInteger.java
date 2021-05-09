package week6.problem_solving_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    Given an unsorted integer array A of size N. Find the first missing positive integer.
    Note: Your algorithm should run in O(n) time and use constant space.
    Input->
        [3,4,-1,1]
    Output->
        2


*/
public class FirstMissingInteger {
    private static final Logger LOGGER = LoggerFactory.getLogger(FirstMissingInteger.class);

    public static void main(String[] args) {
        int firstMissingInteger = firstMissingInteger(new int[]{3, 4, -1, 1});
        LOGGER.info("First Missing positive integer in given input is {}", firstMissingInteger);
    }

    public static int firstMissingInteger(int[] input) {
        Map<Integer, Boolean> hashed = new HashMap<>();
        for (int num : input) {
            if (num > 0)
                hashed.put(num, true);
        }
        int temp = 1;
        for (int i = 0; i < hashed.size(); ++i) {
            if (!hashed.containsKey(temp))
                return temp;
            temp++;
        }
        return temp;
    }
}
