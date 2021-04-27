package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given a function to_lower() consisting of a character array A.
    Convert each character of A into lowercase character if it exists. If the lowercase of a character does not exist, it remains unmodified.
    The uppercase letters from A to Z is converted to lowercase letters from a to z respectively.
    Input->
        ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
    Output->
        ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']

Return the lowercase version of the given character array.
*/
public class ToLower {
    private static final Logger LOGGER = LoggerFactory.getLogger(ToLower.class);

    public static void main(String[] args) {
        char[] toLower = toLower(new char[]{'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'});
        LOGGER.info("Lower case of ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'] is {}", toLower);
    }

    public static char[] toLower(char[] input) {
        for (int i = 0; i < input.length; ++i) {
            if (input[i] >= 'A' && input[i] <= 'Z')
                input[i] = (char) (input[i] + 32);
        }
        return input;
    }
}
