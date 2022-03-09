package week11.searchingOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *   Given a sorted array of integers A where every element appears twice except for one element
 *   which appears once, find and return this single element that appears only once.
 *   Input -> [1,1,7]
 *   Output -> 7
 *   Explanation -> 7 is the unique element in given input array.
 * */
public class SingleElementInSortedArray {
    private static final Logger LOGGER = LoggerFactory.getLogger(SingleElementInSortedArray.class);

    public static void main(String[] args) {
        int[] input = {1, 1, 7};
        int singleElement = findSingleElement(input);
        LOGGER.info("Single Element in given input array is {}", singleElement);
    }

    public static int findSingleElement(int[] input) {
        int start = 0, mid, end = input.length - 1;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (
                    (mid == 0 && input[mid] != input[mid + 1]) ||
                            (mid == input.length - 1 && input[mid] != input[mid - 1]) ||
                            ((mid != 0 && mid != input.length - 1) && (input[mid] != input[mid - 1] && input[mid] != input[mid + 1]))
            )
                return input[mid];
            int first = mid;
            if (mid != 0 && input[mid] == input[mid - 1])
                first = mid - 1;
            if (first % 2 == 0)
                start = mid + 1;
            else end = mid - 1;


        }
        return -1;
    }
}
