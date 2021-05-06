package week6.problem_solving_1;

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
public class ElementRemoval {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementRemoval.class);

    public static void main(String[] args) {
        int[] input = {5, 1, 3, 2, 4};
//        int[] input = {8, 0, 10};
        int sum = 0;
        for (int i = 0; i < input.length; ++i) {
            int[] sumAndIndex = largestNumIndex(input, i);
            int largestNumIndex = sumAndIndex[0];
            int tempSum = sumAndIndex[1];
            sum += tempSum;
            if (largestNumIndex != i && largestNumIndex != -1) {
                input[i] = input[i] + input[largestNumIndex];
                input[largestNumIndex] = input[i] - input[largestNumIndex];
                input[i] = input[i] - input[largestNumIndex];
            }
        }
        LOGGER.info("Minimum cost to remove all the elements from input is {}", sum);
    }

    public static int[] largestNumIndex(int[] input, int index) {
        int largestNum = Integer.MIN_VALUE;
        int largestNumIndex = -1;
        int sum = 0;
        for (int i = index; i < input.length; ++i) {
            sum += input[i];
            if (input[i] > largestNum) {
                largestNumIndex = i;
                largestNum = input[i];
            }
        }
        int[] output = new int[2];
        output[0] = largestNumIndex;
        output[1] = sum;
        return output;
    }
}
