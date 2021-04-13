package week3.introduction_to_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.
    Each element in the result should appear as many times as it shows in both arrays.

    Input->
        A = [2,1,4,10]
        B = [3,6,2,10,10]

    Output->
        [2,10]

*/
public class CommonElements {
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(1);
        input.add(4);
        input.add(10);
        ArrayList<Integer> input2 = new ArrayList<>();
        input2.add(3);
        input2.add(6);
        input2.add(2);
        input2.add(10);
        input2.add(10);
        ArrayList<Integer> commonElements = solve(input, input2);
        for (Integer num : commonElements) {
            System.out.print(num + " ");
        }
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> firstHashedInput = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        for (Integer num : A) {
            if (firstHashedInput.containsKey(num)) {
                firstHashedInput.put(num, firstHashedInput.get(num) + 1);
            } else {
                firstHashedInput.put(num, 1);
            }
        }
        for (Integer num : B) {
            if (firstHashedInput.containsKey(num)) {
                output.add(num);
                if (firstHashedInput.get(num) > 1) {
                    firstHashedInput.put(num, firstHashedInput.get(num) - 1);
                } else {
                    firstHashedInput.remove(num);
                }
            }
        }
        return output;
    }
}
