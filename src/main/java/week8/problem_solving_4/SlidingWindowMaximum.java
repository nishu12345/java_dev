package week8.problem_solving_4;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
    Given an array of integers A. There is a sliding window of size B which is moving from the very left of the array to the very right.
    You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
    Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
    Refer to the given example for clarity.
    NOTE: If B > length of the array, return 1 element with the max of the array.
    Input->
        [1,3,-1,-3,5,3,6,7]
    Output->
        [3,3,5,5,6,7]
    Explanation->
        Window position     | Max
        --------------------|-------
        [1 3 -1] -3 5 3 6 7 | 3
        1 [3 -1 -3] 5 3 6 7 | 3
        1 3 [-1 -3 5] 3 6 7 | 5
        1 3 -1 [-3 5 3] 6 7 | 5
        1 3 -1 -3 [5 3 6] 7 | 6
        1 3 -1 -3 5 [3 6 7] | 7
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(-1);
        input.add(-3);
        input.add(5);
        input.add(3);
        input.add(6);
        input.add(7);
        ArrayList<Integer> maximumNumArray = maximumNumArray(input, 3);
        for (int num : maximumNumArray)
            System.out.print(num + " ");
    }

    public static ArrayList<Integer> maximumNumArray(ArrayList<Integer> input, int windowSize) {
        if (windowSize == 1)
            return input;
        ArrayList<Integer> output = new ArrayList<>();
        Deque<Integer> deck = new LinkedList<>();
        for (int i = 0; i < windowSize; ++i) {
            if (deck.size() == 0)
                deck.addFirst(i);
            else {
                while (deck.size() != 0 && input.get(deck.getLast()) < input.get(i))
                    deck.removeLast();
                deck.addLast(i);
            }
        }
        output.add(input.get(deck.getFirst()));
        for (int i = windowSize; i < input.size(); ++i) {
            deck.remove(i - windowSize);
            while (deck.size() != 0 && input.get(deck.getLast()) < input.get(i))
                deck.removeLast();
            deck.addLast(i);
            output.add(input.get(deck.getFirst()));
        }
        return output;
    }
}
