package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given a function isalpha() consisting of a character array A.
    Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z and 0-9), else return 0.
    Input->
        ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0']
    Output->
        1
*/
public class IsAlpha {
    private static final Logger LOGGER = LoggerFactory.getLogger(IsAlpha.class);

    public static void main(String[] args) {
        int isAlpha = isAlpha(new char[]{'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'});
        LOGGER.info("Is char array ['S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'] contains only alphabets {}", isAlpha);
    }

    public static int isAlpha(char[] input) {
        for (int i = 0; i < input.length; ++i) {
            if (!(input[i] >= 'A' && input[i] <= 'Z') && !(input[i] >= 'a' && input[i] <= 'z') && !(input[i] >= '0' && input[i] <= '9'))
                return 0;
        }
        return 1;
    }
}
