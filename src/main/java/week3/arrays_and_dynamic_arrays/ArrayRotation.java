package week3.arrays_and_dynamic_arrays;

import static week3.arrays_and_dynamic_arrays.ArrayReverse.reverseArray;

/*
 *   Rotate an array clockwise/left-rotation with k-steps
 *   Input  -> [1,2,3,4,5,6,7,8,9,10,11,12]
 *              k -> 4
 *   Output -> [5,6,7,8,9,10,11,12,1,2,3,4]
 *   Time Complexity -> O(n)
 *
 *   Rotate an array anti-clockwise/right-rotation with k-steps
 *   Input  -> [1,2,3,4,5,6,7,8,9,10,11,12]
 *              k -> 4
 *   Output -> {9,10,11,12,1,2,3,4,5,6,7,8}
 *   Time Complexity -> O(n)
 * */
public class ArrayRotation {
    public static int[] leftArrayRotation(int[] input, int k) {
        reverseArray(input, 0, input.length - 1);
        reverseArray(input, 0, input.length - (k + 1));
        reverseArray(input, input.length - k, input.length - 1);
        return input;
    }

    public static int[] rightArrayRotation(int[] input, int k) {
        reverseArray(input, 0, input.length - 1);
        reverseArray(input, 0, k - 1);
        reverseArray(input, k, input.length - 1);
        return input;
    }

    public static void main(String[] args) {
        int[] leftRotatedArray = leftArrayRotation(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 4);
        for (int num : leftRotatedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] rightRotatedArray = rightArrayRotation(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 4);
        for (int num : rightRotatedArray) {
            System.out.print(num + " ");
        }
    }
}
