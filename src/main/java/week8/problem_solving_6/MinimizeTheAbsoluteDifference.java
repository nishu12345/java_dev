package week8.problem_solving_6;

public class MinimizeTheAbsoluteDifference {

    public static void main(String[] args) {
        int minAbsDifference = absoluteDifference(new int[]{1, 4, 5, 8, 10}, new int[]{6, 9, 15}, new int[]{2, 3, 6, 6});
        System.out.println(minAbsDifference);
    }

    public static int absoluteDifference(int[] A, int[] B, int[] C) {
        int max = C[0];
        int[] firstArray = A;
        int[] secondArray = B;
        if (A[0] > B[0] && A[0] > C[0]) {
            max = A[0];
            firstArray = B;
            secondArray = C;
        } else if (B[0] > A[0] && B[0] > C[0]) {
            firstArray = A;
            secondArray = C;
            max = B[0];
        }
        int firstArrayPointer = 0;
        int secondArrayPointer = 0;
        int limit = firstArray.length;
        if (secondArray.length < firstArray.length)
            limit = secondArray.length;
        int largestMinimum = Integer.MAX_VALUE;
        while (firstArrayPointer < limit && secondArrayPointer < limit) {
            if (firstArray[firstArrayPointer] <= secondArray[secondArrayPointer]) {
                if(firstArray[firstArrayPointer] < largestMinimum)
                    largestMinimum = firstArray[firstArrayPointer];
                firstArrayPointer++;
            } else if (secondArray[secondArrayPointer] < firstArray[firstArrayPointer]) {
                int tempDiff = Math.abs(max - secondArray[secondArrayPointer]);
                if (tempDiff < largestMinimum)
                    largestMinimum = tempDiff;
                secondArrayPointer++;
            }
            if (largestMinimum == 0)
                break;

        }
        return largestMinimum;

    }
}
