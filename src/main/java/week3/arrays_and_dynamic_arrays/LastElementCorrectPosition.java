package week3.arrays_and_dynamic_arrays;

/*
    In the given array (n-1) elements are sorted.
    Place the last element at it's correct position.
    Input  -> [1,2,3,6,8,15,20,14]
    Output -> [1,2,3,6,8,14,15,20]
* */
public class LastElementCorrectPosition {
    public static int[] sortLastElement(int[] input) {
//        int[] arr = {1, 2, 3, 6, 8, 15, 20, 14};
        int length = input.length;
        for (int i = 0; i < length; i++) {
            if (input[i] > input[length - 1]) {
                input[i] = input[i] + input[length - 1];
                input[length - 1] = input[i] - input[length - 1];
                input[i] = input[i] - input[length - 1];
            }
        }
        return input;
    }

    public static void main(String[] args) {
        int[] output = sortLastElement(new int[]{1, 2, 3, 6, 8, 15, 20, 14});
        for (int num : output) {
            System.out.print(num + " ");
        }
    }

}
