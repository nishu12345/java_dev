package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given a string A, you are asked to reverse the string and return the reversed string.
    Input->
         scaler
    Output->
        relacs
*/
public class SimpleReverse {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleReverse.class);

    public static void main(String[] args) {
        String reversedString = reverseString("scaler");
        LOGGER.info("Reverse of scaler is {}", reversedString);
    }

    public static String reverseString(String input) {
        StringBuffer str = new StringBuffer(input);
        for (int i = 0; i < str.length() / 2; ++i) {
            char temp = str.charAt(i);
            str.setCharAt(i, str.charAt(str.length() - (i + 1)));
            str.setCharAt(str.length() - (i + 1), temp);
        }
        return str.toString();
    }
}
