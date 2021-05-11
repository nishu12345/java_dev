package week7.basics_of_maths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given a column title as appears in an Excel sheet, return its corresponding column number.
    Input->
        AB
    Output->
        28
*/
public class ExcelColumnNumber {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelColumnNumber.class);

    public static void main(String[] args) {
        int columnNumber = excelColumnNumber("AB");
        LOGGER.info("Excel Column Number with respect to given input is {}", columnNumber);
    }

    public static int excelColumnNumber(String input) {
        int output = 0;
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(input.length() - (i + 1));
            int temp = (ch - 64) * (int) Math.pow(26, i);
            output += temp;
        }
        return output;
    }
}
