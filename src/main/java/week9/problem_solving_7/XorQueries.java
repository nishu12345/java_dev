package week9.problem_solving_7;

/*
    You are given an array A (containing only 0 and 1) as element of N length.
    Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive)
    and number of unset bits (0's) in the given range of the array.
    Input->
        A = [1,0,0,0,1]
        B = [[2,4],
             [1,5],
             [3,5]]
   Output->
        [[0,3],
         [0,3],
         [1,2]]
   Explanation->
        For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3.
*/
public class XorQueries {

    public static void main(String[] args) {
//        int[][] xorResults = getXorResults(new int[]{1, 0, 0, 0, 1}, new int[][]{{2, 4}, {1, 5}, {3, 5}});
        int[][] xorResults = getXorResultsBetter(new int[]{1, 0, 0, 0, 1}, new int[][]{{2, 4}, {1, 5}, {3, 5}});
        for (int[] results : xorResults) {
            for (int num : results) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[][] getXorResults(int[] input, int[][] queries) {
        int[][] output = new int[queries.length][2];
        for (int i = 0; i < queries.length; ++i) {
            int start = queries[i][0] - 1;
            int end = queries[i][1];
            int xor = 0;
            int xeroCount = 0;
            for (int j = start; j < end; ++j) {
                xor ^= input[j];
                if (input[j] == 0)
                    xeroCount++;
            }
            output[i] = new int[]{xor, xeroCount};
        }
        return output;
    }

    public static int[][] getXorResultsBetter(int[] input, int[][] queries) {
        int[][] output = new int[queries.length][2];
//        calculate prefix count of 1's
        for (int i = 1; i < input.length; ++i) {
            if (input[i] == 1)
                input[i] = input[i - 1] + 1;
            else
                input[i] = input[i - 1];
        }

        for (int i = 0; i < queries.length; ++i) {
            int startIndex = queries[i][0] - 1;
            int endIndex = queries[i][1] - 1;
            int oneCount = input[endIndex];
            int zeroCount = endIndex + 1 - oneCount;
            if (startIndex != 0) {
                int tempOneCount = input[startIndex - 1];
                int tempZeroCount = startIndex - tempOneCount;
                oneCount -= tempOneCount;
                zeroCount -= tempZeroCount;
            }
            if (oneCount % 2 == 1 && zeroCount % 2 == 1)
                output[i] = new int[]{1, zeroCount};
            else if (oneCount % 2 == 1 && zeroCount % 2 == 0)
                output[i] = new int[]{1, zeroCount};
            else output[i] = new int[]{0, zeroCount};
        }

        return output;
    }
}
