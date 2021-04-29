package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given a string S. You want to change it to the lexicographically largest possible string by changing some of its characters.
    But you can only use characters of the string T as a replacement for characters of S.
    Formally, find the lexicographically largest string you can form by replacing some(or none) of the characters of S
    by using only the characters of string T. Note: Each character of T can be used at the most once.
    Given a string A containing S and T separated by "_" character.

    Input-> "abb_c"
    Output-> "cbb"
    Explanation-> cbb is lexicographically largest than abb
*/
public class LexicographicallyLargest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LexicographicallyLargest.class);

    public static void main(String[] args) {
        String lexLargest = lexLargest("abb_c");
        LOGGER.info("Possible Lexicographically Largest String for given input {}", lexLargest);
    }

    public static String lexLargest(String input) {
        int[] charCount = new int[26];
        int underScoreIndex = -1;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '_')
                underScoreIndex = i;
            else if (underScoreIndex != -1) {
                int tempIndex = input.charAt(i) - 97;
                charCount[tempIndex] = charCount[tempIndex] + 1;
            }
        }
        StringBuffer sorted = new StringBuffer();
        for (int i = 0; i < 26; ++i) {
            if (charCount[i] != 0) {
                int temp = charCount[i];
                while (temp > 0) {
                    sorted.append((char) (i + 97));
                    temp--;
                }
            }
        }
        StringBuffer output = new StringBuffer();
        int endIndex = sorted.length() - 1;
        for (int i = 0; i < underScoreIndex; ++i) {
            if (endIndex > -1 && (input.charAt(i) < sorted.charAt(endIndex))) {
                output.append(sorted.charAt(endIndex));
                endIndex--;
            } else output.append(input.charAt(i));
        }
        return output.toString();
    }
}
