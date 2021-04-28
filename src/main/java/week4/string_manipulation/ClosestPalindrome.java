package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given a string A of size N consisting of lowercase alphabets, return "YES" if it is possible to make the given string
    a palindrome by changing exactly one of its character else return "NO".
    Input-> "abbba"
    Output-> "YES"
    Explanation->  We can change the character at index 3(1-based) to any other character. The string will be palindromic.
*/
public class ClosestPalindrome {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClosestPalindrome.class);

    public static void main(String[] args) {
        String closestPalindrome = isClosestPalindrome("abbba");
        LOGGER.info("Is input string can be a palindrome by changing exactly one character? {}", closestPalindrome);
    }

    public static String isClosestPalindrome(String input) {
        if (input.length() < 2)
            return "YES";
        int diff = 0;
        for (int i = 0; i < input.length() / 2; ++i) {
            if (input.charAt(i) != input.charAt(input.length() - (i + 1)))
            diff++;
        }
        if (diff == 1)
            return "YES";
        else if (diff == 0) {
            if (input.length() % 2 == 1)
                return "YES";
        }
        return "NO";
    }
}
