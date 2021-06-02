package week8.problem_solving_6;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] mergedSorted = mergeSortedArray(new int[]{4, 7, 9}, new int[]{2, 11, 19});
        for (int num : mergedSorted)
            System.out.print(num + " ");
    }

    public static int[] mergeSortedArray(int[] inputA, int[] inputB) {
        int[] output = new int[inputA.length + inputB.length];
        int aPointer = 0;
        int bPointer = 0;
        int outputPointer = 0;
        while (outputPointer < output.length) {
            if (aPointer >= inputA.length && bPointer < inputB.length)
                output[outputPointer++] = inputB[bPointer++];
            else if (bPointer >= inputB.length && aPointer < inputA.length)
                output[outputPointer++] = inputA[aPointer++];
            else if (inputA[aPointer] <= inputB[bPointer])
                output[outputPointer++] = inputA[aPointer++];
            else output[outputPointer++] = inputB[bPointer++];
        }
        return output;
    }
}
