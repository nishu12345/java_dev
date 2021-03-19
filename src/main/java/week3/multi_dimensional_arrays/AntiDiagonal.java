package week3.multi_dimensional_arrays;

import java.util.ArrayList;
import java.util.List;

/*
    Give a N*N square matrix, return an array of its anti-diagonals
    Input->
        [1,2,3
         4,5,6
         7,8,9]
    Output->
        [1
         2,4
         3,5,7
         6,8
         9]
* */
public class AntiDiagonal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> listInput = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        listInput.add(temp);
        temp = new ArrayList<>();
        temp.add(4);
        temp.add(5);
        temp.add(6);
        listInput.add(temp);
        temp = new ArrayList<>();
        temp.add(7);
        temp.add(8);
        temp.add(9);
        listInput.add(temp);
        ArrayList<ArrayList<Integer>> outputInList = antiDiagonalWithList(listInput);
        for (List<Integer> numList : outputInList) {
            for (Integer num : numList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        int[][] arrayInput = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] outputInArray = antiDiagonalWithArrays(arrayInput);
        for (int[] numArray : outputInArray) {
            for (int num : numArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> antiDiagonalWithList(ArrayList<ArrayList<Integer>> input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < input.size(); ++i) {
            for (int j = 0; j < input.size(); ++j) {
                if (output.size() > (i + j)) {
                    List<Integer> integers = output.get((i + j));
                    integers.add(input.get(i).get(j));
                } else {
                    ArrayList<Integer> temp = new ArrayList();
                    temp.add(input.get(i).get(j));
                    output.add((i + j), temp);
                }

            }
        }
        return output;
    }


    private static int[][] antiDiagonalWithArrays(int[][] A) {
        int length = A.length;
        int[][] output = new int[length * 2 - 1][length];
        for (int i = 0; i < output.length; ++i) {
            if (i < A.length)
                output[i] = new int[i + 1];
            else
                output[i] = new int[output.length - i];
        }
        int top = 0, right = length - 1;
        int row = 0, col = 0;
        while (top < length && length >= 0) {
            for (int i = 0; i <= right; ++i) {
                output[col][row] = A[top][i];
                ++col;
            }
            ++top;
            for (int i = top; i < length; ++i) {
                output[col][row] = A[i][right];
                col++;
            }
            --right;
            ++row;
            col = row;
        }
        return output;
    }

}
