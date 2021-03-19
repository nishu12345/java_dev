package week3.multi_dimensional_arrays;

/*
    You are given a n x n 2D matrix A representing an image.
    Rotate the image by 90 degrees (clockwise).
    Don't use extra space.
    Input->
        [1,2
         3,4]
    Output->
        [3,1
         4,2]
* */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        transpose(A);
        for (int[] numArray : A) {
            reverse(numArray);
        }
        for (int[] numArray : A) {
            for (int num : numArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void transpose(int[][] A) {
        for (int i = 0; i < A.length; ++i) {
            for (int j = i; j < A.length; ++j) {
                if (i != j) {
                    A[i][j] = A[i][j] + A[j][i];
                    A[j][i] = A[i][j] - A[j][i];
                    A[i][j] = A[i][j] - A[j][i];
                }
            }
        }
    }

    private static void reverse(int[] input) {
        int length = input.length;
        for (int i = 0; i < input.length / 2; ++i) {
            input[i] = input[i] + input[length - 1];
            input[length - 1] = input[i] - input[length - 1];
            input[i] = input[i] - input[length - 1];
            --length;
        }
    }

}
