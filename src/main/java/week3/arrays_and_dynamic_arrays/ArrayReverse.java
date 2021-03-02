package week3.arrays_and_dynamic_arrays;

/*
 *   Given an array, reverse it.
 *   Input  -> [1,2,3,4]
 *   Output -> [4,3,2,1]
 *   Time Complexity - O(n)
 *
 *   Reverse a sub-array from given array.
 *   Input  -> [1,2,3,4,5,6,7,8,9]
 *             start -> 2
 *             end   -> 7
 *   Output  -> [1,2,8,7,6,5,4,3,9]
 *
 * */
public class ArrayReverse {

    /* Reverse the complete array */
    public static int[] reverseArray(int[] input) {
        int length = input.length;
        for (int i = 0; i < length / 2; i++) {
            input[i] = input[i] + input[length - (i + 1)];
            input[length - (i + 1)] = input[i] - input[length - (i + 1)];
            input[i] = input[i] - input[length - (i + 1)];
        }
        return input;
    }

    /* Reverse a sub-array */
    public static int[] reverseArray(int[] input, int start, int end) {
        int limit = start + (((end + 1) - start)) / 2;
        for (int i = start; i < limit; i++) {
            input[i] = input[i] + input[end];
            input[end] = input[i] - input[end];
            input[i] = input[i] - input[end];
            end--;
        }
        return input;
    }

    public static void main(String[] args) {
        int[] reversedArray = reverseArray(new int[]{1, 2, 3, 4});
        int[] reversedSubArray = reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2, 7);
        for (int num : reversedArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : reversedSubArray) {
            System.out.print(num + " ");
        }
    }
}
