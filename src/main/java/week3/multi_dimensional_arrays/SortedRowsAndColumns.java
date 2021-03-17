package week3.multi_dimensional_arrays;

/*
    Given a 2D matrix all rows and columns are sorted.
    Search a given target in the matrix.
    Input->
        [ 5 10 15 20
          6 12 20 23
          7 14 21 30
         17 26 33 48]
         target1 = 14
         target2 = 49

    Output->
        For target1 -> true
        For target2 -> false
* */
public class SortedRowsAndColumns {
    public static void main(String[] args) {
        int[][] arr = {{5, 10, 15, 20}, {6, 12, 20, 23}, {7, 14, 21, 30}, {17, 26, 33, 48}};
        System.out.println(findTargetInSortedMatrix(arr, 14));
        System.out.println(findTargetInSortedMatrix(arr, 49));
    }

    public static boolean findTargetInSortedMatrix(int[][] input, int target) {
        int row = 0, col = input.length - 1;
        while (row < input.length && col >= 0) {
            if (input[row][col] == target) {
                return true;
            } else if (input[row][col] > target) {
                --col;
            } else
                ++row;
        }
        return false;
    }
}
