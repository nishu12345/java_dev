package week9.problem_solving_7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Given a binary matrix A of integers 0 and 1, of size N x M.
    Find and return the indices of the rows which are duplicate of rows which are already present in the matrix.
    If row[i] and row[j] are same and i < j then answer will contain only index j.
    Note: Rows are numbered from top to bottom and columns are numbered from left to right.
    There will be at least one duplicate row in the matrix.
    Input->
        [[1,0,0],
         [0,1,0],
         [0,1,0]]
    Output->
        3
*/
public class DuplicateRowsInBinaryMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        firstRow.add(0);
        firstRow.add(0);
        input.add(firstRow);
        ArrayList<Integer> secondRow = new ArrayList<>();
        secondRow.add(0);
        secondRow.add(1);
        secondRow.add(0);
        input.add(secondRow);
        ArrayList<Integer> thirdRow = new ArrayList<>();
        thirdRow.add(0);
        thirdRow.add(1);
        thirdRow.add(0);
        input.add(thirdRow);
        ArrayList<Integer> duplicateRows = getDuplicateRows(input);
        for (Integer num : duplicateRows)
            System.out.print(num);
    }

    public static ArrayList<Integer> getDuplicateRows(ArrayList<ArrayList<Integer>> input) {
        ArrayList<Integer> output = new ArrayList<>();
        Map<String, Integer> hashed = new HashMap<>();
        for (int i = 0; i < input.size(); ++i) {
            StringBuffer str = new StringBuffer();
            for (int j = 0; j < input.get(i).size(); ++j) {
                str.append(input.get(i).get(j));
            }
            if (hashed.containsKey(str.toString()))
                output.add(i+1);
            else hashed.put(str.toString(), -1);

        }
        return output;
    }
}
