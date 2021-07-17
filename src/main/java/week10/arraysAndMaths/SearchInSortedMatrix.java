package week10.arraysAndMaths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    Given a matrix of integers A of size N x M and an integer B.
    In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
    If A[i][j] = B then return (i * 1009 + j)
    If B is not present return -1.
    Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
    Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
    Input->
       A = [{1,2,3},
            {4,5,6},
            {7,8,9}]
       B = 2
   Output -> 1011
   Explanation->
        A[1][2]= 2
        1*1009 + 2 =1011

*/
public class SearchInSortedMatrix {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchInSortedMatrix.class);

    public static void main(String[] args) {
        int position = findPosition(new int[][]{{1, 2, 3}, {4, 5, 6}}, 4);
        LOGGER.info("Position of given number is {}", position);
    }

    public static int findPosition(int[][] input, int num) {
        int i = 0;
        int j = input[0].length - 1;
        int output = -1;
        while (i < input.length && j >= 0) {
            if (input[i][j] == num) {
                output = (i + 1) * 1009 + (j + 1);
                while (j >= 0) {
                    if (input[i][j] == num)
                        output = (i + 1) * 1009 + (j + 1);
                    --j;
                }
                break;
            } else if (input[i][j] > num)
                --j;
            else ++i;
        }
        return output;
    }
}
