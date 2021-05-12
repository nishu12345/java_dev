package week7.basics_of_maths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Determine whether an integer is a palindrome. Do this without extra space.
    A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
    Negative numbers are not palindromic.
    Input->
        12121
    Output->
        1
*/
public class PalindromeInteger {
    private static final Logger LOGGER = LoggerFactory.getLogger(PalindromeInteger.class);

    public static void main(String[] args) {
        int isPalindrome = checkPalindrome(12121);
        LOGGER.info("Is given input palindrome? {}", isPalindrome);
    }

    public static int checkPalindrome(int input) {
        int copy = input;
        int num = 0;
        while (copy > 0) {
            num = num * 10 + copy % 10;
            copy /= 10;
        }
        if (num == input)
            return 1;
        return 0;
    }
}
