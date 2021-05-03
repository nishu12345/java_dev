package week5.more_problems_on_recursion;

import java.util.ArrayList;

/*
    Given a set of distinct integers, A, return all possible subsets.
    NOTE:
        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        Also, the subsets should be sorted in ascending ( lexicographic ) order.
        The list is not necessarily sorted.
   Input -> [1, 2, 3]
   Output->
        [
             []
             [1]
             [1, 2]
             [1, 2, 3]
             [1, 3]
             [2]
             [2, 3]
             [3]
        ]
*/
public class Subset {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        ArrayList<ArrayList<Integer>> output = createSubSet(input, 0);
        for (ArrayList<Integer> list : output) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> createSubSet(ArrayList<Integer> input, int index) {
        if (index == input.size() - 1) {
            ArrayList<ArrayList<Integer>> output = new ArrayList<>();
            ArrayList<Integer> empty = new ArrayList<>();
            output.add(empty);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(input.get(index));
            output.add(temp);
            return output;
        }
        ArrayList<ArrayList<Integer>> previousOutput = createSubSet(input, index + 1);
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        if (index != input.size() - 1) {
            ArrayList<Integer> empty = new ArrayList<>();
            output.add(empty);
        }
        for (int i = 0; i < previousOutput.size(); ++i) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(input.get(index));
            ArrayList<Integer> temp1 = previousOutput.get(i);
            for (int j = 0; j < temp1.size(); ++j) {
                temp.add(temp1.get(j));
            }
            output.add(temp);
        }
        for (int k = 1; k < previousOutput.size(); ++k) {
            output.add(previousOutput.get(k));
        }
        return output;
    }
}
