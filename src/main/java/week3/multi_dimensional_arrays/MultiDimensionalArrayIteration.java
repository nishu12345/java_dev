package week3.multi_dimensional_arrays;

/*
    Iterate the given multi-dimensional array:-
    Input->
       [1,2,3
        4,5,6
        7,8,9]
     Output->
        From Left to Right -> 1 2 3 4 5 6 7 8 9
        From Right to Left -> 3 2 1 6 5 4 9 8 7
        From Top to Bottom -> 1 4 7 2 5 8 3 6 9
        From Bottom to Top -> 7 4 1 8 5 2 9 6 3
* */


public class MultiDimensionalArrayIteration {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        leftToRight(arr);
        rightToLeft(arr);
        topToBottom(arr);
        bottomToTop(arr);
    }

    public static void leftToRight(int[][] input) {
        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[i].length; ++j) {
                System.out.print(input[i][j] + " ");
            }
        }
    }

    public static void rightToLeft(int[][] input) {
        for (int i = 0; i < input.length; ++i) {
            for (int j = input[i].length - 1; j >= 0; --j) {
                System.out.print(input[i][j] + " ");
            }
        }
    }

    public static void topToBottom(int[][] input) {
        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[i].length; ++j) {
                System.out.print(input[j][i] + " ");
            }
        }
    }

    public static void bottomToTop(int[][] input) {
        for (int i = 0; i < input.length; ++i) {
            for (int j = input[i].length - 1; j >= 0; --j) {
                System.out.print(input[j][i] + " ");
            }
        }
    }
}
