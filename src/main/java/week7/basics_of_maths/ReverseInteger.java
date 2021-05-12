package week7.basics_of_maths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given an integer N and the task is to reverse the digits of the given integer.
    Return 0 if the result overflows and does not fit in a 32 bit signed integer
    Input->
        123
    Output->
        321
*/
public class ReverseInteger {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReverseInteger.class);

    public static void main(String[] args) {
        int reverseInteger = reverseInteger(123);
        LOGGER.info("Reverse value of given input is {}", reverseInteger);
    }

    public static int reverseInteger(int input) {
        long reversed = 0L;
        int temp = input;
        if (input < 0)
            temp = -1 * input;
        while (temp > 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }
        if (reversed >= Integer.MIN_VALUE && reversed <= Integer.MAX_VALUE) {
            if (input < 0)
                return (int) (-1 * reversed);
            return (int) reversed;
        }
        return 0;
    }
}
