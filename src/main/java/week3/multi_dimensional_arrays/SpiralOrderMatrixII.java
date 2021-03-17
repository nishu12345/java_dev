package week3.multi_dimensional_arrays;

/*
    Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order
    Input->
        5
    Output->
        [1,2,3
         8,9,4
         7,6,5]
* */

public class SpiralOrderMatrixII {
    public static void main(String[] args) {
        int[][] generateMatrix = generateMatrix(80);
        for (int[] numArray : generateMatrix) {
            for (int num : numArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int A) {
        int[][] output = new int[A][A];
        int top = 0, bottom = A - 1, left = 0, right = A - 1;
        int count = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; ++i) {
                output[top][i] = ++count;
            }
            ++top;
            for (int i = top; i <= bottom; ++i) {
                output[i][right] = ++count;
            }
            --right;
            for (int i = right; i >= left; --i) {
                output[bottom][i] = ++count;
            }
            --bottom;
            for (int i = bottom; i >= top; --i) {
                output[i][left] = ++count;
            }
            ++left;
        }
        return output;
    }
}
