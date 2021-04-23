package week4.introduction_to_sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementsRemoval {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElementsRemoval.class);

    public static void main(String[] args) {
        int minCostRemoval = minCostRemoval(new int[]{8,0,10});
        LOGGER.info("Min Cost of element removal for [2,3,1,4] {}", minCostRemoval);
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
