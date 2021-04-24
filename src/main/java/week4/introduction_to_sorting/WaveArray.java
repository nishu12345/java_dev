package week4.introduction_to_sorting;

import java.util.Arrays;

/*
    Given an array of integers A, sort the array into a wave like array and return it,
    In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
    NOTE : If there are multiple answers possible, return the one that's lexicographically smallest.
    Input->
        [5,1,3,2,4]
    Output->
        [2,1,4,2,5]
*/
public class WaveArray {
    public static void main(String[] args) {
        int[] input = {5, 1, 3, 2, 4};
        Arrays.sort(input);
        int[] inWaveForm = sortInWaveForm(input);
        for (int num : inWaveForm) {
            System.out.print(num + " ");
        }
    }

    public static int[] sortInWaveForm(int[] input) {
        for (int i = 0; i < input.length - 1; i += 2)
            swap(input, i);
        return input;
    }

    public static void swap(int[] input, int index) {
        input[index] = input[index] + input[index + 1];
        input[index + 1] = input[index] - input[index + 1];
        input[index] = input[index] - input[index + 1];
    }
}
