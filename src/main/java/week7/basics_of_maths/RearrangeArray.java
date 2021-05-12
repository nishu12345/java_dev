package week7.basics_of_maths;

import java.util.ArrayList;

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
