package week9.problem_solving_7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an array of integers, every element appears thrice except for one which occurs once.
    Find that element which does not appear thrice.
    NOTE: Your algorithm should have a linear runtime complexity.
    Could you implement it without using extra memory?
    Input->
        [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
    Output->
        4
    Explanation->
        4 occurs exactly once
 */
public class SingleNumber2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(SingleNumber2.class);

    public static void main(String[] args) {
        int singleNumber = getSingleNumber(new int[]{1, 2, 4, 3, 3, 2, 2, 3, 1, 1});
        LOGGER.info("Unique Number in given input array is {}", singleNumber);
    }

    public static int getSingleNumber(int[] input) {
        int output = 0;
        for (int i = 0; i < 32; ++i) {
            int oneCount = 0;
            for (int j = 0; j < input.length; ++j) {
                if ((input[j] & (1 << i)) > 0)
                    oneCount++;
            }
            if (oneCount % 3 > 0)
                output = (1 << i) + output;
        }
        return output;
    }
}
