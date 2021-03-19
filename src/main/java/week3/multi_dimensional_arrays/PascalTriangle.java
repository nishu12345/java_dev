package week3.multi_dimensional_arrays;

public class PascalTriangle {

    public static void main(String[] args) {
        int[][] pascalTriangle = createPascalTriangle(6);
        for (int[] numArray : pascalTriangle) {
            for (int num : numArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createPascalTriangle(int num) {
        int[][] output = new int[num][];
        output[0] = new int[]{1};
        for (int i = 1; i < output.length; ++i) {
            int[] temp = new int[i + 1];
            output[i] = temp;
            for (int j = 0; j < temp.length; ++j) {
                int above = 0, left_above = 0;
                if (j != temp.length - 1) {
                    above = output[i - 1][j];
                }
                if (j != 0) {
                    left_above = output[i - 1][j - 1];
                }
                output[i][j] = above + left_above;
            }
        }
        return output;
    }
}
