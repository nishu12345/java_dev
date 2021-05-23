package week8.problem_solving_4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    You are given an N X N(where N = 2 or N = 3) 2D integer matrix A. You have to find the value of its determinant (det(A) or |A|).
    A = [a, b
         c, d]   |A| = ad - bc
    A = [a, b, c
         d, e, f
         g, h, i]   |A| = a(ei-fh) -b(di-fg) + c(dh-eg)
   Input->
        [[6, 1, 1],
        [4, -2, 5],
        [2, 8, 7]]
   Output->
        -306
   Explanation->
    6 * ((-2) * 7 - 5 * 8) - 1 * (4 * 7 - 5 * 2) + 1 * (4 * 8 - (-2) * 2) = -306

*/
public class FindDeterminant {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindDeterminant.class);

    public static void main(String[] args) {
        int determinant = calDeterminant(new int[][]{{6, 1, 1}, {4, -2, 5}, {2, 8, 7}});
        LOGGER.info("Determinant of given input is {}", determinant);
    }

    public static int calDeterminant(int[][] input) {
        if (input.length == 2)
            return (input[0][0] * input[1][1]) - (input[0][1] * input[1][0]);
        else
            return (input[0][0] * ((input[1][1] * input[2][2]) - (input[1][2] * input[2][1]))) - (input[0][1] * (input[1][0] * input[2][2]) - (input[1][2] * input[2][0]))
                    + (input[0][2] * (input[1][0] * input[2][1]) - (input[1][1] * input[2][0]));
    }
}
