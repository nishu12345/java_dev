package week6.problem_solving_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    Given an array of positive integers A, check and return whether the array elements are consecutive or not.
    NOTE: Try this with O(1) extra space.
    Input->
        1,2,3,4,5
    Output->
        1
*/
public class ArrayWithConsecutiveNumbers {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayWithConsecutiveNumbers.class);

    public static void main(String[] args) {
        int isConsecutive = checkConsecutive(new int[]{1, 2, 3, 4, 5});
        LOGGER.info("Is given array have consecutive elements {}", isConsecutive);
    }

    public static int checkConsecutive(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i < A.length; ++i) {
            if (A[i] - A[i - 1] != 1)
                return 0;
        }
        return 1;
    }
}
