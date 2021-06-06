package week8.problem_solving_6;

/*
    Given a 2D Matrix A of dimensions N*N, we need to return sum of all possible sub-matrices.
    Input->
        A = [ [1, 1]
              [1, 1] ]
    Output->
        16
    Explanation->
        Number of sub-matrices with 1 elements = 4, so sum of all such sub-matrices = 4 * 1 = 4
        Number of sub-matrices with 2 elements = 4, so sum of all such sub-matrices = 4 * 2 = 8
        Number of sub-matrices with 3 elements = 0
        Number of sub-matrices with 4 elements = 1, so sum of such sub-matrix = 4
        Total Sum = 4+8+4 = 16


*/
public class SumOfAllSubMatrices {

    public static void main(String[] args) {
//        int sumOfSubMatrix = sumOfSubMatrix(new int[][]{{8, 9, 9, 1, 7}, {5, 5, 10, 1, 0}, {7, 7, 5, 8, 6}, {7, 3, 7, 9, 2}, {7, 7, 8, 10, 6}});
//        int sumOfSubMatrix = sumOfSubMatrixBetter(new int[][]{{8, 9, 9, 1, 7}, {5, 5, 10, 1, 0}, {7, 7, 5, 8, 6}, {7, 3, 7, 9, 2}, {7, 7, 8, 10, 6}});
        int sumOfSubMatrix = sumOfSubMatrixBest(new int[][]{{8, 9, 9, 1, 7}, {5, 5, 10, 1, 0}, {7, 7, 5, 8, 6}, {7, 3, 7, 9, 2}, {7, 7, 8, 10, 6}});
        System.out.println(sumOfSubMatrix);
    }

    /*--------Time Complexity - O(n^6)------------*/
    public static int sumOfSubMatrix(int[][] input) {
        int sum = 0;
        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[i].length; ++j) {
                int topLeft = input[i][j];
                for (int k = i; k < input.length; ++k) {
                    for (int l = j; l < input.length; ++l) {
                        int bottomRight = input[k][l];
                        for (int x = i; x <= k; x++) {
                            for (int y = j; y <= l; ++y) {
                                sum += input[x][y];
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    /*--------Time Complexity - O(n^4)------------*/
    public static int sumOfSubMatrixBetter(int[][] input) {
        //row sum
        for (int i = 0; i < input.length; ++i) {
            for (int j = 1; j < input[i].length; ++j) {
                input[i][j] += input[i][j - 1];
            }
        }

        //column sum
        for (int i = 1; i < input.length; ++i) {
            for (int j = 0; j < input[i].length; ++j) {
                input[i][j] += input[i - 1][j];
            }
        }
        int sum = 0;
        for (int t = 0; t < input.length; ++t) {
            for (int l = 0; l < input[t].length; ++l) {
                int topLeft = input[t][l];
                for (int b = t; b < input.length; ++b) {
                    for (int r = l; r < input[b].length; ++r) {
                        int bottomRight = input[b][r];
                        sum += calculateSum(input, t, l, b, r);
                    }
                }
            }
        }
        return sum;
    }

    public static int calculateSum(int[][] input, int top, int left, int bottom, int right) {
        int sum = 0;
        if (top != 0 && left != 0) {
            sum = (input[bottom][right] + input[top - 1][left - 1]) - (input[top - 1][right] + input[bottom][left - 1]);
        } else if (top == 0 && left == 0) {
            sum = input[bottom][right];
        } else if (top == 0 && left != 0) {
            sum = input[bottom][right] - input[bottom][left - 1];
        } else if (left == 0 && top != 0) {
            sum = input[bottom][right] - input[top - 1][right];
        }
        return sum;
    }

    /*--------Time Complexity - O(n^2)------------*/
    public static int sumOfSubMatrixBest(int[][] input) {
        int sum = 0;
        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[i].length; ++j) {
                sum += (input[i][j] * ((i + 1) * (j + 1)) * ((input.length - i) * (input.length - j)));
            }
        }
        return sum;
    }
}
