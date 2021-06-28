package week10.timeAndSpacePlusArrays;

import java.util.ArrayList;

/*
    Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
    The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
    Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
    Find and return the required subarray.
    NOTE:
        1. If there is a tie, then compare with segment's length and return segment which has maximum length.
        2. If there is still a tie, then return the segment with minimum starting index.
    Input->
        [1, 2, 5, -7, 2, 3]
    Output->
        [1, 2, 5]
    Explanation->
        The two sub-arrays are [1, 2, 5] [2, 3].
        The answer is [1, 2, 5] as its sum is larger than [2, 3].
*/
public class MaxNonNegativeSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(10);
        input.add(-1);
        input.add(2);
        input.add(3);
        input.add(-4);
        input.add(100);
        ArrayList<Integer> integers = maxPositiveSubArray(input);
        for (Integer num : integers)
            System.out.print(num + " ");
    }

    public static ArrayList<Integer> maxPositiveSubArray(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Long sum = 0L;
        Long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < input.size(); ++i) {
            if (input.get(i) < 0) {
                if (sum > maxSum || (sum == maxSum && temp.size() > output.size())) {
                    maxSum = sum;
                    output = temp;
                }
                sum = 0L;
                temp = new ArrayList<>();
            } else {
                sum += input.get(i);
                temp.add(input.get(i));
            }
        }
        if (sum > maxSum || (sum == maxSum && temp.size() > output.size()))
            output = temp;

        return output;

    }
}
