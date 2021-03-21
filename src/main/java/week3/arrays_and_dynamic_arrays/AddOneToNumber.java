package week3.arrays_and_dynamic_arrays;

/*
    Given a non-negative number represented as an array of digits, add 1 to the number
    Input->
        [9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9]
        [0, 9, 9, 9]
        [9, 9, 9]
    Output->
        [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
        [1,0,0,0]
        [1,0,0,0]
* */
public class AddOneToNumber {

    public static void main(String[] args) {
        int[] numPlusOne = plusOne(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9});
//        int[] numPlusOne = plusOne(new int[]{9, 9, 9});
//        int[] numPlusOne = plusOne(new int[]{0, 9, 9, 9});
        for (int num : numPlusOne) {
            System.out.print(num + " ");
        }
    }

    public static int[] plusOne(int[] A) {
        int[] output = null;
        int start = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] > 0) {
                start = i;
                break;
            }
        }
        int carryOver = 0;
        A[A.length - 1] += 1;
        for (int i = A.length - 1; i >= start; --i) {
            int temp = A[i] + carryOver;
            if (temp > 9) {
                A[i] = 0;
                carryOver = 1;
            } else {
                A[i] = temp;
                carryOver = 0;
            }
        }
        if (carryOver == 1) {
            int length = A.length - 1;
            output = new int[(A.length + 1) - start];
            output[0] = 1;
            for (int i = output.length - 1; i >= 1; --i) {
                output[i] = A[length--];
            }
        } else {
            int length = A.length - 1;
            output = new int[A.length - start];
            for (int i = output.length - 1; i >= 0; --i) {
                output[i] = A[length--];
            }
        }

        return output;
    }

}
