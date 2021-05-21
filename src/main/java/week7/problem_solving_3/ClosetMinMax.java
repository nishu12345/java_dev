package week7.problem_solving_3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array A. Find the size of the smallest subarray such that it contains at-least one occurrence of the maximum value of the array
    and at-least one occurrence of the minimum value of the array.
    Input->
        [3,5,2,5,4,1,2]
    Output->
        3
    Explanation->
        max element = 5 |   min element = 1
        Smallest sub-array having max and min element = 5,4,1 [From index 3 to 5]

*/
public class ClosetMinMax {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClosetMinMax.class);

    public static void main(String[] args) {
        int minMaxLength = minimumMinMaxLength(new int[]{3, 5, 2, 5, 4, 1, 3});
        LOGGER.info("Minimum Length of Sub-Array which contains both minimum and maximum number in given input is {}", minMaxLength);
    }

    public static int minimumMinMaxLength(int[] input) {
        Map<Integer, ArrayList<Integer>> hashed = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; ++i) {
            int current = input[i];
            if (current > max)
                max = current;
            if (current < min)
                min = current;
            if (hashed.containsKey(current)) {
                ArrayList<Integer> temp = hashed.get(current);
                temp.add(i);
                hashed.put(current, temp);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                hashed.put(current, temp);
            }
        }
        if (max == min)
            return 1;
        int output = Integer.MAX_VALUE;
        ArrayList<Integer> maxIndices = hashed.get(max);
        ArrayList<Integer> minIndices = hashed.get(min);
        if (maxIndices.size() >= minIndices.size()) {
            for (int maxIndex : maxIndices) {
                for (int minIndex : minIndices) {
                    int temp = Math.abs(maxIndex - minIndex);
                    if (temp < output)
                        output = temp;
                }
            }
        } else {
            for (int minIndex : minIndices) {
                for (int maxIndex : maxIndices) {
                    int temp = Math.abs(minIndex - maxIndex);
                    if (temp < output)
                        output = temp;
                }
            }

        }

        return output + 1;
    }
}
