package week4.introduction_to_hashing_2;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
    If the given array contains a sub-array with sum zero return 1 else return 0.
    Input->
    A = [1, 2, -1, -2]
    Output-> 1

*/
public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        int checkSubArrayWithSumZero = checkSubArrayWithSumZero(new int[]{1, 2, -1});
        System.out.println("Is subarray present with sum equal 0? " + checkSubArrayWithSumZero);
    }

    public static int checkSubArrayWithSumZero(int[] input) {
        int prefixSum = 0;
        Map<Integer, Boolean> hashed = new HashMap<>();
        hashed.put(0, true);
        for (int i = 0; i < input.length; ++i) {
            prefixSum += input[i];
            if (hashed.containsKey(prefixSum))
                return 1;
            else
                hashed.put(prefixSum, true);
        }
        return 0;
    }
}
