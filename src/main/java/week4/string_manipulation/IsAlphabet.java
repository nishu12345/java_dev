package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given a function isalpha() consisting of a character array A.
    Return 1 if all the characters of the character array are alphabetical (a-z and A-Z), else return 0.
    Input->
        ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y']
    Output->
        1
*/
public class IsAlphabet {
    private static final Logger LOGGER = LoggerFactory.getLogger(IsAlphabet.class);

    public static void main(String[] args) {
        int isAlphabet = isAlpha(new char[]{'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'});
        LOGGER.info("Is ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'] only have alphabets? {}", isAlphabet);
    }

    public static int isAlpha(char[] input) {
        for (int i = 0; i < input.length; ++i) {
            if (!(input[i] >= 'A' && input[i] <= 'Z') && !(input[i] >= 'a' && input[i] <= 'z'))
                return 0;
        }
        return 1;
    }
}
