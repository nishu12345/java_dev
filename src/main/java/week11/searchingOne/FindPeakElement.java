package week11.searchingOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Given an array of integers A, find and return the peak element in it.
 * An array element is peak if it is NOT smaller than its neighbors.
 * For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
 * Input-> [5,17,100,11]
 * Output-> 100
 * Explanation-> 100 is greater than both of it's neighbour i.e. 17 < 100 > 11
 * */
public class FindPeakElement {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindPeakElement.class);

    public static void main(String[] args) {
        int[] input = {5, 17, 100, 11};
        int peakElement = findPeak(input);
        LOGGER.info("Peak Element in given input is {}", peakElement);
    }

    public static int findPeak(int[] input) {
        int start = 0, mid = 0, end = input.length - 1;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if ((mid == 0 && input[mid] >= input[mid + 1])
                    || (mid == input.length - 1 && input[mid] >= input[mid - 1])
                    || ((mid != 0 && mid != input.length - 1) && (input[mid] > input[mid - 1] && input[mid] > input[mid + 1])))
                return input[mid];
            else if ((mid != 0 && mid != input.length - 1) && (input[mid - 1] >= input[mid + 1]))
                end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
