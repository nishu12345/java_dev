package week7.problem_solving_3;

import java.util.ArrayList;

/*
    Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
    The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
    Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
    Note:
        If there is a tie, then compare with segment's length and return segment which has maximum length.
        If there is still a tie, then return the segment with minimum starting index.

   Input->
        [1,2,5,-7,2,3]
   Output->
        [1,2,5]
   Explanation->
        The two sub-arrays are [1, 2, 5] [2, 3].
        The answer is [1, 2, 5] as its sum is larger than [2, 3].

Find and return the required subarray.
*/
public class MaxNonNegativeSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(5);
        input.add(-7);
        input.add(2);
        input.add(3);
        ArrayList<Integer> maxPositiveSumSubArray = maxPositiveSumSubArray(input);
        for(Integer num : maxPositiveSumSubArray){
            System.out.print(num + " ");
        }
    }

    public static ArrayList<Integer> maxPositiveSumSubArray(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<>();
        int sum = Integer.MIN_VALUE;
        int tempSum = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer num : input) {
            if (num >= 0) {
                tempSum += num;
                temp.add(num);
            } else {
                if (tempSum > sum) {
                    sum = tempSum;
                    output = temp;
                }
                tempSum = 0;
                temp = new ArrayList<>();
            }
        }
        if (tempSum > sum)
            output = temp;
        return output;


    }
}
