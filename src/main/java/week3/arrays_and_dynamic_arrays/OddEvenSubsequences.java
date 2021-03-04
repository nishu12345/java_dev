package week3.arrays_and_dynamic_arrays;

/*
* Given an array of integers A of size N. Find the longest subsequence of A which is odd-even.
* A subsequence is said to odd-even in the following cases:
* The first element of the subsequence is odd, second element is even, third element is odd and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]
* The first element of the subsequence is even, second element is odd, third element is even and so on. For example: [10, 5, 2, 1, 4, 7], [10, 1, 2, 3, 4]
* Return the maximum possible length of odd-even subsequence.
* Input:
*    A = [1, 2, 2, 5, 6]
* Output:
*    4
* Explanation:
        Maximum length odd even subsequence is [1, 2, 5, 6]
* */
public class OddEvenSubsequences {
    public static void main(String[] args) {
        int maxOddEvenSubSequence = calculateMaxOddEvenSubSequence(new int[]{1, 2, 2, 5, 6});
        System.out.println(maxOddEvenSubSequence);
    }

    public static int calculateMaxOddEvenSubSequence(int[] A) {
        int count = 1;
        int num = A[0] % 2;
        for (int i = 1; i < A.length; ++i) {
            if ((num == 0) && (A[i] % 2 == 1)) {
                ++count;
                num = 1;
            } else if ((num == 1) && (A[i] % 2 == 0)) {
                ++count;
                num = 0;
            }
        }
        return count;
    }
}
