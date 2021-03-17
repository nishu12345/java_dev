package week3.multi_dimensional_arrays;

/*
    Rotate the given matrix by 90 degree.
    Input->
         [1,2,3
          4,5,6
          7,8,9]

    Output->
        [7,4,1
         8,5,2
         9,6,3]
* */
public class ArrayRotation {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transposedMatrix = transposeMatrix(arr);
        for (int[] num : transposedMatrix) {
            reverseArray(num, 0, num.length - 1);
        }
        for (int[] numArray : transposedMatrix) {
            for (int num : numArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transposeMatrix(int[][] input) {
        for (int i = 0; i < input.length; ++i) {
            for (int j = i; j < input[i].length; ++j) {
                if (i != j) {
                    input[i][j] = input[i][j] + input[j][i];
                    input[j][i] = input[i][j] - input[j][i];
                    input[i][j] = input[i][j] - input[j][i];
                }
            }
        }
        return input;
    }

    public static int[] reverseArray(int[] input, int start, int end) {
        int limit = start + ((end + 1 - start) / 2);
        for (int i = 0; i < limit; i++) {
            input[end] = input[i] + input[end];
            input[i] = input[end] - input[i];
            input[end] = input[end] - input[i];
        }
        return input;
    }
}
