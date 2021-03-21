package week3.multi_dimensional_arrays;

/*
    Given a matrix of integers A of size N x M and an integer B.
    In the given matrix every row and column is sorted in increasing order.
    Find and return the position of B in the matrix in the given form:
    If A[i][j] = B then return (i * 1009 + j)
    If B is not present return -1.
    Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
    Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.

    Input->
       A = [1,2,3
            4,5,6
            7,8,9]
       B = 2
    Output->
        A[1][2]= 2
        1*1009 + 2 =1011

* */
public class SearchInSortedRowsAndColumns {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int solve = solve(input, 2);
        System.out.println(solve);
    }

    public static int solve(int[][] A, int B) {
        int output = -1;
        int top = 0, right = A[0].length - 1;
        while (top <= A.length - 1 && right >= 0) {
            if (A[top][right] == B) {
                int temp = (top + 1) * 1009 + (right + 1);
                if (output == -1 || temp < output) {
                    output = temp;
                }
                --right;
            } else if (B > A[top][right])
                ++top;
            else
                --right;
        }
        return output;
    }
}
