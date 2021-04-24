package week4.introduction_to_sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
    You are given an array A of N elements. You have to make all elements unique, to do so in one step you can increase any number by one.
    Find the minimum number of steps.
    Input->
        [1,1,3]
    Output->
        1
    Explanation->
        We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].


*/
public class UniqueElements {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniqueElements.class);

    public static void main(String[] args) {
        int[] input = new int[]{51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62};
        int minStepsToUniqueArray = minStepsToUniqueArray(input);
        LOGGER.info("Steps require to make [51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62] unique is {}", minStepsToUniqueArray);
    }

    public static int minStepsToUniqueArray(int[] input) {
        int steps = 0;
        Arrays.sort(input);
        for (int i = 1; i < input.length; ++i) {
            if (input[i - 1] >= input[i]) {
                int temp = input[i];
                input[i] = input[i - 1] + 1;
                steps += input[i] - temp;
            }
        }
        return steps;
    }
}
