package week10.timeAndSpacePlusArrays;

/*
    Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
    The digits are stored such that the most significant digit is at the head of the list.
    NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
    For example: for this problem, following are some good questions to ask :
    Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
    A : For the purpose of this question, YES
    Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
    A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
    Input->
        [0,0,9,9,9]
    Output->
        [1,0,0,0]
    Explanation->
        999+1 = 1000
*/
public class AddOneToNumber {

    public static void main(String[] args) {
        int[] addedOne = addOne(new int[]{9, 8, 9});
        for (int num : addedOne)
            System.out.print(num);
    }

    public static int[] addOne(int[] input) {
        if (input[0] == 0) {
            int index = -1;
            for (int i = 0; i < input.length; ++i) {
                if (input[i] != 0) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                int[] modInput = new int[input.length - index];
                for (int j = index; j < input.length; ++j) {
                    modInput[j - index] = input[j];
                }
                return add(modInput);
            } else return new int[]{};
        } else return add(input);
    }

    public static int[] add(int[] input) {
        for (int i = input.length - 1; i >= 0; --i) {
            if (input[i] < 9) {
                input[i] += 1;
                break;
            } else input[i] = 0;
        }
        if (input[0] == 0) {
            input = new int[input.length + 1];
            input[0] = 1;
        }
        return input;
    }
}
