package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    Given the array of strings A, you need to find the longest string S which is the prefix of ALL the strings in the array.
    Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
    Input->
        ["abab", "ab", "abcd"];
    Output->
        "ab"
    Explanation->
        Longest common prefix of all the strings is "ab".
*/
public class LongestCommonPrefix {
    private static final Logger LOGGER = LoggerFactory.getLogger(LongestCommonPrefix.class);

    public static void main(String[] args) {
        String longestCommonPrefix = longestCommonPrefix(new String[]{"abcdefgh", "aefghijk", "abcefgh"});
        LOGGER.info("Longest Common Prefix for given input {}", longestCommonPrefix);
    }

    public static String longestCommonPrefix(String[] input) {
        Arrays.sort(input);
        String first = input[0];
        String last = input[1];
        StringBuffer output = new StringBuffer();
        for (int i = 0; i < first.length(); ++i) {
            if (first.charAt(i) == last.charAt(i))
                output.append(first.charAt(i));
            else break;
        }
        return output.toString();
    }
}
