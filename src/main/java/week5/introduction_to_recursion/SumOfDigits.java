package week5.introduction_to_recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given a number A, we need to find sum of its digits using recursion.
    Input->
        123
    Output->
        6
     Explanation->
        1+2+3 = 6
*/
public class SumOfDigits {
    private static final Logger LOGGER = LoggerFactory.getLogger(SumOfDigits.class);

    public static void main(String[] args) {
        int sumOfDigits = calSum(123);
        LOGGER.info("Sum of Digits of given input is {}", sumOfDigits);
    }

    public static int calSum(int input) {
        if (input == 0)
            return 0;
        return calSum(input / 10) + input % 10;
    }
}
