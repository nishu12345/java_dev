package week9.problem_solving_7;

import java.util.ArrayList;

/*
    Given an index k, return the kth row of the Pascal's triangle.
    Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
                            1
                           1 1
                          1 2 1
                         1 3 3 1
                        1 4 6 4 1
                      1 5 10 10 5 1
                    1 6 15 20 15 6 1
    Input->
        5
    Output-> [1, 5, 10, 10, 5, 1]
*/
public class PascalTriangle {

    public static void main(String[] args) {
        ArrayList<Integer> pascalTriangle = getPascalTriangle(6);
        for (Integer num : pascalTriangle)
            System.out.print(num + " ");
    }

    public static ArrayList<Integer> getPascalTriangle(int input) {
        ArrayList<Integer> output = new ArrayList<>();
        output.add(1);
        if (input == 0)
            return output;
        output.add(1);
        for (int i = 2; i <= input; ++i) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < output.size(); ++j) {
                if (j == 0)
                    temp.add(output.get(j));
                else if (j == output.size() - 1) {
                    temp.add(output.get(j) + output.get(j - 1));
                    temp.add(output.get(j));
                } else temp.add(output.get(j) + output.get(j - 1));
            }
            output = temp;
        }
        return output;
    }
}
