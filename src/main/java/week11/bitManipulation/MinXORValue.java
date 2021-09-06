package week11.bitManipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value.
    Report the minimum XOR value.
    Input -> [0,4,7,9]
    Output -> 3
*/
public class MinXORValue {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinXORValue.class);

    public static void main(String[] args) {
        int minXor = calMinXor(new int[]{0, 4, 7, 9});
        LOGGER.info("Min XOR pair in given input is {}", minXor);
    }

    public static int calMinXor(int[] input) {
        int minXor = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; ++i) {
            for (int j = i + 1; j < input.length; ++j) {
                int xor = input[i] ^ input[j];
                if (xor < minXor)
                    minXor = xor;
            }
        }
        return minXor;
    }
}
