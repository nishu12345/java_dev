package week8.problem_solving_4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
    You may assume that the array is non-empty and the majority element always exist in the array.
    Input->
        [2,1,2]
    Output->
        2
    Explanation->
        It occurs 2 times which is greater than 3/2.
*/
public class MajorityElements {
    public static final Logger LOGGER = LoggerFactory.getLogger(MajorityElements.class);

    public static void main(String[] args) {
        int majorityElement = findMajorityElement(new int[]{2, 1, 2});
        LOGGER.info("Majority Element in given input is {}", majorityElement);
    }

    public static int findMajorityElement(int[] input) {
        int floor = input.length / 2;
        Map<Integer, Integer> hashed = new HashMap<>();
        for (int i = 0; i < input.length; ++i) {
            int current = input[i];
            if (hashed.containsKey(current)) {
                if (hashed.get(current)+1 > floor)
                    return current;
                else hashed.put(current, hashed.get(current) + 1);
            } else hashed.put(current, 1);
        }
        return input[0];
    }
}
