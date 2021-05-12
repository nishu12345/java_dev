package week7.basics_of_maths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an integer A, return the number of trailing zeroes in A! i.e. factorial of A.
    Input->
        5
    Output->
        1
    Explanation->
        A! = 120.
        Number of trailing zeros = 1. So, return 1.

*/
public class TrailingZero {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrailingZero.class);

    public static void main(String[] args) {
        int trailingZero = trailingZero(30);
        LOGGER.info("Total Trailing Zero in given input factorial is {}", trailingZero);
    }

    public static int trailingZero(int num) {
        int output = 0;
        while (num > 0) {
            output += num / 5;
            num /= 5;
        }
        return output;
    }
}
