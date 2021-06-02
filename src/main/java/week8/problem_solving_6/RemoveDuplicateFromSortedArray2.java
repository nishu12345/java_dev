package week8.problem_solving_6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/*
    Given a sorted array, remove the duplicates in place such that each element can appear at most twice and return the new length.
    Do not allocate extra space for another array, you must do this in place with constant memory.
    Note that even though we want you to return the new length, make sure to change the original array as well in place
    For example, Given input array A = [1,1,1,2],
    Your function should return length = 3, and A is now [1,1,2].
*/
public class RemoveDuplicateFromSortedArray2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(RemoveDuplicateFromSortedArray2.class);

    public static void main(String[] args) {
//        int[] input = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int[] input = {1000, 1000, 1000, 1000, 1001, 1002, 1003, 1004, 1010};
//        int[] input = {1, 2, 3, 4, 5};
        ArrayList<Integer> inputList = new ArrayList<>();
        for (int num : input)
            inputList.add(num);
        int duplicatesArrayCount = removeDuplicates(inputList);
        LOGGER.info("Duplicate Array Size in given input is {} ", duplicatesArrayCount);

    }

    public static int removeDuplicates(ArrayList<Integer> input) {
        int element = input.get(0);
        int count = 1;
        int firstPointer = 1;
        int secondPointer = 1;
        while (secondPointer < input.size()) {
            if (input.get(secondPointer) == element)
                count++;
            else {
                element = input.get(secondPointer);
                count = 1;
            }
            if (count < 3) {
                int temp = input.get(secondPointer);
                input.remove(firstPointer);
                input.add(firstPointer, temp);
                firstPointer++;

            }
            secondPointer++;
        }
        while (firstPointer < input.size()) {
            input.remove(firstPointer);
        }
        return input.size();
    }
}
