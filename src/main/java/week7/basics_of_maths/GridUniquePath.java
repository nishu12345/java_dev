package week7.basics_of_maths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    A robot is located at the top-left corner of an A x B grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
    How many possible unique paths are there?
    Input->
        A = 2 | B = 2
    Output->
        2
    Explanation->
    2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
                  OR  : (0, 0) -> (1, 0) -> (1, 1)
*/
public class GridUniquePath {
    private static final Logger LOGGER = LoggerFactory.getLogger(GridUniquePath.class);

    public static void main(String[] args) {
        int uniquePaths = totalUniquePaths(2, 2);
        LOGGER.info("Total Unique Paths in given input is {}", uniquePaths);
    }

    public static int totalUniquePaths(int A, int B) {
        int[][] paths = new int[A][B];
        for (int i = 0; i < A; ++i) {
            for (int j = 0; j < B; ++j) {
                if (i == 0 && j == 0)
                    paths[i][j] = 1;
                else if (i == 0)
                    paths[i][j] = paths[i][j - 1];
                else if (j == 0)
                    paths[i][j] = paths[i - 1][j];
                else
                    paths[i][j] =paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[A - 1][B - 1];
    }
}
