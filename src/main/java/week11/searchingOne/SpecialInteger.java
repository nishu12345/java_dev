package week11.searchingOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
    Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray
    in A of size K with sum of elements greater than B. All the sub array of that maximum value K should have their sum
    less than or equal to B.
    Input -> [5,10,20,100,105]      maximumSum -> 130
    Output -> 1
    Explanation -> Sub Array of length 1 is possible where all the sub array sum is less than or equal to 130.
*/
public class SpecialInteger {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpecialInteger.class);

    public static void main(String[] args) {
//        int[] input = {5,10,20,100,105};
//        int maximumSum = 130;
        int[] input = {5,17,100,11};
        int maximumSum = 130;
        int maximumSubArrayLength = getMaximumSubArrayLength(input, maximumSum);
        LOGGER.info("Maximum Sub Array Length whose sum is less" +
                " than of equal to {} is {}",maximumSum,maximumSubArrayLength);
    }

    public static int getMaximumSubArrayLength(int[] input, int maximumSum){
        int start = 0, mid, end = input.length-1;
        int ans = -1;
        while(start<=end){
            mid = start + ((end-start)/2);
            if(validateConstraint(input,mid,maximumSum)==0){
                ans = mid;
                start = mid+1;
            }else end = mid-1;
        }
       return ans+1;
    }
    public static int validateConstraint(int[] input, int subArraySize, int maximumSum) {
        long prefixSum = 0;
        for (int i = 0; i <= subArraySize; ++i) {
            prefixSum += input[i];
        }
        if (prefixSum > maximumSum)
            return -1;
        int temp = 0;
        for (int j = subArraySize + 1; j < input.length; ++j) {
            prefixSum = (prefixSum + input[j]) - input[temp];
            if (prefixSum > maximumSum)
                return -1;
        }
        return 0;
    }
}
