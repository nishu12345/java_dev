package week3.arrays_and_dynamic_arrays;

import java.util.Arrays;

/*
* Given an array of integers A and multiple values in B which represents the indices of the array A around which left rotation of the array A needs to be performed.
  Find the rotated array for each value and return the result in the from of a matrix where i'th row represents the rotated array for the ith value in B.
  Input:
    A = [1, 2, 3, 4, 5]
    B = [2, 3]
  Output:
        [ [3, 4, 5, 1, 2]
          [4, 5, 1, 2, 3] ]
* */
public class MultipleLeftRotation {
    public static int[][] solve(int[] A, int[] B) {
        int length = A.length;
        int[][] output = new int[B.length][length];
        int j = 0;
        for (int rotationCount : B) {
            int[] C = reverseArray(Arrays.copyOf(A, A.length), 0, length - 1);
            reverseArray(C, 0, (length - (rotationCount % length) - 1));
            reverseArray(C, (length - (rotationCount % length)), length - 1);
            output[j++] = C;
        }
        return output;
    }

    private static int[] reverseArray(int[] A, int start, int end) {
        int limit = start + ((end + 1) - start) / 2;
        for (int i = start; i < limit; i++) {
            A[i] = A[i] + A[end];
            A[end] = A[i] - A[end];
            A[i] = A[i] - A[end];
            --end;
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] solve = solve(new int[]{1, 2, 3, 4, 5}, new int[]{2, 3});
        for (int[] num : solve) {
            for (int num1 : num) {
                System.out.print(num1 + " ");
            }
            System.out.println();
        }
    }
}
