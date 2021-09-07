package week11.bitManipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
    For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively.
    The first and the third bit differ, so f(2, 7) = 2.
    You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N.
    Return the answer modulo 1000000007.

    Input -> [1,3,5]
    Output -> 8
    Explanation ->
    f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5)
     = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
*/
public class BitSumPairWise {
    private static final Logger LOGGER = LoggerFactory.getLogger(BitSumPairWise.class);

    public static void main(String[] args) {
        int differentBitSum = calDiffBitSum_Better(new int[]{1, 3, 5, 7, 9});
        LOGGER.info("Different Bit Sum Pair Wise in given input is {}", differentBitSum);
    }

    public static int calDifferentBitSum(int[] input) {
        int sum = 0;
        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input.length; ++j) {
                int xor = input[i] ^ input[j];
                sum += calSetBits(xor);
            }
        }
        return sum;
    }

    public static int calDiffBitSum_Better(int[] input) {
        long sum = 0;
        for (int i = 0; i < 31; ++i) {
            long oneCount = 0;
            long zeroCount = 0;
            for (int j = 0; j < input.length; ++j) {
                int isBitSet = isSetBit(input[j], i);
                if (isBitSet == 1)
                    ++oneCount;
                else ++zeroCount;
            }
            sum = (sum % 1000000007 + (oneCount % 1000000007 * zeroCount % 1000000007 * 2)) % 1000000007;
        }
        sum = sum % 1000000007;
        return (int) sum;
    }

    private static int calSetBits(int num) {
        int totalSetBits = 0;
        for (int i = 0; i < 30; ++i) {
            if ((num & (1 << i)) > 0)
                ++totalSetBits;
        }
        return totalSetBits;
    }

    private static int isSetBit(int num, int position) {
        if ((num & (1 << position)) > 0)
            return 1;
        return 0;
    }
}
