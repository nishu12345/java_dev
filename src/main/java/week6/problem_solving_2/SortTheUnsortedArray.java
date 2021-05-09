package week6.problem_solving_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    You are given an integer array A having N integers.
    You have to find the minimum length subarray A[l..r] such that sorting this subarray makes the whole array sorted.
    Input->
        [0, 1, 15, 25, 6, 7, 30, 40, 50]
    Output->
        4
    Explanation->
         The smallest subarray to be sorted to make the whole array sorted =  A[3..6] i.e, subarray lying between positions 3 and 6.
*/
public class SortTheUnsortedArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(SortTheUnsortedArray.class);

    public static void main(String[] args) {
        int unsortedLength = maxUnsortedLength(new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50});
        LOGGER.info("Maximum length of sub-array which will sort the complete array is {}", unsortedLength);
    }

    public static int maxUnsortedLength(int[] input) {
        int[] temp = input.clone();
        Arrays.sort(temp);
        int startIndex = -1;
        int endIndex = 0;
        for (int i = 0; i < input.length; ++i) {
            if (input[i] != temp[i]) {
                if (startIndex == -1)
                    startIndex = i;
                endIndex = i;
            }
        }
        if (startIndex == -1)
            return 0;
        return (endIndex + 1) - startIndex;
    }
}
