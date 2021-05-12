package week7.basics_of_maths;

import java.util.ArrayList;

/*
    Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
    Input->
        [3,2,0,1]
    Output->
        [1,0,3,2]
    Explanation->
        for i = 0, input[i] = 3, and input[3] = 1 sor input[0] = 1
        for i = 1, input[i] = 2, and input[2] = 0 sor input[1] = 0
        for i = 2, input[i] = 0, and input[0] = 3 sor input[2] = 3
        for i = 3, input[i] = 1, and input[1] = 2 sor input[3] = 2
*/
public class RearrangeArray {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(2);
        input.add(0);
        input.add(1);
        reArrange(input);
        for (Integer output : input)
            System.out.print(output + " ");
    }
    public static void reArrange(ArrayList<Integer> input) {
        int size = input.size();
        for (int i = 0; i < size; ++i) {
            int current = input.get(i);
            input.remove(i);
            input.add(i, current * size);
        }
        for (int i = 0; i < size; ++i) {
            int originalIndex = input.get(i) / size;
            int outputIndex = input.get(originalIndex) / size;
            int current = input.get(i);
            input.remove(i);
            input.add(i, current + outputIndex);
        }
        for (int i = 0; i < size; ++i) {
            int current = input.get(i);
            input.remove(i);
            input.add(i, current % size);
        }
    }
}
