package week8.problem_solving_4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    You're given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
    If so, return the integer. If not, return -1.
    If there are multiple solutions, return any one.
    Input->
        [1,2,3,1,1]
    Output->
        1
    Explanation->
        1 occurs 3 times which is greater than 5/3.
*/
public class NBy3RepeatNumbers {
    private static final Logger LOGGER = LoggerFactory.getLogger(NBy3RepeatNumbers.class);

    public static void main(String[] args) {
        int by3RepeatNumbers = giveNBy3RepeatNumbers(new int[]{1, 2, 3, 1, 1});
        LOGGER.info("N/3 repeat number in given input is {}", by3RepeatNumbers);
    }

    public static int giveNBy3RepeatNumbers(int[] input) {
        if (input.length == 1)
            return input[0];
        int nBy3 = input.length / 3;
        Map<Integer, Integer> hashed = new HashMap<>();
        for (int i = 0; i < input.length; ++i) {
            if (hashed.containsKey(input[i])) {
                if (hashed.get(input[i]) + 1 > nBy3)
                    return input[i];
                hashed.put(input[i], hashed.get(input[i]) + 1);
            } else
                hashed.put(input[i], 1);
        }
        return -1;
    }
}
