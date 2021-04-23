package week4.introduction_to_sorting;

/*
    Given an integer array A of size N. You need to sort the elements in increasing order using SelectionSort.
    Return a array containing the min value's index position before every iteration.
    Input->
        A = [6, 4, 3, 7, 2, 8]
    Output->
        [4, 2, 2, 4, 4]
    Explanation->
        6 4 3 7 2 8 : Index of 1st min - 4
        After 1st Iteration : 2 4 3 7 6 8 : Index of 2nd min - 2
        After 2nd Iteration : 2 3 4 7 6 8 : Index of 3rd min - 2
        After 3rd Iteration : 2 3 4 7 6 8 : Index of 4th min - 4
        After 4th iteration : 2 3 4 6 7 8 : Index of 5th min - 4
        After 5th iteration. : 2 3 4 6 7 8.
 */
public class StepWiseSelectionSort {

    public static void main(String[] args) {
        int[] smallestNumIndices = getSmallestNumIndices(new int[]{6, 4, 3, 7, 2, 8});
        for (int num : smallestNumIndices)
            System.out.print(num + " ");
    }

    public static int[] getSmallestNumIndices(int[] A) {
        int[] output = new int[A.length - 1];
        for (int i = 0; i < A.length - 1; ++i) {
            int smallestNumIndex = getSmallestNumIndex(A, i);
            if (smallestNumIndex != -1) {
                if (smallestNumIndex != i) {
                    output[i] = smallestNumIndex;
                    A[i] = A[i] + A[smallestNumIndex];
                    A[smallestNumIndex] = A[i] - A[smallestNumIndex];
                    A[i] = A[i] - A[smallestNumIndex];
                } else output[i] = i;
            }
        }
        return output;
    }

    public static int getSmallestNumIndex(int[] input, int begin) {
        int smallestNumber = Integer.MAX_VALUE;
        int output = -1;
        for (int i = begin; i < input.length; ++i) {
            if (input[i] < smallestNumber) {
                smallestNumber = input[i];
                output = i;
            }
        }
        return output;
    }

}
