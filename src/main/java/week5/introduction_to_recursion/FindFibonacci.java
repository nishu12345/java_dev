package week5.introduction_to_recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    The Fibonacci numbers are the numbers in the following integer sequence.
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
    In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:
    Fn = Fn-1 + Fn-2
    Given a number A, find and return the Ath Fibonacci Number.
    Given that F0 = 0 and F1 = 1.
    Input->
        A = 9
    Output->
        34
    Explanation->
        f(9) = f(8) + f(7) = 21 + 13  = 34
*/
public class FindFibonacci {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindFibonacci.class);

    public static void main(String[] args) {
        int fibonacciNumber = findFibonacci(9);
        LOGGER.info("Fibonacci Number for given input is {}", fibonacciNumber);
    }

    public static int findFibonacci(int input) {
        if (input == 0)
            return 0;
        if (input == 1 || input == 2)
            return 1;
        return findFibonacci(input - 1) + findFibonacci(input - 2);
    }
}
