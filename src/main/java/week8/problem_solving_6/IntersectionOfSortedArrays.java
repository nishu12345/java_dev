package week8.problem_solving_6;

import java.util.ArrayList;

/*
    Find the intersection of two sorted arrays. OR in other words, Given 2 sorted arrays, find all the elements which occur in both the arrays.
    Input->
        A : [1 2 3 3 4 5 6]
        B : [3 3 5]
    Output->
        [3 3 5]

*/
public class IntersectionOfSortedArrays {

    public static void main(String[] args) {
        ArrayList<Integer> inputA = new ArrayList<>();
        inputA.add(10000000);
        ArrayList<Integer> inputB = new ArrayList<>();
        inputB.add(10000000);
        ArrayList<Integer> commonElements = getCommonElements(inputA, inputB);
        for (int num : commonElements)
            System.out.print(num + " ");
    }

    public static ArrayList<Integer> getCommonElements(ArrayList<Integer> inputA, ArrayList<Integer> inputB) {
        ArrayList<Integer> output = new ArrayList<>();
        int firstPointer = 0, secondPointer = 0;
        while (firstPointer < inputA.size() && secondPointer < inputB.size()) {
            if (inputA.get(firstPointer).equals(inputB.get(secondPointer))) {
                output.add(inputA.get(firstPointer));
                firstPointer++;
                secondPointer++;
            } else if (inputA.get(firstPointer) < inputB.get(secondPointer))
                firstPointer++;
            else secondPointer++;
        }
        return output;
    }
}
