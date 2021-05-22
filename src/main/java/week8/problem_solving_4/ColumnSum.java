package week8.problem_solving_4;

/*
    You are given a 2D integer matrix A, return a 1D integer vector containing column-wise sums of original matrix.
    Input->
        [1,2,3,4]
        [5,6,7,8]
        [9,2,3,4]
    Output->
        [15,10,13,16]
    Explanation->
        Column 1 = 1+5+9 = 15
        Column 2 = 2+6+2 = 10
        Column 3 = 3+7+3 = 13
        Column 4 = 4+8+4 = 16
*/
public class ColumnSum {

    public static void main(String[] args) {
        int[] columnSum = calColumnSum(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 2, 3, 4}});
        for (int num : columnSum) {
            System.out.print(num + " ");
        }
    }

    public static int[] calColumnSum(int[][] input) {
        int[] output = new int[input[0].length];
        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[i].length; ++j) {
                output[j] = output[j] + input[i][j];
            }
        }
        return output;
    }
}
