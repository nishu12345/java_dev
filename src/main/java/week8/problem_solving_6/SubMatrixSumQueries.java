package week8.problem_solving_6;

/*
    Given a matrix of integers A of size N x M and multiple queries Q, for each query find and return the sub-matrix sum.
    Inputs to queries are top left (b, c) and bottom right (d, e) indexes of sub-matrix whose sum is to find out.
    NOTE:
        Rows are numbered from top to bottom and columns are numbered from left to right.
        Sum may be large so return the answer mod 109 + 7.
    Input->
        A = [
             [1, 2, 3]
             [4, 5, 6]
             [7, 8, 9]   ]
        B = [1, 2]
        C = [1, 2]
        D = [2, 3]
        E = [2, 3]

   Output->
        [12,28]
   Explanation->
    For query 1: Sub-matrix contains elements: 1, 2, 4 and 5. So, their sum is 12.
    For query 2: Sub-matrix contains elements: 5, 6, 8 and 9. So, their sum is 28.
*/
public class SubMatrixSumQueries {
    public static void main(String[] args) {
//        int[] querySum = giveQuerySum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[]{1, 2}, new int[]{1, 2}, new int[]{2, 3}, new int[]{2, 3});
        int[] querySum = giveQuerySum(new int[][]{{5,17,100,11}, {0,0,2,8}}, new int[]{1, 1}, new int[]{1, 4}, new int[]{2, 2}, new int[]{2, 4});

        for (int num : querySum)
            System.out.print(num + " ");
    }

    public static int[] giveQuerySum(int[][] input, int[] top, int[] left, int[] bottom, int[] right) {
        calMatrixSum(input);
        int[] output = new int[top.length];
        for (int i = 0; i < top.length; ++i) {
            long sum = 0;
            int t = top[i];
            int l = left[i];
            int b = bottom[i];
            int r = right[i];
            if ((t - 1) != 0 && (l - 1) != 0)
                sum = (input[b - 1][r - 1] + input[t - 2][l - 2]) - (input[t - 2][r - 1] + input[b - 1][l - 2]);
            else if ((t - 1) == 0 && (l - 1) == 0)
                sum = input[b - 1][r - 1];
            else if ((t - 1) == 0 && (l - 1) != 0)
                sum = input[b - 1][r - 1] - input[b - 1][l - 2];
            else if ((t - 1) != 0 && (l - 1) == 0)
                sum = input[b - 1][r - 1] - input[b - 2][r - 1];
            sum = sum % 1000000007;
            while (sum < 0)
                sum += 1000000007;
            output[i] = (int) sum;
        }

        return output;
    }

    static void calMatrixSum(int[][] input) {
        for (int i = 0; i < input.length; ++i) {
            for (int j = 1; j < input[i].length; ++j) {
                input[i][j] = (input[i][j] % 1000000007 + input[i][j - 1] % 1000000007) % 1000000007;
            }
        }
        for (int i = 1; i < input.length; ++i) {
            for (int j = 0; j < input[i].length; ++j) {
                input[i][j] = (input[i][j] % 1000000007 + input[i - 1][j] % 1000000007) % 1000000007;
            }
        }
    }
}