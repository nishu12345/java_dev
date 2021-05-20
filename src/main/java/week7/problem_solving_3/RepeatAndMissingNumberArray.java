package week7.problem_solving_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given a read only array of n integers from 1 to n.
    Each integer appears exactly once except A which appears twice and B which is missing.
    Return A and B.
    Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
    Note that in your output A should precede B.
    Input->
        [3,1,2,5,3]
    Output->
        Duplicate - 3   |   Missing - 4
*/
public class RepeatAndMissingNumberArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepeatAndMissingNumberArray.class);

    public static void main(String[] args) {
        int[] duplicateAndMissing = findDuplicateAndMissing(new int[]{3, 1, 2, 5, 3});
        LOGGER.info("In given input, Duplicate number is {} and Missing number is {}", duplicateAndMissing[0], duplicateAndMissing[1]);
    }

    public static int[] findDuplicateAndMissing(final int[] input) {
        long diff = 0;
        long squareDiff = 0;
        for (int i = 1; i <= input.length; ++i) {
            int current = input[i - 1];
            diff = diff + (current - i);
            squareDiff = squareDiff + (long) (Math.pow(current, 2) - Math.pow(i, 2));
        }
        int duplicate = (int) (((squareDiff / diff) + diff) / 2);
        int missing = (int) (duplicate - diff);
        int[] output = new int[2];
        output[0] = duplicate;
        output[1] = missing;
        return output;
    }
}
