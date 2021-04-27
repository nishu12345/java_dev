package week4.string_manipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given a string A, rotate the string B times in clockwise direction and return the string.
    Input->
        A = "Scaler
        b = 2
    Output->
        erScal
*/
public class StringRotation {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringRotation.class);

    public static void main(String[] args) {
        String rotatedString = rotateString("Scaler", 2);
        LOGGER.info("Scaler rotated clockwise by 2 steps is {}", rotatedString);
    }

    public static String rotateString(String input, int b) {
        b = b % input.length();
        StringBuffer str = new StringBuffer(input);
        reverseSubString(str, 0, str.length() - 1);
        reverseSubString(str, 0, b - 1);
        reverseSubString(str, b, str.length() - 1);
        return str.toString();
    }

    public static void reverseSubString(StringBuffer input, int beginIndex, int endIndex) {
        int limit = beginIndex + ((endIndex + 1) - beginIndex) / 2;
        for (int i = beginIndex; i < limit; ++i) {
            char temp = input.charAt(i);
            input.setCharAt(i, input.charAt(endIndex));
            input.setCharAt(endIndex, temp);
            --endIndex;
        }
    }
}
