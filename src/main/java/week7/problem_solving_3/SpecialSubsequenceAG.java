package week7.problem_solving_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You have given a string A having Uppercase English letters.
    You have to find that how many times subsequence "AG" is there in the given string.
    NOTE: Return the answer modulo 10^9 + 7 as the answer can be very large.
    Input->
        "ABCGAG"
    Output->
        3

*/
public class SpecialSubsequenceAG {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpecialSubsequenceAG.class);

    public static void main(String[] args) {
        int specialSubsequence = countSpecialSubsequence("ABCGAG");
        LOGGER.info("Total count of special subsequence 'AG' in given input is {}", specialSubsequence);
    }

    public static int countSpecialSubsequence(String input) {
        int output = 0;
        int count = 0;
        for (int i = input.length() - 1; i >= 0; --i) {
            if (input.charAt(i) == 'G')
                count++;
            else if (input.charAt(i) == 'A')
                output += count;
        }
        return output;
    }
}
