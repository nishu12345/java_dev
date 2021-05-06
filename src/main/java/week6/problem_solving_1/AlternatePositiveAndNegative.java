package week6.problem_solving_1;

/*
    Given an array of integers A, arrange them in an alternate fashion such that every non-negative number
    is followed by negative and vice-versa, starting from a negative number, maintaining the order of appearance.
    The number of non-negative and negative numbers need not be equal.
    If there are more non-negative numbers they appear at the end of the array. If there are more negative numbers,
    they too appear at the end of the array.
    Note: Try solving with O(1) extra space.
    Input->
        [-1,-2,-3,4,5]
    Output->
        [-1,-4,-2,5,-3]
*/
public class AlternatePositiveAndNegative {

    public static void main(String[] args) {
        int[] input = {-1, -2, -3, 4, 5};
        for (int i = 0; i < input.length; ++i) {
            if (i % 2 == 0 && input[i] >= 0) {
                int end = -1;
                int temp = i + 1;
                while (temp < input.length) {
                    if (input[temp] < 0) {
                        end = temp;
                        break;
                    } else
                        ++temp;
                }
                if (end != -1) {
                    rotate(input, i, end);
                }
            } else if (i % 2 == 1 && input[i] < 0) {
                int end = -1;
                int temp = i + 1;
                while (temp < input.length) {
                    if (input[temp] >= 0) {
                        end = temp;
                        break;
                    }
                    ++temp;
                }
                if (end != -1)
                    rotate(input, i, end);
            }
        }
        for (int num : input) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] input, int start, int end) {
        reverse(input, start, end);
        reverse(input, start + 1, end);
    }

    public static void reverse(int[] input, int start, int end) {
        int limit = start + ((end + 1) - start) / 2;
        for (int i = start; i < limit; ++i) {
            input[i] = input[i] + input[end];
            input[end] = input[i] - input[end];
            input[i] = input[i] - input[end];
            --end;
        }
    }
}
