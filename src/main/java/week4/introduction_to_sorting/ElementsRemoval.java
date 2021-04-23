package week4.introduction_to_sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given an integer array A of size N. In one operation, you can remove any element from the array,
    and the cost of this operation is the sum of all elements in the array present before this operation.
    Find the minimum cost to remove all elements from the array.
    Input->
         A = [2, 1]
    Output->
        4
    Explanation->
        Given array A = [2, 1]
        Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
        Remove 1 from the array => []. Cost of this operation is (1) = 1.
        So, total cost is = 3 + 1 = 4.
*/
public class ElementsRemoval {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElementsRemoval.class);

    public static void main(String[] args) {
        int minCostRemoval = minCostRemoval(new int[]{8, 0, 10});
        LOGGER.info("Min Cost of element removal for [8,0,10] {}", minCostRemoval);
    }

    public static int minCostRemoval(int[] A) {
        int totalCost = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int[] sumAndLargestNumIndex = calSumAndLargestNumIndex(A, i);
            int largestNumIndex = sumAndLargestNumIndex[0];
            int sum = sumAndLargestNumIndex[1];
            totalCost += sum;
            if (largestNumIndex != i && largestNumIndex != -1) {
                A[i] = A[i] + A[largestNumIndex];
                A[largestNumIndex] = A[i] - A[largestNumIndex];
                A[i] = A[i] - A[largestNumIndex];
            }
        }
        totalCost += A[A.length - 1];
        return totalCost;
    }

    public static int[] calSumAndLargestNumIndex(int[] input, int begin) {
        int[] output = new int[2];
        int sum = 0;
        int largestNum = Integer.MIN_VALUE;
        int largestNumIndex = -1;
        for (int i = begin; i < input.length; ++i) {
            sum += input[i];
            if (input[i] > largestNum) {
                largestNum = input[i];
                largestNumIndex = i;
            }
        }
        output[0] = largestNumIndex;
        output[1] = sum;
        return output;
    }
}
