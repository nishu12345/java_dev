package week4.introduction_to_sorting;


/*
    Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
    with the colors in the order red, white and blue.
    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
    Input->
        [0 1 2 0 1 2]
    Output->
         [0 0 1 1 2 2]

*/
public class SortByColor {
    public static void main(String[] args) {
        int[] sortedByColor = sortByColor(new int[]{0, 1, 2, 0, 1, 2});
        for (int num : sortedByColor) {
            System.out.print(num + " ");
        }
    }

    public static int[] sortByColor(int[] input) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int num : input) {
            if (num == 0)
                ++zero;
            else if (num == 1)
                ++one;
            else ++two;
        }
        int i = 0;
        while (zero > 0) {
            input[i++] = 0;
            --zero;
        }
        while (one > 0) {
            input[i++] = 1;
            --one;
        }
        while (two > 0) {
            input[i++] = 2;
            --two;
        }
        return input;
    }
}
