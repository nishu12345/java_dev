package week11.bitManipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an array of integers A, every element appears twice except for one. Find that single one.
    Input -> [1, 2, 2, 3, 1]
    Output -> 3
*/
public class SingleNumber {
    private static final Logger LOGGER = LoggerFactory.getLogger(SingleNumber.class);

    public static void main(String[] args) {
        int uniqueNumber = uniqueNumber(new int[]{1, 2, 3, 1, 4, 2, 4});
        LOGGER.info("Unique Number in the given input array is {}", uniqueNumber);
    }

    public static int uniqueNumber(int[] input) {
        int uniqueNum = input[0];
        for (int i = 1; i < input.length; ++i)
            uniqueNum ^= input[i];
        return uniqueNum;
    }
}
