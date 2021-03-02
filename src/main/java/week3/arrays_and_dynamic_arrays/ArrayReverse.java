package week3.arrays_and_dynamic_arrays;

/*
 *   Given an array, reverse it.
 *   Input  -> [1,2,3,4]
 *   Output -> [4,3,2,1]
 *   Time Complexity - O(n)
 * */
public class ArrayReverse {
    public static int[] reverseArray(int[] input) {
        int length = input.length;
        for (int i = 0; i < length / 2; i++) {
            input[i] = input[i] + input[length - (i + 1)];
            input[length - (i + 1)] = input[i] - input[length - (i + 1)];
            input[i] = input[i] - input[length - (i + 1)];
        }
        return input;
    }

    public static void main(String[] args) {
        int[] output = reverseArray(new int[]{1, 2, 3, 4});
        for (int num : output) {
            System.out.print(num + " ");
        }
    }
}
