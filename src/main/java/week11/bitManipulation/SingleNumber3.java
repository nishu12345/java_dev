package week11.bitManipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice.
    Find the two elements that appear only once.
    Note: Output array must be sorted.
    Input -> [1,2,3,1,2,4]
    Output -> 3 and 4
*/
public class SingleNumber3 {
    private static final Logger LOGGER = LoggerFactory.getLogger(SingleNumber3.class);

    public static void main(String[] args) {
        int[] uniqueNumbers = findUniqueNumbers(new int[]{1, 2, 3, 1, 2, 4});
        LOGGER.info("Unique Numbers in given input are {} and {}", uniqueNumbers[0], uniqueNumbers[1]);
    }

    public static int[] findUniqueNumbers(int[] input) {
        int xor = 0;
        for (int i = 0; i < input.length; ++i) {
            xor ^= input[i];
        }
        int position = -1;
        for (int i = 0; i < 31; ++i) {
            if ((xor & (1 << i)) > 0) {
                position = i;
                break;
            }
        }
        int firstUniqueNum = 0;
        int secondUniqueNum = 0;
        for (int i = 0; i < input.length; ++i) {
            if ((input[i] & (1 << position)) > 0)
                firstUniqueNum ^= input[i];
            else secondUniqueNum ^= input[i];
        }
        int[] output = new int[2];
        if (firstUniqueNum < secondUniqueNum) {
            output[0] = firstUniqueNum;
            output[1] = secondUniqueNum;
        } else {
            output[0] = secondUniqueNum;
            output[1] = firstUniqueNum;
        }
        return output;
    }
}
