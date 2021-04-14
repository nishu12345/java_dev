package week3.introduction_to_hashing;

import java.util.HashMap;
import java.util.Map;

/*
    Given an 1D integer array A containing N distinct integers.
    Find the number of unique pairs of integers in the array whose XOR is equal to B.
    Input->
            A = [5, 4, 10, 15, 7, 6]
            B = 5
    Output->
        1 [10 ^ 15 = 5]
*/
public class PairsWithGivenXor {
    public static void main(String[] args) {
        int countXorPairs = countXorPairs(new int[]{5, 4, 10, 15, 7, 6}, 5);
        System.out.println("Total Count of Xor Pairs >" + countXorPairs);
    }

    public static int countXorPairs(int[] input, int b) {
        int count = 0;
        Map<Integer, Boolean> hashed = new HashMap<>();
        for (int num : input) {
            if (hashed.containsKey(b ^ num))
                count++;
            else
                hashed.put(num, true);
        }
        return count;
    }
}
