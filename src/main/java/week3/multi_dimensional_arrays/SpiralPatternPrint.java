package week3.multi_dimensional_arrays;

/*
    Print a 2D matrix in spiral pattern.
    Input->
            [1, 2, 3, 4
             5, 6, 7, 8
             9,10,11,12
            13,14,15,16]

     Output->
        1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
* */
public class SpiralPatternPrint {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printingInSpiral(arr);
    }

    public static void printingInSpiral(int[][] input) {
        int top = 0, left = 0;
        int bottom = input.length - 1, right = input.length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; ++i)
                System.out.print(input[top][i] + " ");
            ++top;

            for (int i = top; i <= bottom; ++i)
                System.out.print(input[i][right] + " ");
            --right;

            for (int i = right; i >= left; --i)
                System.out.print(input[bottom][i] + " ");
            --bottom;

            for (int i = bottom; i >= top; --i)
                System.out.print(input[i][left] + " ");
            ++left;
        }
    }
}
