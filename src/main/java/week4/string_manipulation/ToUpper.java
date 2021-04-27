package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given a function to_upper() consisting of a character array A.
    Convert each character of A into Uppercase character if it exists. If the Uppercase of a character does not exist, it remains unmodified.
    The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.
    Input->
        ['S', 'c', 'A', 'L', 'E', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
    Output->
        ['S', 'C', 'A', 'L', 'E', 'R', 'A', 'C', 'A', 'D', 'E', 'M', 'Y']
Return the uppercase version of the given character array.
*/
public class ToUpper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ToUpper.class);

    public static void main(String[] args) {
        char[] toUpper = toUpper(new char[]{'S', 'C', 'A', 'L', 'E', 'R', 'A', 'C', 'A', 'D', 'E', 'M', 'Y'});
        LOGGER.info("Lower conversion of ['S', 'C', 'A', 'L', 'E', 'R', 'A', 'C', 'A', 'D', 'E', 'M', 'Y'] is {}", toUpper);
    }

    public static char[] toUpper(char[] input) {
        for (int i = 0; i < input.length; ++i) {
            if (input[i] >= 'a' && input[i] <= 'z')
                input[i] = (char) (input[i] - 32);
        }
        return input;
    }
}
