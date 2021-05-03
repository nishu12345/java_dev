package week5.more_problems_on_recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
    NOTE:
        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        The subsets must be sorted lexicographically.

    Input ->  [1, 2, 2]
    Output->
        [
           [],
           [1],
           [1, 2],
           [1, 2, 2],
           [2],
           [2, 2]
        ]
*/
public class Subset2 {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(2);
        ArrayList<ArrayList<Integer>> output = createSubs(input, 0);
        for (ArrayList<Integer> list : output) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    public static ArrayList<ArrayList<Integer>> createSubs(ArrayList<Integer> input, int index) {
        if (index == input.size() - 1) {
            ArrayList<ArrayList<Integer>> output = new ArrayList<>();
            ArrayList<Integer> empty = new ArrayList<>();
            output.add(empty);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(input.get(index));
            output.add(temp);
            return output;
        }

        ArrayList<ArrayList<Integer>> previousOutput = createSubs(input, index + 1);
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        if (index != input.size() - 1) {
            ArrayList<Integer> empty = new ArrayList<>();
            output.add(empty);
        }

        Map<ArrayList<Integer>, Boolean> hashed = new HashMap<>();
        for (int i = 0; i < previousOutput.size(); ++i) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(input.get(index));
            ArrayList<Integer> temp1 = previousOutput.get(i);
            if (temp1.size() > 0) {
                for (int j = 0; j < temp1.size(); ++j) {
                    temp.add(temp1.get(j));
                }
            }
            output.add(temp);
            hashed.put(temp, true);
        }
        for (int k = 1; k < previousOutput.size(); ++k) {
            if (!hashed.containsKey(previousOutput.get(k)))
                output.add(previousOutput.get(k));
        }
        return output;
    }
}
