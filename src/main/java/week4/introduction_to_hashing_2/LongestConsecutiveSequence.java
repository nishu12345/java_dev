package week4.introduction_to_hashing_2;

import java.util.HashMap;
import java.util.Map;

/*
    Given an unsorted integer array A of size N.
    Find the length of the longest set of consecutive elements from the array A.
    Input-> [100, 4, 200, 1, 3, 2]
    Output-> 4
    Explanation-> The set of consecutive elements will be [1, 2, 3, 4].
*/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int longestConsecutiveSequenceLength = findLongestConsecutiveSequenceLength(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println("Longest Consecutive Sequence Length > " + longestConsecutiveSequenceLength);
    }

    public static int findLongestConsecutiveSequenceLength(int[] input) {
        int output = 0;
        Map<Integer, Boolean> hashed = new HashMap<>();
        for (int num : input) {
            hashed.put(num, true);
        }
        for (int num : input) {
            int temp = 0;
            if (!hashed.containsKey(num - 1)) {
                temp = 1;
                int a = num;
                while (hashed.containsKey(++a))
                    temp++;
                if (temp > output)
                    output = temp;
            }
        }
        return output;
    }
}
