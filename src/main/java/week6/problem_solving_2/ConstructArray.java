package week6.problem_solving_2;

import java.util.ArrayList;
import java.util.Collections;

/*
    Simba has an integer array of length A. Despite having insisted alot, He is not ready to reveal the array to his friend Expert.
    But now, he is ready to reveal some hints about the array and challenges Expert to find the values of his hidden array. The hints revealed are as follows:
        The array is sorted by values in ascending order.
        All the elements in the array are distinct and positive (greater than 0).
        The array contains two elements B and C such that B < C.
        Difference between all adjacent (consecutive) elements are equal.
        Among all the arrays satisfying the above conditions, his array has the minimum possible maximum element value.
        If there are multiple possible arrays, his array will have minimum possible minimum element value.
    Can you help Expert to construct such an array and surprise Simba?
    Input->
        A = 5
        B = 20
        C = 50
    Output->
         [10, 20, 30, 40, 50]
    Explanation->
       Sorted array = [10, 20, 30, 40, 50] satisfies all the conditions having maximum value = 50 minimum possible.
       Other arrays such as [20, 30, 40, 50, 60] having max value = 60 or [20, 50, 80, 120] having max value = 120,
       also satisfy conditions but their maximum value is not minimum possible(As minimum possible max value is 50).
*/
public class ConstructArray {
    public static void main(String[] args) {
        ArrayList<Integer> generateArray = generateArray(7, 39, 41);
        for (Integer num : generateArray) {
            System.out.print(num + " ");
        }
    }

    public static ArrayList<Integer> generateArray(int A, int B, int C) {
        int difference = C - B;
        ArrayList<Integer> possibleDivisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(difference); ++i) {
            if (difference % i == 0) {
                possibleDivisors.add(i);
                possibleDivisors.add(difference / i);
            }
        }

        Collections.sort(possibleDivisors);
        ArrayList<ArrayList<Integer>> outputList = new ArrayList<>();
        for (int i = 0; i < possibleDivisors.size(); ++i) {
            int divisor = possibleDivisors.get(i);
            ArrayList<Integer> output = new ArrayList<>();
            output.add(C);
            int term = 0;
            int position = 1;
            boolean found = false;
            while (term >= 0 && output.size() < A) {
                term = C - (position * divisor);
                if (term > 0)
                    output.add(term);
                position++;
                if (term == B)
                    found = true;
            }
            if (found && output.size() <= A) {
                if (output.size() == A) {
                    Collections.sort(output);
                    outputList.add(output);
                } else {
                    position = 1;
                    while (output.size() < A) {
                        term = C + (position * divisor);
                        output.add(term);
                        position++;
                    }
                    Collections.sort(output);
                    outputList.add(output);
                }
            }
        }
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MAX_VALUE;
        ArrayList<Integer> finalOutput = new ArrayList<>();
        for (int i = 0; i < outputList.size(); ++i) {
            ArrayList<Integer> tempList = outputList.get(i);
            int min = tempList.get(0);
            int max = tempList.get(tempList.size() - 1);
            if (min <= minValue && max <= maxValue) {
                minValue = min;
                maxValue = max;
                finalOutput = tempList;
            }
        }
        return finalOutput;
    }
}
