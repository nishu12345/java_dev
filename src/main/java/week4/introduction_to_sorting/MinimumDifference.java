package week4.introduction_to_sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers A of size, N. Minimize the absolute difference between the maximum and minimum element of the array.
    You can perform two types of operations at most B times in total to change the values in the array.
    Multiple operations can be performed on the same element.
        Increment : A[i] -> A[i] + 1.
        Decrement : A[i] -> A[i] - 1.
    Return the minimum difference possible.
    Input->
        A = [2, 6, 3, 9, 8]
        B = 3
    Output->
        5
     Explanation->
         We can apply the atmost 3 operations in the following sequence.
         Initial array => [2, 6, 3, 9, 8].
         Decrement 9 => [2, 6, 3, 8, 8].
         Increment 2 => [3, 6, 3, 8, 8].
         Increment 3 => [3, 6, 4, 8, 8].
         Max = 8. Min = 3.
         Therefore, abs|Max - Min| = |8 - 3| = 5.
*/
public class MinimumDifference {
    private static final Logger LOGGER = LoggerFactory.getLogger(MinimumDifference.class);

    public static void main(String[] args) {
        int calMinDifference = calMinDifference(new int[]{2, 6, 3, 9, 8}, 3);
        LOGGER.info("Min Difference in [2,6,3,9,8] between max and min number in 3 steps is {} ", calMinDifference);
//        int calMinDifference = calMinDifference(new int[]{4, 1}, 6);
//        LOGGER.info("Min Difference in [4,1] between max and min number in 6 steps is {} ", calMinDifference);
//        int calMinDifference = calMinDifference(new int[]{9, 6, 2, 4, 1, 2, 3, 3}, 10);
//        LOGGER.info("Min Difference in [9,6,2,4,1,2,3,3] between max and min number in 10 steps is {} ", calMinDifference);
    }

    public static int calMinDifference(int[] A, int B) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int smallestNumber = Integer.MAX_VALUE;
        int largestNumber = Integer.MIN_VALUE;

        for (int num : A) {
            if (num < smallestNumber)
                smallestNumber = num;
            if (num > largestNumber)
                largestNumber = num;
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else frequencyMap.put(num, 1);
        }

        while (B > 0) {
            int largestNumberFrequency = frequencyMap.get(largestNumber);
            int smallestNumberFrequency = frequencyMap.get(smallestNumber);
            if (largestNumberFrequency <= B && largestNumberFrequency <= smallestNumberFrequency) {
                frequencyMap.remove(largestNumber);
                if (smallestNumber == largestNumber)
                    smallestNumber--;
                largestNumber--;
                if (frequencyMap.containsKey(largestNumber)) {
                    frequencyMap.put(largestNumber, frequencyMap.get(largestNumber) + largestNumberFrequency);
                } else {
                    frequencyMap.put(largestNumber, largestNumberFrequency);
                }
                B -= largestNumberFrequency;
            } else if (smallestNumberFrequency <= B) {
                frequencyMap.remove(smallestNumber);
                if (largestNumber == smallestNumber)
                    largestNumber++;
                smallestNumber++;
                if (frequencyMap.containsKey(smallestNumber)) {
                    frequencyMap.put(smallestNumber, frequencyMap.get(smallestNumber) + smallestNumberFrequency);
                } else {
                    frequencyMap.put(smallestNumber, smallestNumberFrequency);
                }
                B -= smallestNumberFrequency;
            } else {
                B--;
            }
        }
        if (largestNumber >= smallestNumber)
            return largestNumber - smallestNumber;
        else return smallestNumber + largestNumber;
    }
}
