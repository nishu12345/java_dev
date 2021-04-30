package week5.introduction_to_recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Write a recursive function that checks whether a string A is a palindrome or Not.
    Return 1 if the string A is palindrome, else return 0.
    Note: A palindrome is a string that's the same when reads forwards and backwards.
    Input->
        "NAMAN"
    Output->
        1
*/
public class CheckPalindrome {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckPalindrome.class);

    public static void main(String[] args) {
        String input = "NAMAN";
        int isPalindrome = checkPalindrome(input, 0, input.length() - 1);
        LOGGER.info("Is given input a palindrome ? {}", isPalindrome);
    }

    public static int checkPalindrome(String input, int start, int end) {
        if (start >= end)
            return 1;
        if (input.charAt(start) == input.charAt(end))
            return checkPalindrome(input, ++start, --end);
        else return 0;
    }
}
