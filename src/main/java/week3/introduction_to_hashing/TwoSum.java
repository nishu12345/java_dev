package week3.introduction_to_hashing;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers, find two numbers such that they add up to a specific target number.
    If multiple results are there return the index with least value. And if no pair exist return empty list.
    Input->
        [2, 7, 11, 15], target=9
    Output:
        index1 = 1, index2 = 2

 */
public class TwoSum {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int[] output = twoSum(input, 9);
        for (int index : output) {
            System.out.print(index + " ");
        }
    }

    public static int[] twoSum(int[] input, int target) {
        Map<Integer, Integer> hashed = new HashMap<>();
        int[] output = new int[0];
        for (int i = 0; i < input.length; ++i) {
            if (hashed.containsKey(target - input[i])) {
                output = new int[2];
                output[0] = hashed.get(target - input[i]);
                output[1] = i + 1;
                break;
            } else if (!hashed.containsKey(input[i])) {
                hashed.put(input[i], i + 1);
            }
        }
        return output;
    }
}
