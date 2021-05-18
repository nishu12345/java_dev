package week7.basic_math_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an integer A, find and return the Ath magic number.
    A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.
    First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
    Input->
        3
    Output->
        30
    Explanation->
        A in increasing order is [5, 25, 30, 125, 130, ...]
        3rd element in this is 30
*/
public class FindNthMagicNumber {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindNthMagicNumber.class);

    public static void main(String[] args) {
        int nthMagicNumber = nthMagicNumber(3);
        LOGGER.info("Given input th magic number is {}", nthMagicNumber);
    }

    public static int nthMagicNumber(int input) {
        String binaryString = Integer.toBinaryString(input);
        int output = 0;
        for (int i = binaryString.length(); i > 0; --i) {
            if (binaryString.charAt(i - 1) == '1') {
                output += (int) Math.pow(5, binaryString.length() - (i - 1));
            }
        }
        return output;
    }
}
