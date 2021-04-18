package week4.introduction_to_hashing_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
    If the answer does not exist return an array with a single element "-1".
    First sub-array means the sub-array for which starting index in minimum.

    Input->
        A = [1, 2, 3, 4, 5]
        B = 5
    Output->
        [2, 3]
    Explanation->
        [2, 3] sums up to 5.
*/
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        ArrayList<Integer> subArrayWithGivenSum = subArrayWithGivenSum(input, 5);
        for (Integer num : subArrayWithGivenSum) {
            System.out.print(num + " ");
        }
    }

    public static ArrayList<Integer> subArrayWithGivenSum(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        output.add(-1);
        long prefixSum = 0L;
        Map<Long, Integer> hashed = new HashMap<>();
        hashed.put(0L, 0);
        for (int i = 0; i < A.size(); i++) {
            prefixSum += A.get(i);
            if (hashed.containsKey(prefixSum - B)) {
                output.remove(0);
                int start = hashed.get(prefixSum - B);
                for (int j = start; j <= i; j++) {
                    output.add(A.get(j));
                }
                break;
            } else
                hashed.put(prefixSum, i + 1);
        }
        return output;
    }
}
