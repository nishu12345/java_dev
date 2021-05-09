package week6.problem_solving_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.
    NOTE:
        Each element in the result should appear as many times as it shows in both arrays.
        The result can be in any order.
    Input->
         A = [1, 2, 2, 1]
         B = [2, 3, 1, 2]
    Output->
        [1,2,2]
    Explanation->
         Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
*/
public class CommonElements {
    public static void main(String[] args) {
        ArrayList<Integer> inputA = new ArrayList<>();
        inputA.add(2);
        inputA.add(1);
        inputA.add(4);
        inputA.add(10);
        ArrayList<Integer> inputB = new ArrayList<>();
        inputB.add(3);
        inputB.add(6);
        inputB.add(2);
        inputB.add(10);
        inputB.add(10);
        ArrayList<Integer> commonElements = commonElements(inputA, inputB);
        for (Integer num : commonElements)
            System.out.print(num + " ");
    }

    public static ArrayList<Integer> commonElements(ArrayList<Integer> inputA, ArrayList<Integer> inputB) {
        ArrayList<Integer> output = new ArrayList<>();
        Map<Integer, Integer> hashed = new HashMap<>();
        if (inputA.size() >= inputB.size()) {
            for (Integer num : inputA) {
                if (hashed.containsKey(num))
                    hashed.put(num, hashed.get(num) + 1);
                else hashed.put(num, 1);
            }
            for (Integer num1 : inputB) {
                if (hashed.containsKey(num1)) {
                    output.add(num1);
                    if (hashed.get(num1) == 1)
                        hashed.remove(num1);
                    else hashed.put(num1, hashed.get(num1) - 1);
                }
            }
        } else {
            for (Integer num : inputB) {
                if (hashed.containsKey(num))
                    hashed.put(num, hashed.get(num) + 1);
                else hashed.put(num, 1);
            }
            for (Integer num1 : inputA) {
                if (hashed.containsKey(num1)) {
                    output.add(num1);
                    if (hashed.get(num1) == 1)
                        hashed.remove(num1);
                    else hashed.put(num1, hashed.get(num1) - 1);
                }
            }
        }
        return output;
    }
}
