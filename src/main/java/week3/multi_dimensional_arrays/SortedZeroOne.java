package week3.multi_dimensional_arrays;

/*
    Given a matrix of 0's and 1's and all the rows are sorted.
    Find the row that have maximum number of 1's.
    Input->
        [0 1 1 1
         0 0 1 1
         1 1 1 1
         0 0 0 0]
    Output->
        2
* */
public class SortedZeroOne {

    public static void main(String[] args) {
//        int[][] arr = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
        int[][] arr = {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}};
        int maxOnesRowIndex = maxOnesRowIndex(arr);
        System.out.println(maxOnesRowIndex);

    }

    public static int maxOnesRowIndex(int[][] input) {
        int output = -1;
        int top = 0, right = input.length - 1;
        while (top <= input.length - 1 && right >= 0) {
            if (input[top][right] == 1) {
                output = top;
                --right;
            } else
                top++;
        }

        return output;
    }
}
