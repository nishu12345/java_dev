package week4.introduction_to_sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/*
    Find the Bth smallest element in given array A. Try to solve it in <= B swaps
    Input->
        A = [8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92]
        k = 9
    Output -> 17
*/
public class KthSmallest {
    private static final Logger LOGGER = LoggerFactory.getLogger(KthSmallest.class);

    public static void main(String[] args) {
        int[] input = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        int kthSmallestNumber = getKthSmallestNumber(input, 9);
        LOGGER.info("9th smallest number in above array is {} ", kthSmallestNumber);
    }

    public static int getKthSmallestNumber(int[] input, int k) {
        for (int i = 0; i < k; ++i) {
            int smallestNumberIndex = getSmallestNumberIndex(input, i);
            if (smallestNumberIndex != i) {
                input[i] = input[i] + input[smallestNumberIndex];
                input[smallestNumberIndex] = input[i] - input[smallestNumberIndex];
                input[i] = input[i] - input[smallestNumberIndex];
            }
        }
        return input[k - 1];
    }

    public static int getSmallestNumberIndex(int[] input, int begin) {
        int smallestNumber = Integer.MAX_VALUE;
        int output = 0;
        for (int i = begin; i < input.length; ++i) {
            if (input[i] < smallestNumber) {
                smallestNumber = input[i];
                output = i;
            }
        }
        return output;
    }
}
