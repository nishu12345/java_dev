package week11.searchingOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*  Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches
    for integer B in matrix A. This matrix A has the following properties:
        Integers in each row are sorted from left to right.
        The first integer of each row is greater than or equal to the last integer of the previous row.
    Return 1 if B is present in A, else return 0.
    Input ->   [[1,3,5,7],
                [10,11,16,20],
                [23,30,34,50]]
    elementToSearch -> 3
    Output -> 1
    Explanation -> 3 is present in the matrix at A[0][1] position so return 1.
*/
public class MatrixSearch {
    private static final Logger LOGGER = LoggerFactory.getLogger(MatrixSearch.class);

    public static void main(String[] args) {
        int[][] input = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int elementToSearch = 3;
        int rowToSearch = getRowToSearch(input, elementToSearch);
        int isElementPresent = performBinarySearch(input[rowToSearch], elementToSearch);
        LOGGER.info("Is {} present in given input? {}", elementToSearch, isElementPresent);
    }

    public static int getRowToSearch(int[][] input, int elementToSearch) {
        int start = 0, mid, end = input.length - 1;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (input[mid][0] <= elementToSearch && input[mid][input[mid].length - 1] >= elementToSearch)
                return mid;
            else if (input[mid][0] > elementToSearch)
                end = mid - 1;
            else start = mid + 1;
        }
        return 0;
    }

    public static int performBinarySearch(int[] input, int elementToSearch) {
        int start = 0, mid, end = input.length - 1;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (input[mid] == elementToSearch)
                return 1;
            else if (input[mid] > elementToSearch)
                end = mid - 1;
            else start = mid + 1;
        }
        return 0;
    }
}
